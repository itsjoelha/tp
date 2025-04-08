package seedu.duke.command;

public class Help implements Command {
    private final String command;

    public Help() {
        this.command = null;
    }

    public Help(String command) {
        this.command = command;
    }

    public void execute() {
        if (command == null) {
            printAll();
        } else {
            printSpecific(command);
        }
    }

    private void printAll() {
        System.out.println("+--------------------------------+--------------------------------------+");
        System.out.println("| Command                        | Description                          |");
        System.out.println("+--------------------------------+--------------------------------------+");
        System.out.printf("| %-30s | %-36s |\n", "/view", "View all modules");
        System.out.printf("| %-30s | %-36s |\n", "/add <module code>", "Add a module to the list");
        System.out.printf("| %-30s | %-36s |\n", "/addCustom <module code> ...", "Add a custom module to the list");
        System.out.printf("| %-30s | %-36s |\n", "/su <module code>", "S/U a module");
        System.out.printf("| %-30s | %-36s |\n", "/gpa", "Retrieve your GPA");
        System.out.printf("| %-30s | %-36s |\n", "/grade <module code> <grade>", "Set a module's grade");
        System.out.printf("| %-30s | %-36s |\n", "/delete <module code>", "Delete a module from the list");
        System.out.printf("| %-30s | %-36s |\n", "/detail <module code>", "View details of a module");
        System.out.printf("| %-30s | %-36s |\n", "/clear", "Clear all modules from schedule");
        System.out.printf("| %-30s | %-36s |\n", "/grad", "Check if you can graduate");
        System.out.printf("| %-30s | %-36s |\n", "/schedule <jc> or <poly>", "Generate a schedule for students");
        System.out.printf("| %-30s | %-36s |\n", "/waive <module code>", "Waive the prerequisites of a module");
        System.out.printf("| %-30s | %-36s |\n", "/spec", "View specialisations");
        System.out.printf("| %-30s | %-36s |\n", "/workload", "Display workload");
        System.out.printf("| %-30s | %-36s |\n", "/help", "Show this help message");
        System.out.printf("| %-30s | %-36s |\n", "/exit", "Exit the program");
        System.out.println("+--------------------------------+--------------------------------------+");
        System.out.println("Type /help <command> for more information on a specific command.");
        System.out.println("For further assistance, refer to the user guide at our GitHub repository.");
    }

    private void printSpecific(String command) {

        switch (command) {
        case "view":
            System.out.println("Usage: /view");
            System.out.println("Description: View all modules.");
            System.out.println("Usage: /view <semester>");
            System.out.println("Description: View all modules for <semester>.");
            break;
        case "add":
            System.out.println("Usage: /add <module code>");
            System.out.println("Description: Add a module to the list.");
            break;
        case "addCustom":
            System.out.println("Usage: /addCustom <module code> <semester> <# of MCs> <name>");
            System.out.println("Description: Add a custom module to the list.");
            break;
        case "su":
            System.out.println("Usage: /su <module code>");
            System.out.println("Description: S/U a module.");
            break;
        case "clear":
            System.out.println("Usage: /clear");
            System.out.println("Description: Clears all modules from schedule.");
            break;
        case "gpa":
            System.out.println("Usage: /gpa");
            System.out.println("Description: Retrieve your GPA.");
            break;
        case "grade":
            System.out.println("Usage: /grade <module code> <grade>");
            System.out.println("Description: Set a module's grade.");
            break;
        case "delete":
            System.out.println("Usage: /delete <module code>");
            System.out.println("Description: Delete a module from the list.");
            break;
        case "detail":
            System.out.println("Usage: /detail <module code>");
            System.out.println("Description: View details of a module.");
            break;
        case "grad":
            System.out.println("Usage: /grad");
            System.out.println("Description: Check if you can graduate.");
            break;
        case "schedule":
            System.out.println("Usage: /schedule <jc> or <poly>");
            System.out.println("Description: Retrieve the recommended schedule.");
            break;
        case "spec":
            System.out.println("Usage: /spec");
            System.out.println("Description: View specialisations.");
            break;
        case "workload":
            System.out.println("Usage: /workload");
            System.out.println("Description: Display workload.");
            System.out.println("Usage: /workload <semester>");
            System.out.println("Description: Display workload for <semester>.");
            break;
        case "help":
            System.out.println("Usage: /help");
            System.out.println("Description: Show this help message.");
            break;
        case "exit":
            System.out.println("Usage: /exit");
            System.out.println("Description: Exit the program.");
            break;
        case "waive":
            System.out.println("Usage: /waive <module code>");
            System.out.println("Description: Waive the prerequisites of a module.");
            break;
        default:
            System.out.println("Unknown command. Type '/help' for a list of commands.");
        }

    }
}
