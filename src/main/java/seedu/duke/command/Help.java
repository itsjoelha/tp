package seedu.duke.command;

public class Help {
    public static void displayHelpFile() {
        System.out.println("+-----------------------+-----------------------------------+");
        System.out.println("| Command               | Description                       |");
        System.out.println("+-----------------------+-----------------------------------+");
        System.out.printf("| %-21s | %-33s |\n", "/view", "View all modules");
        System.out.printf("| %-21s | %-33s |\n", "/add <module code>", "Add a module to the list");
        System.out.printf("| %-21s | %-33s |\n", "/delete <module code>", "Delete a module from the list");
        System.out.printf("| %-21s | %-33s |\n", "/detail <module code>", "View details of a module");
        System.out.printf("| %-21s | %-33s |\n", "/grad", "Check if you can graduate");
        System.out.printf("| %-21s | %-33s |\n", "/schedule", "Generate a schedule for students");
        System.out.printf("| %-21s | %-33s |\n", "/specialisation", "View specialisations");
        System.out.printf("| %-21s | %-33s |\n", "/workload", "Display workload");
        System.out.printf("| %-21s | %-33s |\n", "/help", "Show this help message");
        System.out.printf("| %-21s | %-33s |\n", "/exit", "Exit the program");
        System.out.println("+-----------------------+-----------------------------------+");
        System.out.println("For further assistance, refer to the user guide at our GitHub repository.");
    }
}
