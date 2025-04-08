# User Guide

## Introduction

GrandRhombus is an Academic Life Planner which is in-depth and clear to plan their future. This planner reduces confusion from having to cross-reference multiple sources so that students do not miss academic opportunities.

## Quick Start

1. Ensure that you have Java 17 or above installed.
2. Download the latest version of `GrandRhombus` from our [GitHub](https://github.com/AY2425S2-CS2113-T11b-2/tp).
3. Tip: Use full screen!

## Features 


---

## Commands

<div style="border: 1px solid #2196F3; background-color: #BBDEFB; padding: 10px; border-radius: 5px;">

<strong> Notes about the Command Format </strong>
  <br>

- Words in UPPER_CASE are the parameters to be supplied by the user.
  e.g. in MODULE_CODE is a parameter which can be replaced with the code of the module to be added
  <br>

- Parameters <strong> must </strong> be in the specified order.
  e.g. if the command specifies MODULE_CODE followed by SEMESTER,
  SEMESTER followed by MODULE_CODE is <strong> NOT </strong> acceptable and will cause issues.
  <br>

- Extraneous parameters for commands that do not take in parameters (such as list and   bye) may cause errors.
  e.g. if the command specifies bye 123, it may create an error.
  <br>

- If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
  <br>


</div>


---

# Command Reference

## View  
**`/view`**  

Lists out all selected modules. Runs prerequisite check on all selected modules.

Note: Prerequisite check will not check the module's grade.

<div style="border: 1px solid #2196F3; background-color: #BBDEFB; padding: 10px; border-radius: 5px;">
  <strong> Note about View Format:   </strong> <br/>

- Modules marked with `[O]` have their module pre-requisites fulfilled <br/> 

- Modules marked with `[X]` do not have their module pre-requisites fulfilled <br/>
    
</div>

## Add Module  
**`/add MODULE_CODE SEMESTER`**

Adds a module to the list of modules the user has.  
- Only adds if the module is in the database.
- Runs a prerequisite check on added module 

Note: Prerequisite check will not check the module's grade.

Example:  `/add CS2113 2`

```
Module CS2113 successfully added to Semester 2.
```

## Add Custom Module  
**`/addCustom MODULE_CODE SEMESTER NUMBER_OF_CREDITS NAME`**

Adds a module that is not in the existing database to the list of modules the user has.

Example:  `/addCustom PL1101E 2 4 Intro to Psychology`

```
Module PL1101E successfully added to Semester 2 as a Custom Module.
```
<div style="border: 1px solid #2196F3; background-color: #BBDEFB; padding: 10px; border-radius: 5px;">
  <strong> Note about Custom Module Format:   </strong> <br/>

  - Custom Modules are intended to be used when Add Module is unable to find the module within the pre-existing database
of core CEG Modules. <br/>

  - Custom Modules added <strong>cannot </strong> have their details changed <br/>

  - To change the details of a custom module, you can delete the custom module form the list and add a new custom module
  with the adjusted details. <br/>

  - Custom Modules are outside the core CEG modules and thus have tutorial, lab, project, prep and lecture hours
  intialised to  <strong> zero (0)</strong>. This <strong> cannot </strong> be changed. <br/>
</div>

## Delete  
**`/delete MODULE_CODE`**  

- Deletes a module from the list of modules the user has.
- Runs a prerequisite check on all modules in academic schedule 

Note: Prerequisite check will not check the module's grade.

Example: `/delete CS2113`
```
Module CS2113 successfully removed.
```

## Details
**`/detail MODULE_CODE`**

Returns the details of the module. 
Details include: Module name, Number of MCs, Preclusions and Prerequisites

Example: `/detail MA1511`
```
+--------------------------------------------------------------------------------+
| MA1511    | Engineering Calculus                                       | 2 MCs |
+--------------------------------------------------------------------------------+
| This is a seven-week course specially designed for students majoring in        |
| Engineering. It introduces the basic concepts in one variable and several      |
| variable calculus with applications in engineering. Main topics: One           |
| variable calculus. Power series. Partial differentiation. Multiple             |
| integrals. Vector Calculus.                                                    |
+--------------------------------------------------------------------------------+
| Preclusions:                                                                   |
| If undertaking an Undergraduate Degree THEN ( must not have completed 1 of     |
| MA1312/MA1505/MA1521/MA2002/MA2311/PC2134/PC2174/PC2174A/YSC1216 at a grade    |
| of at least D)                                                                 |
+--------------------------------------------------------------------------------+
| Prerequisites:                                                                 |
| If undertaking an Undergraduate Degree THEN (( must have completed 1 of 06     |
| MATHEMATICS/07 FURTHER MATHEMATICS at a grade of at least E) OR ( must have    |
| completed 1 of MA1301/MA1301X at a grade of at least D))                       |
+--------------------------------------------------------------------------------+

```
## Waive Pre-Requisites
**`/waive MODULE_CODE`**

Toggles whether or not the pre-requisites of a module are waived.
Note: Does not check whether the pre-requisites has any modules or not.

Example: `/waive CS2040C`
```
Unwaived Prerequisite Check for CS2040C
```
```
Waived Prerequisite Check for CS2040C
```

## Grade
**`/grade MODULE_CODE GRADE`**

Set the grade of a module.

Example: `/grade CS2113 A`
```
Module CS2113 successfully graded as A
```

## SU
**`/su MODULE_CODE`**

Toggles the "S/U" status of a module. Module will be excluded/invlcuded from GPA calculation based off S/U status.
Modules without their grade initialised also cannot be SU'ed
SU: true -  excluded from GPA calculation
SU: false - included in GPA calculation

Example: `/su CS1010`

```
Module CS1010 S/U status: true
```


<div style="border: 1px solid #2196F3; background-color: #BBDEFB; padding: 10px; border-radius: 5px;">
  <strong> Note about SU Format:   </strong> <br/>
  - Some modules cannot be SU'ed
</div>

Example: `/su CS2113`

```
Failed to SU CS2113. Module has no S/U option
```

## GPA
**`/gpa`**

Calculates the GPA of the modules the user has taken.

Example: `/gpa`
```
Your Current GPA: 4.0
```

## Workload
**`/workload`**
**`/workload SEMESTER`**

Calculates the workload of the modules the user has taken.

Example: `/workload 4`
```
+-----------+-----+-----+-------------+---------+---------+----------+----------+
| Code      | Sem | MCs | Lecture Hrs | Tut Hrs | Lab Hrs | Proj Hrs | Prep Hrs |
+-----------+-----+-----+-------------+---------+---------+----------+----------+
| CS2113    | 4   | 4   | 2.0         | 1.0     | 0.0     | 3.0      | 4.0      |
+-----------+-----+-----+-------------+---------+---------+----------+----------+
```

## Help  
**`/help`**

Shows a message explaining how to access the help page.  
Displays a list of commands with a brief explanation of each. 

```
+--------------------------------+--------------------------------------+
| Command                        | Description                          |
+--------------------------------+--------------------------------------+
| /view                          | View all modules                     |
| /add <module code>             | Add a module to the list             |
| /addCustom <module code> ...   | Add a custom module to the list      |
| /su <module code>              | S/U a module                         |
| /gpa                           | Retrieve your GPA                    |
| /grade <module code> <grade>   | Set a module's grade                 |
| /delete <module code>          | Delete a module from the list        |
| /detail <module code>          | View details of a module             |
| /clear                         | Clear all modules from schedule      |
| /grad                          | Check if you can graduate            |
| /schedule <jc> or <poly>       | Generate a schedule for students     |
| /waive <module code>           | Waive the prerequisites of a module  |
| /spec                          | View specialisations                 |
| /workload                      | Display workload                     |
| /help                          | Show this help message               |
| /exit                          | Exit the program                     |
+--------------------------------+--------------------------------------+
Type /help <command> for more information on a specific command.
For further assistance, refer to the user guide at our GitHub repository.
```

## View Graduation Requirements  
**`/grad`**  

Shows a list of the modules the user is missing from meeting graduation requirements.

## Recommended Schedule for CEG Students AY23/24  
- **`/schedule jc`** → Shows the recommended schedule for CEG JC students.  
- **`/schedule poly`** → Shows the recommended schedule for CEG Poly students.  

Example: `/schedule jc`
```
+---------------------------------------------------------------+
| JC Schedule                                                   |
+------+-----+------------------+------+-----+------------------+
| Year | Sem | Module Code      | Year | Sem | Module Code      |
+------+-----+------------------+------+-----+------------------+
| 1    | 1   | CG1111A          | 1    | 2   | CG2111A          |
|      |     | CS1010           |      |     | DTK1234          |
|      |     | EG1311           |      |     | MA1508E          |
|      |     | MA1511           |      |     | PF1101           |
|      |     | MA1512           |      |     | GEA1000          |
|      |     | ES1103           |      |     |                  |
+------+-----+------------------+------+-----+------------------+
| 2    | 1   | CS1231           | 2    | 2   | CG2023           |
|      |     | CS2040C          |      |     | CS2113           |
|      |     | IE2141           |      |     | EE2211           |
|      |     | ES2631           |      |     | EE2026           |
|      |     | GEC1XXX          |      |     | CDE2501          |
+------+-----+------------------+------+-----+------------------+
| 3    | 1   | EG2401A          | 3    | 2   | CG2027           |
|      |     | EG3611A          |      |     | CG2028           |
|      |     | CP3880           |      |     | CG2271           |
|      |     | UE               |      |     | CDE2000          |
|      |     |                  |      |     | ST2334           |
+------+-----+------------------+------+-----+------------------+
| 4    | 1   | CG4002           | 4    | 2   | UE               |
|      |     | EE4204           |      |     | UE               |
|      |     | GEN1XXX          |      |     | UE               |
|      |     | UE               |      |     | UE               |
|      |     |                  |      |     | UE               |
+------+-----+------------------+------+-----+------------------+
```

## View Available Specialisations  
**`/spec`**  

Lists all specialisations available to CEG students.  
Includes required modules for each specialisation.  

## Clear
**`/clear`**

Clears all modules from the user's schedule.

## Exit  
**`/exit`**  

Exits the program.  

---


### **Editing Saved data**

GrandRhombus' data is automatically saved as a `.txt` file at `[JAR file location]/data/mod_data.txt` & `[JAR file location]/data/user.txt`. Advanced users are welcome to update data directly by editing that data file.

<div style="border: 1px solid #FF9800; background-color: #FFEB3B; padding: 10px; border-radius: 5px;">
  <strong>Caution:</strong> If your changes to the data file makes its format invalid, GrandRhombus will not work as intended and may return error codes/ not run. 

  Furthermore, certain edits can cause GrandRhombus to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
  Therefore, we cannot guarantee the proper functioning of the GrandRhombus Program if the data file has been tampered with.
</div>

## Command Summary


| Command       | Description                          | Arguments                                              | Format                           |
|---------------|--------------------------------------|--------------------------------------------------------|----------------------------------|
| `/view`       | View all modules                     | `<semester>` (optional)                                | `/view` or `/view 1`             |
| `/add`        | Add a module to the list             | `<module_code>`, `<semester>`                          | `/add CG1111A 1`                 |
| `/addCustom`  | Add a custom module to the list      | `<module_code>`, `<semester>`, `<# of MCs>`, `<name>`  | `/addCustom CDE3302 3 4 ModName` |
| `/su`         | S/U a module                         | `<module_code>`                                        | `/su CS1010`                     |
| `/delete`     | Delete a module from the list        | `<module_code>`                                        | `/delete CDE3301`                |
| `/detail`     | View details of a module             | `<module_code>`                                        | `/detail CDE3301`                |
| `/grade`      | Set a module's grade                 | `<module_code>`, `<grade>`                             | `/grade CDE3301 A`               |
| `/waive`      | Waives the pre-requisites of a module| `<module_code>`                                        | `/waive CS2040C`                 |
| `/gpa`        | Retrieve your GPA                    | None                                                   | `/gpa`                           |
| `/grad`       | Check if you can graduate            | None                                                   | `/grad`                          |
| `/schedule`   | Generate a schedule                  | `<jc>` or `<poly>`                                     | `/schedule jc`                   |
| `/spec`       | View specialisations                 | None                                                   | `/spec`                          |
| `/workload`   | Display workload                     | `<semester>` (optional)                                | `/workload` or `/workload 1`     |
| `/help`       | Show a help message                  | `<command>` (optional)                                 | `/help` or `/help add`           |
| `/clear`      | Clear all modules from the list      | None                                                   | `/clear`                         |
| `/exit`       | Exit the program                     | None                                                   | `/exit`                          |
