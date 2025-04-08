package seedu.duke.command;

/**
 * The Specialisation class implements the Command interface to display information about
 * various specialisations available to students. It presents specialisation requirements,
 * core courses, and elective options in a formatted table layout.
 *
 * This class follows the Command design pattern, allowing it to be executed when a user
 * requests information about specialisations.
 */
public class Specialisation implements Command {

    /**
     * Formats and prints text in a wrapped format to fit within the output window.
     * This method breaks down long text into multiple lines that fit within the specified width,
     * ensuring proper display of content within the table structure.
     *
     * @param description The text content to be wrapped and displayed
     */
    public void textWrapDescription(String description) { // prints description to fit into
        // the output window
        int wrapLength = 77;
        StringBuilder currentLine = new StringBuilder();
        String[] words = description.split(" ");

        for (String word : words) {
            // Handle words longer than wrapLength
            while (word.length() > wrapLength) {
                int breakIndex = word.lastIndexOf("/", wrapLength);
                if (breakIndex == -1) {
                    // No slash found, force split at wrapLength
                    System.out.printf("| %-78s |\n", word.substring(0, wrapLength));
                    word = word.substring(wrapLength);
                } else {
                    // Split at last slash within wrapLength
                    System.out.printf("| %-78s |\n", word.substring(0, breakIndex + 1));
                    word = word.substring(breakIndex + 1);
                }
            }

            // Move to a new line if adding word exceeds wrapLength
            if (currentLine.length() + word.length() + 1 > wrapLength) {
                System.out.printf("| %-78s |\n", currentLine.toString().trim());
                currentLine.setLength(0);
            }

            if (currentLine.isEmpty()) {
                currentLine.append(" ");
            }
            currentLine.append(word);
            currentLine.append(" ");
        }

        // Print remaining line
        System.out.printf("| %-78s |\n", currentLine.toString().trim());
    }

    /**
     * Prints a horizontal line divider to separate sections in the output table.
     * This creates a consistent visual boundary between different parts of the table.
     */
    public void printHeaderDivider() {
        System.out.println("+--------------------------------------------------------------------------------+");
    }

    /**
     * Prints a formatted header for a specialisation section.
     * This method creates a visually distinct section title surrounded by dividers.
     *
     * @param specialisationName The name of the specialisation to be displayed as a header
     */
    public void printSpecialisationHeader(String specialisationName) {
        printHeaderDivider();
        System.out.printf("| %-78s |\n", specialisationName);
        printHeaderDivider();
    }

    /**
     * Prints a section header within a specialisation block.
     * This method formats and displays subsection titles like "Core Courses" or "Elective Courses".
     *
     * @param headerText The text to be displayed as a section header
     */
    public void printSectionHeader(String headerText) {
        System.out.printf("| %-78s |\n", headerText);
    }

    /**
     * Executes the command to display specialisation information.
     * This method implements the execute method from the Command interface and
     * prints detailed information about all available specialisations in a formatted table.
     * Information includes specialisation requirements, core courses, and elective options.
     */
    public void execute() {
        // Introduction
        printHeaderDivider();
        System.out.printf("| %-78s |\n", "SPECIALISATIONS");
        printHeaderDivider();
        textWrapDescription("Each specialisation offers a focused curriculum designed to equip students with " +
                "in-depth knowledge and skills in their chosen field. Students must complete the " +
                "required core and elective courses to fulfil the specialisation requirements.");
        printHeaderDivider();

        // Advanced Electronics
        printSpecialisationHeader("ADVANCED ELECTRONICS");
        textWrapDescription("Students in the AE Specialisation are required to complete a minimum of 20 " +
                "Units consisting of AE core (2 mandatory courses) and AE electives.");
        printHeaderDivider();

        printSectionHeader("AE Core Courses:");
        textWrapDescription("EE3408C Integrated Analog Design (4 Units)");
        textWrapDescription("EE3431C Microelectronic Materials and Devices (4 Units)");
        printHeaderDivider();

        printSectionHeader("AE Elective Courses:");
        textWrapDescription("EE4218 Embedded Hardware System Design (4 Units)");
        textWrapDescription("EE4407 Analog Electronics (4 Units)");
        textWrapDescription("EE4415 Integrated Digital Design (4 Units)");
        textWrapDescription("EE5507 Analog IC Design (4 Units)");
        textWrapDescription("CG3207 Computer Architecture (4 Units)");
        textWrapDescription("EE4409 Modern Microelectronic Devices & Sensors (4 Units)");
        textWrapDescription("EE4435 Modern Transistors and Memory Devices (4 Units)");
        textWrapDescription("EE4436 Fabrication Process Technology (4 Units)");
        textWrapDescription("EE4437 Photonics – Principles and Applications (4 Units)");
        textWrapDescription("EE4438 Solar Cells and Modules (4 Units)");
        printHeaderDivider();

        // Industry 4.0
        printSpecialisationHeader("INDUSTRY 4.0");
        textWrapDescription("Students will need to complete 20 Units according to the following requirements: " +
                "1. Complete two compulsory courses (a) EE3331C or ME2142 (4 Units) AND (b) " +
                "EE3306/ME3163 (4 Units). " +
                "2. Complete three electives.");
        printHeaderDivider();

        printSectionHeader("Industry 4.0 Electives:");
        textWrapDescription("EE4211 Data Science for IoT (4 Units)");
        textWrapDescription("EE4212 Computer Vision (4 Units)");
        textWrapDescription("EE4302 Advanced Control System (4 Units)");
        textWrapDescription("EE4311 Fuzzy Logic and Neuro Fuzzy Systems (4 Units)");
        textWrapDescription("EE4312 Artificial Neural Networks (4 Units)");
        textWrapDescription("EE4314 Eyes from above: Guidance, Navigation and Control");
        textWrapDescription("EE4315 Intelligent Industrial Control Systems");
        textWrapDescription("ME3242 Automation (4 Units)");
        textWrapDescription("ME4262 Automation in Manufacturing (4 Units)");
        textWrapDescription("ME4248 Manufacturing Simulation and Data Communication (4 Units)");
        textWrapDescription("ME4246 Modern Control System");
        textWrapDescription("ME5405 Machine Vision (4 Units)");
        textWrapDescription("CN4227R Advanced Process Control");
        textWrapDescription("CN4221R Control of Industrial Processes (4 Units)");
        textWrapDescription("RB4301 Robot Learning");
        printHeaderDivider();

        // Internet of Things
        printSpecialisationHeader("INTERNET OF THINGS (IoT)");
        textWrapDescription("Students in the IoT Specialisation are required to complete a minimum of 20 " +
                "Units consisting of IoT core (3 mandatory courses) and IoT electives.");
        printHeaderDivider();

        printSectionHeader("IoT Core Courses:");
        textWrapDescription("CS3237 Introduction to Internet of Things (4 Units)");
        textWrapDescription("EE4211 Data Science for IoT (4 Units)");
        textWrapDescription("EE4409 Modern Microelectronic Devices & Sensors (4 Units)");
        printHeaderDivider();

        printSectionHeader("IoT Elective Courses:");
        textWrapDescription("CG4002 Computer Engineering Capstone Project (8 Units)");
        textWrapDescription("CS4222 Wireless Networking (4 Units)");
        textWrapDescription("EE4204 Computer Networks (4 Units, For EE students only)");
        textWrapDescription("EE4216 Hardware for Internet of Things (4 Units)");
        textWrapDescription("EE4218 Embedded Hardware System Design (4 Units)");
        textWrapDescription("CS3244 Machine Learning (4 Units)");
        textWrapDescription("EE4002D/EE4002R Design Capstone/Research Capstone (8 Units)");
        textWrapDescription("or CP4106 Computing Project – linked to IoT (8 Units)");
        printHeaderDivider();

        // Robotics
        printSpecialisationHeader("ROBOTICS");
        textWrapDescription("Students taking the Robotics specialisation must complete 20 Units, comprising " +
                "the following: 12 Units from basket of Robotics electives AND complete a final-year " +
                "Capstone project (8 Units) in the area of Robotics, OR 20 Units from basket of " +
                "Robotics electives.");
        printHeaderDivider();

        printSectionHeader("Robotics Electives:");
        textWrapDescription("BN4203 Robotics in Rehabilitation (4 Units)");
        textWrapDescription("BN4601 Intelligent Medical Robotics");
        textWrapDescription("EE3305/ME3243 Robotic System Design (4 Units)");
        textWrapDescription("EE4305 Fuzzy/Neural Systems for intelligent robotics");
        textWrapDescription("EE4308 Autonomous Robot Systems (4 Units)");
        textWrapDescription("EE4309 Robot Perception (4 Units)");
        textWrapDescription("EE4705 Human-Robot Interaction (4 Units)");
        textWrapDescription("EE4311 Fuzzy Logic and Neuro Fuzzy Systems (4 Units)");
        textWrapDescription("EE4312 Artificial Neural Networks (4 Units)");
        textWrapDescription("EE4314 Eyes from above: Guidance, Navigation and Control");
        textWrapDescription("ME4242 Soft Robotics (4 Units)");
        textWrapDescription("ME4245 Robot Mechanics and Control (4 Units)");
        textWrapDescription("ME5406 Deep Learning for Robotics (4 Units)");
        textWrapDescription("MLE4228 Materials for Robotic Sensing and Actuation (4 Units)");
        textWrapDescription("RB4301 Robot Learning");
        printHeaderDivider();

        // Space Technology
        printSpecialisationHeader("SPACE TECHNOLOGY");
        textWrapDescription("Students are required to complete a minimum of 20 Units, including two core " +
                "courses and two elective courses.");
        printHeaderDivider();

        printSectionHeader("ST Core Courses:");
        textWrapDescription("EE3105 Beyond Sky – New Space Technology and Application (4 Units)");
        textWrapDescription("EE4002D/EE4002R Capstone on satellite related projects (8 Units)");
        printHeaderDivider();

        printSectionHeader("ST Technical Electives:");
        textWrapDescription("EE3131C Communication Systems (4 Units)");
        textWrapDescription("EE3104C Introduction to RF and Microwave Systems & Circuits (4 Units)");
        textWrapDescription("EE3331C Feedback Control Systems (4 Units)");
        textWrapDescription("EE4115 Remote Sensing and Analysis with Deep Learning Technique (4 Units)");
        textWrapDescription("EE4218 Embedded Hardware System Design (4 Units)");
        textWrapDescription("EE4314 Eyes from above: Guidance, Navigation and Control");
        textWrapDescription("EE4503 Power Electronics for Sustainable Energy Technologies (4 Units)");
        textWrapDescription("EE4101 RF Communications (4 Units)");
        printHeaderDivider();

    }
}
