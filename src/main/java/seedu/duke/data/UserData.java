package seedu.duke.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserData {
    private final File file;

    public UserData(String filepath) {
        this.file = new File(filepath);
        if (!file.exists()) {
            System.out.println("No existing user data found: " + filepath);
        }
    }

    public void saveUserData(User user) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            out.write(/*user.getName()*/ "Skibidi" + "\n");
            out.write(/*"user.getEducation().toString()"*/ "JC" + "\n");
            out.write(user.getCurrentSemester() + "\n");

            for (int semester : user.getSemesterModules().keySet()) {
                for (UserMod mod : user.getSemesterModules().get(semester)) {
                    out.write(semester + "," + mod.getCode() + "," + mod.getGrade() + "," + mod.isSU() + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Error saving user data: " + e.getMessage());
        }
    }

    public User loadUserData() {
        try (Scanner scanner = new Scanner(file)) {
            String name = scanner.nextLine();
            EducationLevel education = EducationLevel.valueOf(scanner.nextLine());
            int currentSemester = Integer.parseInt(scanner.nextLine());

            User user = new User(name, education);
            user.setCurrentSemester(currentSemester);

            while (scanner.hasNextLine()) {
                ArrayList<UserMod> mods = new ArrayList<>();
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                String[] parts = line.split(",");
                int semester = Integer.parseInt(parts[0]);
                UserMod mod = new UserMod(parts[1]);
                if (!parts[2].equals("null")) {
                    mod.setGrade(Grade.valueOf(parts[2]));
                    mod.setSU(Boolean.parseBoolean(parts[3]));
                }
                mods.add(mod);
                user.getSemesterModules().put(semester, mods);
            }
            user.getGPA();

            return user;
        } catch (FileNotFoundException e) {
            System.out.println("Error loading user data: " + e.getMessage());
        }
        return new User();
    }

}
