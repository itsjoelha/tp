package seedu.duke.command;

public class Specialisation implements Command {

    public void execute() {

        System.out.println("========== SPECIALISATIONS ==========\n" +
                "Each specialisation offers a focused curriculum designed to equip students with\n" +
                "in-depth knowledge and skills in their chosen field. Students must complete the\n" +
                "required core and elective courses to fulfil the specialisation requirements.\n" +
                "\n" +
                "========== ADVANCED ELECTRONICS ==========\n" +
                "Students in the AE Specialisation are required to complete a minimum of 20\n" +
                "Units consisting of AE core (2 mandatory courses) and AE electives.\n" +
                "\n" +
                "* AE Core Courses *\n" +
                "EE3408C Integrated Analog Design (4 Units)\n" +
                "EE3431C Microelectronic Materials and Devices (4 Units)\n" +
                "\n" +
                "* AE Elective Courses *\n" +
                "EE4218 Embedded Hardware System Design (4 Units)\n" +
                "EE4407 Analog Electronics (4 Units)\n" +
                "EE4415 Integrated Digital Design (4 Units)\n" +
                "EE5507 Analog IC Design (4 Units)\n" +
                "CG3207 Computer Architecture (4 Units)\n" +
                "EE4409 Modern Microelectronic Devices & Sensors (4 Units)\n" +
                "EE4435 Modern Transistors and Memory Devices (4 Units)\n" +
                "EE4436 Fabrication Process Technology (4 Units)\n" +
                "EE4437 Photonics – Principles and Applications (4 Units)\n" +
                "EE4438 Solar Cells and Modules (4 Units)\n" +
                "\n" +
                "========== INDUSTRY 4.0 ==========\n" +
                "Students will need to complete 20 Units according to the following requirements:\n" +
                "1. Complete two compulsory courses (a) EE3331C or ME2142 (4 Units) AND (b)\n" +
                "EE3306/ME3163 (4 Units).\n" +
                "2. Complete three electives.\n" +
                "\n" +
                "* Industry 4.0 Electives *\n" +
                "EE4211 Data Science for IoT (4 Units)\n" +
                "EE4212 Computer Vision (4 Units)\n" +
                "EE4302 Advanced Control System (4 Units)\n" +
                "EE4311 Fuzzy Logic and Neuro Fuzzy Systems (4 Units)\n" +
                "EE4312 Artificial Neural Networks (4 Units)\n" +
                "EE4314 Eyes from above: Guidance, Navigation and Control\n" +
                "EE4315 Intelligent Industrial Control Systems\n" +
                "ME3242 Automation (4 Units)\n" +
                "ME4262 Automation in Manufacturing (4 Units)\n" +
                "ME4248 Manufacturing Simulation and Data Communication (4 Units)\n" +
                "ME4246 Modern Control System\n" +
                "ME5405 Machine Vision (4 Units)\n" +
                "CN4227R Advanced Process Control\n" +
                "CN4221R Control of Industrial Processes (4 Units)\n" +
                "RB4301 Robot Learning\n" +
                "\n" +
                "========== INTERNET OF THINGS (IoT) ==========\n" +
                "Students in the IoT Specialisation are required to complete a minimum of 20\n" +
                "Units consisting of IoT core (3 mandatory courses) and IoT electives.\n" +
                "\n" +
                "* IoT Core Courses *\n" +
                "CS3237 Introduction to Internet of Things (4 Units)\n" +
                "EE4211 Data Science for IoT (4 Units)\n" +
                "EE4409 Modern Microelectronic Devices & Sensors (4 Units)\n" +
                "\n" +
                "* IoT Elective Courses *\n" +
                "CG4002 Computer Engineering Capstone Project (8 Units)\n" +
                "CS4222 Wireless Networking (4 Units)\n" +
                "EE4204 Computer Networks (4 Units, For EE students only)\n" +
                "EE4216 Hardware for Internet of Things (4 Units)\n" +
                "EE4218 Embedded Hardware System Design (4 Units)\n" +
                "CS3244 Machine Learning (4 Units)\n" +
                "EE4002D/EE4002R Design Capstone/Research Capstone (8 Units)\n" +
                "or CP4106 Computing Project – linked to IoT (8 Units)\n" +
                "\n" +
                "========== ROBOTICS ==========\n" +
                "Students taking the Robotics specialisation must complete 20 Units, comprising\n" +
                "the following: 12 Units from basket of Robotics electives AND complete a final-year\n" +
                "Capstone project (8 Units) in the area of Robotics, OR 20 Units from basket of\n" +
                "Robotics electives.\n" +
                "\n" +
                "* Robotics Electives *\n" +
                "BN4203 Robotics in Rehabilitation (4 Units)\n" +
                "BN4601 Intelligent Medical Robotics\n" +
                "EE3305/ME3243 Robotic System Design (4 Units)\n" +
                "EE4305 Fuzzy/Neural Systems for intelligent robotics\n" +
                "EE4308 Autonomous Robot Systems (4 Units)\n" +
                "EE4309 Robot Perception (4 Units)\n" +
                "EE4705 Human-Robot Interaction (4 Units)\n" +
                "EE4311 Fuzzy Logic and Neuro Fuzzy Systems (4 Units)\n" +
                "EE4312 Artificial Neural Networks (4 Units)\n" +
                "EE4314 Eyes from above: Guidance, Navigation and Control\n" +
                "ME4242 Soft Robotics (4 Units)\n" +
                "ME4245 Robot Mechanics and Control (4 Units)\n" +
                "ME5406 Deep Learning for Robotics (4 Units)\n" +
                "MLE4228 Materials for Robotic Sensing and Actuation (4 Units)\n" +
                "RB4301 Robot Learning\n" +
                "\n" +
                "========== SPACE TECHNOLOGY ==========\n" +
                "Students are required to complete a minimum of 20 Units, including two core\n" +
                "courses and two elective courses.\n" +
                "\n" +
                "* ST Core Courses *\n" +
                "EE3105 Beyond Sky – New Space Technology and Application (4 Units)\n" +
                "EE4002D/EE4002R Capstone on satellite related projects (8 Units)\n" +
                "\n" +
                "* ST Technical Electives *\n" +
                "EE3131C Communication Systems (4 Units)\n" +
                "EE3104C Introduction to RF and Microwave Systems & Circuits (4 Units)\n" +
                "EE3331C Feedback Control Systems (4 Units)\n" +
                "EE4115 Remote Sensing and Analysis with Deep Learning Technique (4 Units)\n" +
                "EE4218 Embedded Hardware System Design (4 Units)\n" +
                "EE4314 Eyes from above: Guidance, Navigation and Control\n" +
                "EE4503 Power Electronics for Sustainable Energy Technologies (4 Units)\n" +
                "EE4101 RF Communications (4 Units)\n" + "========================================");
    }
}
