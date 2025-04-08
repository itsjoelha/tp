# Jonathan's Project Portfolio Page

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

Here are my contributions to the project

#### 1. **Schedule**
##### Contributions:
- **Implemented** functionality to generate a recommended schedule for users based on their academic background (e.g., junior college or polytechnic).
- Integrated **semester-based module filtering**, ensuring that schedules are tailored to the user’s current academic progression.


##### Key Features:
- `/schedule <jc> or <poly>` — Generates a tailored academic schedule based on user input.

---

#### 2. **GPA**
##### Contributions:
- **Designed and implemented** a feature to retrieve and display the user's current GPA based on their completed modules.
- Enabled **automatic GPA calculation** as modules are added and graded.

##### Key Features:
- `/gpa` — Retrieves the user's current GPA and prints it on the console.

---

#### 3. **Grade**
##### Contributions:
- **Developed a command** to allow users to input grades for individual modules, ensuring that GPA and academic progress could be updated accordingly.
- Implemented **validation logic** to check for valid grades and handle erroneous inputs.

##### Key Features:
- `/grade <moduleCode> <grade>` — Allows users to set or update a module's grade.

---

#### 4. **S/U (Satisfactory/Unsatisfactory)**
##### Contributions:
- **Created logic** for the S/U feature, allowing users to toggle S/U status for individual modules.
- Handled cases where the module **may not have an S/U option**, or where the grade hasn't been set yet.
- Added feedback and validation, ensuring the user receives appropriate messages when trying to S/U a module.

##### Key Features:
- `/su <moduleCode>` — Toggles the S/U status of the specified module.

---

#### 5. **Command Parser**
##### Contributions:
- **Developed the core parsing logic** to interpret user inputs and map them to the corresponding commands.
- **Enhanced error handling** within the parser to manage invalid inputs and guide the user to proper usage.
- Integrated the parser seamlessly with the different commands (schedule, GPA, grade, etc.), enabling efficient processing of user commands.

##### Key Features:
- Ensures all commands like `/add`, `/delete`, `/view`, and others are properly parsed and executed.

---

#### 6. **View**
##### Contributions:
- **Created the `view` command** to allow users to view all the modules they are enrolled in, with the ability to specify a particular semester.
- **Formatted output** for readability, ensuring users can easily check their module list and progress for each semester.
- Integrated logic to handle **empty semesters** and display appropriate messages (e.g., "No modules for this semester").

##### Key Features:
- `/view` — Displays all modules.
- `/view <semester>` — Displays modules for a specific semester.


</br>

---

- **User Guide**
    - Authored comprehensive documentation for **data persistence features**, including how the application handles **saving and loading user data**.

    - Enhanced readability and user engagement by **reformatting the guide with HTML styling**, making effective use of `<note>`, `<caution>` sections, and other semantic tags to highlight important tips and warnings.
</br>

- **Developer Guide**
    - Contributed significantly to the **Implementation** section, offering in-depth explanations of feature logic and integration.

    - Added and refined content in the **Acknowledgements** and **Design** sections, helping to present the development process in a structured and insightful manner.

    - Improved overall visual clarity by **reformatting the guide using HTML**, making the technical content more accessible and easier to navigate.

    - **Created and embedded detailed PlantUML Sequence Diagrams** to illustrate system workflows and interactions, supporting better developer understanding and future maintenance.
    

---

<h2>
<span style="color:orange;">Link to dashboard</span>
</h2>

My contributions can be found [here](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/?search=jonathan2745&breakdown=true)

--- 
