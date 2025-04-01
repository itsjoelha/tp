package seedu.duke.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.duke.errors.ModNotInDatabase;

public class UserData {
    private static final Logger logger = Logger.getLogger(UserData.class.getName());

    static {
        logger.setLevel(Level.OFF);
    }

    private final File file;

    public UserData(String filepath) {
        this.file = new File(filepath);
        if (!file.exists()) {
            logger.warning("No existing user data found: " + filepath);
        }
    }

    public void saveUserData(User user) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            out.write(/*user.getName()*/"Skibidi" + "\n");
            out.write(/*user.getEducation().toString()*/"JC" + "\n");
            out.write(/*user.getCurrentSemester()*/"1" + "\n");

            for (int semester : user.getSemesterModules().keySet()) {
                for (UserMod mod : user.getSemesterModules().get(semester)) {
                    out.write(semester + "," + mod.getCode() + "," + mod.getGrade() + "," + mod.isSU() +
                             "," + mod.isCustom() + "," + mod.getName() + "," + mod.getNumMC() + "\n");
                }
            }
        } catch (Exception e) {
            logger.severe("Error saving user data: " + e.getMessage());
        }
    }

    public User loadUserData() {
        if (!file.exists()) {
            logger.warning("No existing user data found: " + file.getPath());
            return new User();
        }

        try (Scanner scanner = new Scanner(file)) {
            // Read user data
            String name = scanner.nextLine();
            EducationLevel education = EducationLevel.valueOf(scanner.nextLine());
            int currentSemester = Integer.parseInt(scanner.nextLine());

            User user = new User(name, education);
            user.setCurrentSemester(currentSemester);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",");
                int semester = Integer.parseInt(parts[0]);
                UserMod mod;
                if (parts[4].equals("true")) { //custom module
                    int numMC = Integer.parseInt(parts[6]);
                    mod = new UserMod(parts[1], numMC, parts[5]);
                } else {
                    mod = new UserMod(parts[1]);
                }
                if (!parts[2].equals("null")) {
                    mod.setGrade(Grade.valueOf(parts[2]));
                    mod.setSU(Boolean.parseBoolean(parts[3]));
                }
                user.getSemesterModules().computeIfAbsent(semester, k -> new ArrayList<>()).add(mod);
            }
            user.getGPA();
            return user;
        } catch (IOException | IllegalArgumentException e) {
            logger.severe("Error loading user data: " + e.getMessage());
        } catch (ModNotInDatabase e) {
            System.out.println("Fail to load module");
            throw new RuntimeException(e);
        } catch (NoSuchElementException e) {
            logger.warning("User data file is empty: " + file.getPath());
            return new User();
        }
        return new User();
    }

}
