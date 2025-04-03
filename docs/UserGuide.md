# User Guide

## Introduction

GrandRhombus is an Academic Life Planner which is in-depth and clear to plan their future. This planner reduces confusion from having to cross-reference multiple sources so that students do not miss academic opportunities.

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 17 or above installed.
2. Down the latest version of `GrandRhombus` from our [GitHub](https://github.com/AY2425S2-CS2113-T11b-2/tp).

## Features 


---

## Commands



<div style="border: 1px solid #2196F3; background-color: #BBDEFB; padding: 10px; border-radius: 5px;">

<strong> Notes about the Command Format </strong>
  <br>
  <br>

- Words in UPPER_CASE are the parameters to be supplied by the user.
  e.g. in TASK_DESCRIPTION is a parameter which can be replaced with the description of the task to be added
  <br>
  <br>

- Parameters <strong> must </strong> be in the specified order.
  e.g. if the command specifies TASK_DESCRIPTION followed by TASK_DATE,
  TASK_DATE followed by TASK_DESCRIPTION is <strong> NOT </strong> acceptable and will cause issues.
  <br>
  <br>

- Extraneous parameters for commands that do not take in parameters (such as list and bye) will cause errors.
  e.g. if the command specifies bye 123, it will create an error.
  <br>
  <br>

- If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
  <br>


</div>


---

# Command Reference

## View  
**`/view`**  
Lists out all selected modules.

## Add Module  
**`/add MODULE_CODE`**  
Adds a module to the list of modules the user has.  
- Only adds if the module is in the database.  
- Example:  


## Add Custom Module  
**`/addCustom MODULE_CODE`**  
Prompts for MCs, workload (lectures, projects, assignments).  
Adds a custom module.  
- Example:  

## Delete  
**`/delete MODULE_CODE`**  
Deletes a module from the list of modules the user has.  
- Example:  


## Help  
**`/help`**  
Shows a message explaining how to access the help page.  
Displays a list of commands with a brief explanation of each.  

## View Graduation Requirements  
**`/grad`**  
Shows a list of modules students are required to take to graduate.  

## Recommended Schedule for CEG Students AY23/24  
- **`/schedule -jc`** → Shows the recommended schedule for CEG JC students.  
- **`/schedule -poly`** → Shows the recommended schedule for CEG Poly students.  

## View Available Specialisations  
**`/specialisation`**  
Lists all specialisations available to CEG students.  
Includes required modules for each specialisation.  

## Exit  
**`/exit`**  
Exits the program.  

---


### **Editing Saved data**

GrandRhombus' data is automatically saved as a `.txt` file at `[JAR file location]/data/mod_data.txt` & `[JAR file location]/data/user.txt`. Advanced users are welcome to update data directly by editing that data file.

<div style="border: 1px solid #FF9800; background-color: #FFEB3B; padding: 10px; border-radius: 5px;">
  <strong>Caution:</strong>  If your changes to the data file makes its format invalid, GrandRhombus will not work as intended and return error codes/ not run.

Furthermore, certain edits can cause GrandRhombus to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.

</div>

## Command Summary

| Command           | Description                      | Arguments               | Format                       |
|-------------------|----------------------------------|-------------------------|------------------------------|
| `/view`           | View all modules                 | `<semester>`            | `/view` or `/view 1`         |
| `/add`            | Add a module to the list         | `<module_code>`         | `/add CDE3301`               |
| `/addCustom`      | Add a custom module to the list  | `<module_code>`         | `/addCustom CDE3302`         |
| `/su`             | S/U a module                     | `<module_code>`         | `/su CS1010`                 |
| `/delete`         | Delete a module from the list    | `<module_code>`         | `/delete CDE3301`            |
| `/detail`         | View details of a module         | `<module_code>`         | `/detail CDE3301`            |
| `/grade`          | Set a module's grade             | `<module_code> <grade>` | `/grade CDE3301 A`           |
| `/gpa`            | Retrieve your GPA                | None                    | `/gpa`                       |
| `/grad`           | Check if you can graduate        | None                    | `/grad`                      |
| `/schedule`       | Generate a schedule for students | None                    | `/schedule`                  |
| `/specialisation` | View specialisations             | None                    | `/specialisation`            |
| `/workload`       | Display workload                 | `<semester>`            | `/workload` or `/workload 1` |
| `/help`           | Show this help message           | `<command>`             | `/help` or `/help help`      |
| `/exit`           | Exit the program                 | None                    | `/exit`                      |
