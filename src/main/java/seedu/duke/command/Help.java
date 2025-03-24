package seedu.duke.command;

public class Help {
    public static void displayHelpFile() {
        System.out.println("Available Commands:");
        System.out.println("/view - View all modules");
        System.out.println("/detail <module code> - View details of a module");
        System.out.println("/add <module code> - Add a module to the list");
        System.out.println("/delete <module code> - Delete a module from the list");
        System.out.println("/grad - Check if you can graduate");
        System.out.println("/schedule - Generate a schedule students");
        System.out.println("/specialisation - View specialisations");
        System.out.println("/workload - Display workload");
        System.out.println("/exit - Exit the program");
        System.out.println("/help - Show this help message");
        System.out.println("For further assistance, refer to the user guide at our GitHub repository.");
    }
}
