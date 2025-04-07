package seedu.duke.storage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.duke.data.Grade;
import seedu.duke.data.UserMod;
import seedu.duke.errors.ModNotInDatabase;
import seedu.duke.user.EducationLevel;
import seedu.duke.user.User;

public class UserStorage {
    private static final Logger logger = Logger.getLogger(UserStorage.class.getName());

    static {
        logger.setLevel(Level.ALL);
    }

    private final File file;

    public UserStorage(String filepath, String filename) {
        File directory = new File(filepath);
        if (!directory.mkdirs()) {
            logger.info("Directory already exists: " + filepath);
        }
        file = new File(directory, filename);
    }

    public void saveUserData(seedu.duke.user.User user) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            out.write(user.getName() + "\n");
            out.write(user.getEducation().toString() + "\n");
            out.write(user.getCurrentSemester() + "\n");
            out.write((user.isExemptedMA1301() ? "1" : "0") + ",");
            out.write((user.isExemptedPC1101() ? "1" : "0" )+ ",");
            out.write((user.isExemptedEnglish() ? "1" : "0") + "\n");

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
        System.out.println("Loading user data...");
        if (!file.exists()) {
            logger.warning("No existing user data found: " + file.getPath());
            return new User();
        }

        User user = new User();
        try (Scanner scanner = new Scanner(file)) {
            // Read user data
            String name = scanner.nextLine();
            user.setName(name);
            EducationLevel education = EducationLevel.valueOf(scanner.nextLine());
            user.setEducation(education);
            int currentSemester = Integer.parseInt(scanner.nextLine());
            user.setCurrentSemester(currentSemester);

            String[] exemptions = scanner.nextLine().split(",");
            user.setExemptedMA1301("1".equals(exemptions[0]));
            user.setExemptedPC1101("1".equals(exemptions[1]));
            user.setExemptedEnglish("1".equals(exemptions[2]));

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

        } catch (IOException | IllegalArgumentException e) {
            logger.severe("Error loading user data: " + e.getMessage());
        } catch (ModNotInDatabase e) {
            System.out.println("Fail to load module");
            throw new RuntimeException(e);
        } catch (NoSuchElementException e) {
            logger.warning("User data file is empty: " + file.getPath());
            return new User();
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.severe("User data file missing exemptions: " + file.getPath());
        }

        return user;
    }
}
