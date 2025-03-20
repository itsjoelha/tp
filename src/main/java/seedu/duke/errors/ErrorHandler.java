package seedu.duke.errors;

public class ErrorHandler {

    public static void handleModuleDoesNotExist() {
        System.err.println("[ERROR] Module not found");
    }
}