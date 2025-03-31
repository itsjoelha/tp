package seedu.duke.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            out.write(user.getName() + "\n");
            out.write(user.getEducation().toString() + "\n");
            out.write(user.getCurrentSemester() + "\n");

            for (int semester : user.getSemesterModules().keySet()) {
                for (UserMod mod : user.getSemesterModules().get(semester)) {
                    out.write(semester + "," + mod.getCode() + "," + mod.getGrade() + "," + mod.isSU() + "\n");
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
            if (scanner.nextLine().isEmpty()) {
                return new User();
            }
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
                UserMod mod = new UserMod(parts[1]);
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
        }
        return new User();
    }

}
