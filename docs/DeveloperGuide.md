# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to 
the original source as well}

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

### CommandParser

#### Design
The `CommandParser` is responsible for interpreting user commands and executing the corresponding actions. It acts 
as an interface between user input and the system's internal logic.

#### Implementation
- **Parsing User Input**: The `CommandParser` takes raw user input, processes it, and determines the 
appropriate command.
- **Error Handling** : If an invalid command is encountered, appropriate error messages are generated to
assist the user.
- **Execution Flow**:
  1. Read the user input as a string.
  2. Tokenize the input to extract the command and arguments.
  3. Identify the corresponding command handler.
  4. Execute the command with the given arguments.

### Workload

#### Design
The `Workload` command is responsible for displaying the user's workload for the semester, including the number 
of modular credits and breakdown of hours spent on lectures, tutorials, labs, projects, and preparation, per week.

#### Implementation
- **Displaying Workload**: The `Workload` command retrieves data from `moduleList`, which contains all the modules 
the user is taking.
- **Execution Flow**:
  - Check if `moduleList` is empty. If empty, print a message indicating no modules are present.
  - Print a formatted table displaying each module's details, including:
    - Module Code 
    - Modular Credits (MCs)
    - Lecture Hours 
    - Tutorial Hours 
    - Lab Hours 
    - Project Hours 
    - Preparation Hours

## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Appendix: Instructions for Manual Testing

Given below are instructions to test the app manually.

### Launch and Shutdown

#### Initial Launch
1. Download the JAR file and copy it into an empty folder.
2. Open a terminal or command prompt, navigate to the folder, and run:
   ```sh
   java -jar GrandRhombus.jar
   ```
   The GUI launches successfully with an initial state.

#### Saving Window Preferences
1. Resize the window to an optimum size. 
2. Move the window to a different location. 
3. Close the window. 
4. Re-launch the app by double-clicking the JAR file.
- Expected: The most recent window size and location is retained.

### Command Testing

#### Exiting the Application
- Type `/exit` in the command line and press Enter.
   - The application shuts down successfully.

#### Viewing Modules
- Test case: `/view`
  - Displays the list of modules.

#### Viewing Module Details
- Test case: `/detail CS2113`
  - Displays details of the module CS2113.

#### Adding a Module
- Test case: `/add CS2113 4`
  - Adds module CS2113 successfully to semester 4.
- Test case: `/add`
  - "Error: Please specify a module code to add. Usage: /add MODULE_CODE SEMESTER"

#### Deleting a Module
- Test case: `/delete CS2113`
  - Deletes module CS2113 successfully.
- Test case: `/delete`
  - "Error: Please specify a module code to delete."

#### Invalid Commands
- Test case: `/randomcommand`
  - "Unknown command. Type '/help' for a list of commands."

#### Checking Workload
- Test case: `/workload`
  - Displays the workload if modules are present.
  - Edge Case: If no modules are present, displays "No modules in List".

#### Checking Graduation Status
- Test case: `/grad`
  - Displays graduation progress.

### Data Persistence Testing

#### Handling Empty Module List
- Test case: Ensure no modules are added, then execute `/view`.
  - Displays empty semester lists.

These tests help verify the core functionality of the command parser and the application's robustness 
against invalid inputs.

