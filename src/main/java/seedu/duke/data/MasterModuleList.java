package seedu.duke.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MasterModuleList {
    private static final List<Mod> modules = new ArrayList<>();

    static {
        loadModulesFromFile();
    }

    private static void loadModulesFromFile() {
        try (InputStream inputStream = MasterModuleList.class.getClassLoader()
                .getResourceAsStream("moduledata.txt")) {
            if (inputStream == null) {
                System.err.println("File not found: moduledata.txt");
                return;
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,
                    StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length > 10) {
                        modules.add(new Mod(parts[1].trim(), parts[3].trim(),
                                Integer.parseInt(parts[2].trim()), parts[0].trim(),
                                Double.parseDouble(parts[4].trim()), Double.parseDouble(parts[5].trim()),
                                Double.parseDouble(parts[6].trim()), Double.parseDouble(parts[7].trim()),
                                Double.parseDouble(parts[8].trim()), parts[9].trim(), parts[10].trim()));
                    } else {
                        System.err.println("Invalid line format: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to load modules from file: " + e.getMessage());
        }
    }

    public static Mod findModuleByCode(String code){
        for (Mod mod : modules) {
            if (mod.getCode().equals(code)) {
                return mod;
            }
        }
        return null;
    }

    public static List<Mod> getModules() {
        return modules;
    }
}
