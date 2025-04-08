# Xinmin's Project Portfolio Page

---
<h2>
<span style="color:orange;">Project: Grand Rhombus</span>
</h2>
Grand Rhombus aims to provide <span style="color:blue;">CEG Students</span> with an 
<span style="color:green;">Academic Life Planner</span> which is <span style="color:red;"> in-depth </span> and 
<span style="color:red;"> clear </span> to plan their future.

This planner <span style="color:red;">reduces confusion</span> from having to cross-reference multiple sources 
so that students <span style="color:red;">do not miss academic opportunities</span>.

---

<h2>
<span style="color:orange;">Summary of Contributions</span>
</h2>

Here are my contributions to the project:

- **New feature** : 
Added the ability to do add custom modules.
  - What it does: Allows the user to add custom modules not within the existing database.
  - Justification: This feature improves the product significantly because a user can add modules that are not within
  the CEG core modules. This allows more flexibility in schedule planning as they can now incorporate modules from
  majors, minors or unrestricted electives not within CEG modules.
  - Highlights: This enhancement required an in-depth analysis in the most optimal inputs for ease of usage by user,
  as well as incorporation into already existing features, such as including the number of MCs. It required a large
  number of checks due to its long list of inputs, to ensure the validity of the module details before including it 
  into the schedule.
- **New feature** : 
added the ability to view the details of the modules in the database.
  - What it does: Allows the user to view the description, name, number of MC, prerequisites and preclusions of the
  module. 
  - Justification: This feature improves the product because a user can glean the prerequisites and preclusions, which 
  allows them to make a better plan to account for such restrictions. It also allows them to estimate the workload of 
  the module, which also allows them to plan a balanced schedule each semester. 
  - Highlights: This enhancement was tedious to implement as it required saving all the descriptions, preclusions and
  prerequisites in the user.txt file for data storage. This enhancement can be easily expanded by other developers in 
  the future should they require by editing the text file.



- **Enhancements to existing features**
  - Added the Ui and Error Handler class 
    - Makes CommandParser easier to read, and shortens the length of the callCommand function
    drastically.
    - Helps to standardise level of abstraction in main Duke class and CommandParser classes. 
  - Abstracted CommandParser Class function callCommand().
    - Shifted out check and parser functions to manage errors all together instead of within each case. 
  - Wrote additional tests for CommandParser
    - cover invalid inputs, excessive inputs and number error inputs. 

- **Documentation**:
  - User Guide:
    - Added documentation for the `add`, `delete`, `addCustom` and `detail` features
    - Did cosmetic edits to existing documentation notes.
  - Developer Guide:
    - Added implementation details of the `addCustom` and `Prereq` classes.
    - Added component details of CommandParser component.

- **Community** :


---

<h2>
<span style="color:orange;">Link to dashboard</span>
</h2>


My contributions can be found [here](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/?search=xmtan1&breakdown=true)
---