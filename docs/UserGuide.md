# User Guide

## Introduction

GrandRhombus is an Academic Life Planner which is in-depth and clear to plan their future. This planner reduces confusion from having to cross-reference multiple sources so that students do not miss academic opportunities.

## Quick Start

1. Ensure that you have Java 17 or above installed.
2. Download the latest version of `GrandRhombus` from our [GitHub](https://github.com/AY2425S2-CS2113-T11b-2/tp).

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
**`/add MODULE_CODE SEMESTER`**

Adds a module to the list of modules the user has.  
- Only adds if the module is in the database.

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

## Delete  
**`/delete MODULE_CODE`**  
Deletes a module from the list of modules the user has.

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

## Grade
**`/grade MODULE_CODE GRADE`**

Set the grade of a module.

Example: `/grade CS2113 A`
```
Module CS2113 successfully graded as A
```

## SU
**`/su MODULE_CODE`**

S/U a module. Module will be excluded from GPA calculation. 

Example: `/su CS2113`
```
Module CS2113 successfully SU-ed.
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

## View Graduation Requirements  
**`/grad`**  
Shows a list of the modules the user is missing from meeting graduation requirements.

## Recommended Schedule for CEG Students AY23/24  
- **`/schedule -jc`** → Shows the recommended schedule for CEG JC students.  
- **`/schedule -poly`** → Shows the recommended schedule for CEG Poly students.  

## View Available Specialisations  
**`/spec`**  
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

| Command      | Description                      | Arguments                                             | Format                           |
|--------------|----------------------------------|-------------------------------------------------------|----------------------------------|
| `/view`      | View all modules                 | `<semester>`                                          | `/view` or `/view 1`             |
| `/add`       | Add a module to the list         | `<module_code>`, `<semester>`                         | `/add CG1111A 1`                 |
| `/addCustom` | Add a custom module to the list  | `<module_code>`, `<semester>`, `<# of MCs>`, `<name>` | `/addCustom CDE3302 3 4 ModName` |
| `/su`        | S/U a module                     | `<module_code>`                                       | `/su CS1010`                     |
| `/delete`    | Delete a module from the list    | `<module_code>`                                       | `/delete CDE3301`                |
| `/detail`    | View details of a module         | `<module_code>`                                       | `/detail CDE3301`                |
| `/grade`     | Set a module's grade             | `<module_code>`, `<grade>`                            | `/grade CDE3301 A`               |
| `/gpa`       | Retrieve your GPA                | None                                                  | `/gpa`                           |
| `/grad`      | Check if you can graduate        | None                                                  | `/grad`                          |
| `/schedule`  | Generate a schedule for students | None                                                  | `/schedule`                      |
| `/spec `     | View specialisations             | None                                                  | `/spec`                          |
| `/workload`  | Display workload                 | `<semester>`                                          | `/workload` or `/workload 1`     |
| `/help`      | Show this help message           | `<command>`                                           | `/help` or `/help help`          |
| `/exit`      | Exit the program                 | None                                                  | `/exit`                          |
