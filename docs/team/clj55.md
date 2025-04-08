# Clarie's Project Portfolio Page

---
<h2>
<span style="color:orange;">Project: Grand Rhombus</span>
</h2>
Grand Rhombus aims to provide <span style="color:blue;">CEG Students</span> with an 
<span style="color:green;">Academic Life Planner</span> which is <span style="color:red;"> in-depth 
</span> and <span style="color:red;"> clear </span> to plan their future.

This planner <span style="color:red;">reduces confusion</span> from having to cross-reference multiple sources 
so that students <span style="color:red;">do not miss academic opportunities</span>.

---

<h2>
<span style="color:orange;">Summary of Contributions</span>
</h2>

Here are my contributions to the project

<h3>Code Contributions</h3>

- **Command Interface**
  - Created command interface for consistency between commands and easy implementation in CommandParser 
  - Refactored commands to use Command Interface

- **Add Module Command `/add`**
    - Implemented function add a module to a specific semester in their academic plan
    - Added description of prerequisites if user did not fulfill prerequisites for the added module

- **Delete Module Command `/delete`** 
    - Allow user to delete a module from their plan

- **Prerequisites**
  - Created a Function that checks whether user has fulfilled prerequisites of a modules whenever a module is added or the user 
  views their list of modules (/add and /view)
  - Designed the Prereq data type for prerequisites that extends into AND, OR and MOD prereq and form a prerequisite tree 
  when nested in each other. When a prerequisite check is done, it recursively goes through the prerequisite tree to 
  check whether all prerequisites have been fulfilled. 

- **Waive Module Prerequisite Command `/waive`**
  - Implemented this function to toggle on and off prerequisite checks of a specific module
  - Added description of waived modules when `/view` is invoked

- **Contributions to team-based tasks**
    - Moved execution of commands to individual commands instead of being called in user
    - Refactored code in CommandParser to create new command after each option and only execute at the end
    - Broke down project into well-defined components with the team for a clearer project architecture

<h3>Developer Guide Contributions</h3>

- **Project Design**
  - Created Architecture Diagram and wrote explanation
  - Created Overall Sequence Diagram and wrote explanation
  - 



---

<h2>
<span style="color:orange;">Link to dashboard</span>
</h2>

My contributions can be found 
[here](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/?search=clj55&breakdown=true)

---