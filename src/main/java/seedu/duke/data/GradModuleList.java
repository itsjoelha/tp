package seedu.duke.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradModuleList {

    public static final List<Mod> YEAR1SEM1MODULES = new ArrayList<>(Arrays.asList(
            new Mod("Engineering Principles and Practice I", "This course is the first" +
                    " of the two Engineering Principles and Practice (EPP) courses taken by computer" +
                    " engineering students, which aim to inculcate in them the computer engineer's way of " +
                    " thinking. They are first taught the fundamental principles of electronic circuits" +
                    " through experiential learning, along which they also build up their hands-on circuit" +
                    " designing, building, and debugging skills. They are then guided to apply these" +
                    " principles and skills to build a sensor-assisted autonomous robotic vehicle as a grand" +
                    " finale challenge. Upon completing the course, they can appreciate the importance of" +
                    " circuits, signals, and sensors in system implementation.",
                    4, "CG1111A", 0, 1, 5, 1.5, 2.5, "No preclusions", "No prerequisites"),

            new Mod("Programming Methodology", "This course introduces the fundamental concepts" +
                    " of problem solving by computing and programming using an imperative programming language." +
                    " It is the first and foremost introductory course to computing. Topics covered include" +
                    " computational thinking and computational problem solving, designing and specifying an" +
                    " algorithm, basic problem formulation and problem solving approaches, program development," +
                    " coding, testing and debugging, fundamental programming constructs (variables, types," +
                    " expressions, assignments, functions, control structures, etc.), fundamental data structures" +
                    " (arrays, strings, composite data types), basic sorting, and recursion.",
                    4, "CS1010", 2, 1, 1, 3, 3, "No preclusions", "No prerequisites"),

            new Mod("Design and Make", "This course covers the fundamentals of engineering design" +
                    " and prototyping. Students will learn design principles and tools through lectures and engage" +
                    " in experiential learning through group design projects. A stage-based design process will be" +
                    " covered. Students will develop skills in Arduino-controlled electronics, CAD modelling, and" +
                    " rapid prototyping to demonstrate their ideas.",
                    4, "EG1311", 1, 0, 3, 0, 3, "No preclusions", "No prerequisites"),

            new Mod("Engineering Calculus", "This is a seven-week course specially designed for" +
                    " students majoring in Engineering. It introduces the basic concepts in one variable and several" +
                    " variable calculus with applications in engineering. Main topics: One variable calculus." +
                    " Power series. Partial differentiation. Multiple integrals. Vector Calculus.", 2,
                    "MA1511", 3, 2, 0, 0, 5, "If undertaking an Undergraduate Degree THEN ( must not have completed 1" +
                    "of MA1312/MA1505/MA1521/MA2002/MA2311/PC2134/PC2174/PC2174A/YSC1216 at a grade of at least D)",
                    "If undertaking an Undergraduate Degree THEN (( must have completed 1 of 06" +
                    "MATHEMATICS/07 FURTHER MATHEMATICS at a grade of at least E) OR ( must have completed 1" +
                    " of MA1301/MA1301X at a grade of at least D))"),

            new Mod("Differential Equations for Engineering", "This is a seven-week course" +
                    " specially designed for students majoring in Engineering. It introduces the basic concepts" +
                    " in the study of differential equations, with an emphasis on applications in engineering" +
                    " and other fields. Major topics include modelling with differential equations, first-order" +
                    " ordinary differential equations, higher-order linear differential equations, the Laplace" +
                    " transform, and partial differential equations.",
                    2, "MA1512", 3, 2, 0, 0, 5, "If undertaking an Undergraduate Degree" +
                    "THEN ( must not have completed PC2134 at a grade of at least D)", "If undertaking" +
                    " an Undergraduate Degree THEN (( must have completed 1 of 06 MATHEMATICS/07" +
                    " FURTHER MATHEMATICS at a grade of at least E) OR ( must have completed 1" +
                    "of MA1301/MA1301X at a grade of at least D))"),

            new Mod("English for Academic Purposes", "ES1103 serves as a bridging course for" +
                    " students who have taken the university’s Qualifying English Test and are deemed to require" +
                    " additional language support for the academic context. It aims to equip students with the" +
                    " knowledge of the academic genre and the ability to apply such knowledge in academic" +
                    " communication. The course adopts a reading-into-writing approach using themed readings" +
                    " as springboard texts for students’ writing and provides opportunities for analysing and" +
                    " internalising ways of organising academic texts. Students will acquire essential academic" +
                    " skills required to cope with the rigour of academic writing at a tertiary level.",
                    4, "ES1103", 0, 4, 0, 3, 3, "If undertaking an Undergraduate Degree THEN (( EP ENGLISH LANGUAGE" +
                    " PROFICIENCY TEST at a grade of at least N) AND must not have completed 1 of AR1000, BE1000," +
                    " EA1101, EG1471, ES1101, ES1102, ES1301, ET1000, ID1000, NK1001)", "If undertaking" +
                    " an Undergraduate Degree THEN ( must have completed EP ENGLISH LANGUAGE PROFICIENCY TEST at a" +
                    " grade of at least Y OR must have completed ES1000 at a grade of at least D)")
    ));

    public static final List<Mod> YEAR1SEM2MODULES = new ArrayList<>(Arrays.asList(
            new Mod("Engineering Principles and Practice II", "This course will be for the students" +
                    " who have completed EPP I and the project scope extends to handle challenges in large-scale" +
                    " systems. Similar to EPP I, students will first learn the fundamental principles on certain" +
                    " advanced concepts and then design and programme a real-world system. The course involves" +
                    " designing a complex computer engineering system that facilitates information processing," +
                    " real-world interfacing, and understanding the effects of certain useful metrics such as," +
                    " scaling, safety, security, sustainability, societal impact, fault-tolerant design, etc.",
                    4, "CG2111A", 0, 1, 5, 1.5, 2.5, "If undertaking an Undergraduate Degree THEN must not have" +
                    " completed CG1112", "If undertaking an Undergraduate Degree THEN must have completed 1 of" +
                    " any Courses (Modules) beginning with CS1010 at a grade of at least D"),

            new Mod("Design Thinking", "In this course, students use design principles to develop" +
                    " their creative potential and practise design thinking using a people-centered approach to" +
                    " solve problems and create new possibilities. Through practical activities, students will" +
                    " discover tools and mindsets that guide them in navigating ambiguity in a creative process," +
                    " observing and learning from others in unfamiliar contexts, and generating and experimenting" +
                    " with ideas quickly. While students draw on design thinking as a personal creative skillset," +
                    " they will also value the impact of design that affords people the opportunity and privilege" +
                    " to shape the world that they, and others, inhabit.",
                    4, "DTK1234", 1, 2, 0, 5, 2, "No preclusions", "No prerequisites"),

            new Mod("Linear Algebra for Engineering","This course is targeted at Engineering" +
                    " students from the College of Design and Engineering (CDE) and it provides the basic" +
                    " fundamental principles of Linear Algebra relevant to the field of Engineering. Topics" +
                    " include: System of linear equations and their solutions, Gaussian elimination, Matrices," +
                    " Matrix operations and Invertibility, Determinant of a matrix, Euclidean space and vectors," +
                    " Subspaces, Linear combinations and linear span, Linear independence, Basis and coordinate" +
                    " vectors, Dimension of a vector space, Rank and nullity theorem for matrices, Linear" +
                    " approximation and least squares solution to a linear system, Orthogonal projection," +
                    " Eigenvalues, eigenvectors and diagonalisation, Complex numbers and Applications of" +
                    "eigenvalues and eigenvectors to differential equations.",
                    4, "MA1508E", 3, 2, 0, 0, 5, "If undertaking an Undergraduate Degree THEN ( must not have" +
                    " completed 1 of MA1311/MA1513/MA1522/MA2001/YSC2232 at a grade of at least D)", "If undertaking" +
                    " an Undergraduate Degree THEN (( must have completed 1 of 06 MATHEMATICS/07 FURTHER" +
                    " MATHEMATICS at a grade of at least E) OR ( must have completed 1 of MA1301/MA1301X at a" +
                    " grade of at least D))"),

            new Mod("Fundamentals of Project Management", "The course covers the fundamental" +
                    " concepts of project management, identifying nine broad project management knowledge areas." +
                    " Students are given an introduction to theories relating to the management of project scope," +
                    " time, cost, risk, quality, human resources, communications and procurement. The overall" +
                    " integration of these eight knowledge areas and the management of externalities as the ninth" +
                    " project management knowledge area is also emphasised.",
                    4, "PF1101", 2, 1, 0, 3, 4, "No preclusions", "No prerequisites"),

            new Mod("Quantitative Reasoning with Data", "This course aims to equip undergraduate" +
                    " students with essential data literacy skills to analyse data and make decisions under" +
                    " uncertainty. It covers the basic principles and practice for collecting data and extracting" +
                    " useful insights, illustrated in a variety of application domains. For example, when two " +
                    " issues are correlated (e.g., smoking and cancer), how can we tell whether the relationship" +
                    " is causal (e.g., smoking causes cancer)? How can we deal with categorical data? Numerical" +
                    " data? What about uncertainty and complex relationships? These and many other questions will" +
                    " be addressed using data software and computational tools, with real-world data sets." +
                    " Short Syllabus: The PPDAC cycle (Spiegelhalter, D., 2019, The Art of Statistics; MacKay," +
                    " R.J., R.W. Oldford, 2000, Scientific Method, Statistical Method and the Speed of Light," +
                    " Statistical Science) will be used as a framework to highlight and demonstrate the process" +
                    " of dealing with and making sense of data. The course will consist of four chapters," +
                    " broadly described below. Getting data: collection/sampling, experiments/observational" +
                    " studies, data cleaning/recoding, interpreting summary statistics (mode, mean, quartiles," +
                    " standard deviation, etc.). Categorical data analysis: bar plots, contingency tables," +
                    " rates/ratios, association, Simpson’s Paradox. Dealing with numerical data: histograms," +
                    " boxplots, scatter plots, correlation, ecological and atomistic fallacies, simple linear" +
                    " regression. Statistical Inference: probability, conditional probability, prosecutor's" +
                    " fallacy, base rate fallacy, conjunction fallacy, understanding hypothesis tests," +
                    " interpreting confidence intervals, learning about a population based on a sample," +
                    " simple simulation. Exploratory data analysis (EDA) will be incorporated extensively" +
                    " into the content. Students will appreciate that even simple plots and contingency " +
                    " tables can give them valuable insights about data. There will be an emphasis on using " +
                    " suitable real world data sets as motivating examples to introduce content and through " +
                    " the process of problem solving, elucidate techniques/materials in the syllabus.",
                    4 ,"GEA1000", 2.5, 1.5, 3, 0, 3, "No preclusions", "No prerequisites")
    ));

    public static final List<Mod> YEAR2SEM1MODULES = new ArrayList<>(Arrays.asList(
            new Mod("Discrete Structures", "This course introduces mathematical tools" +
                    " required in the study of computer science. Topics include: (1) Logic and proof techniques:" +
                    " propositions, conditionals, quantifications. (2) Relations and Functions: Equivalence" +
                    " relations and partitions. Partially ordered sets. Well-Ordering Principle. Function" +
                    " equality. Boolean/identity/inverse functions. Bijection. (3) Mathematical formulation" +
                    " of data models (linear model, trees, graphs). (4) Counting and Combinatoric:" +
                    " Pigeonhole Principle. Inclusion-Exclusion Principle. Number of relations on a set," +
                    " number of injections from one finite set to another, Diagonalisation proof: An infinite" +
                    " countable set has an uncountable power set; Algorithmic proof: An infinite set has a countably" +
                    " infinite subset. Subsets of countable sets are countable.",
                    4, "CS1231", 3, 1, 0, 3, 3, "If undertaking an Undergraduate Degree THEN ( must not have" +
                    " completed 1 of CS1231S/MA1100/MA1100T at a grade of at least D)", "If undertaking an" +
                    " Undergraduate Degree THEN ( must have completed 1 of 06 MATHEMATICS/07 FURTHER MATHEMATICS/21" +
                    " PURE MATHEMATICS/22 APPLIED MATHEMATICS at a grade of at least E AND must be H2 OR must have" +
                    " completed 1 of MA1301/MA1301X at a grade of at least D)"),

            new Mod("Data Structures and Algorithms", "This course introduces students to" +
                    " the design and implementation of fundamental data structures and algorithms. The course" +
                    " covers basic data structures (linked lists, stacks, queues, hash tables, binary heaps, trees," +
                    " and graphs), searching and sorting algorithms, basic analysis of algorithms," +
                    " and basic object-oriented programming concepts.",
                    4, "CS2040C", 3, 0, 1, 3, 3, "If undertaking an Undergraduate Degree THEN ( must not have" +
                    " completed 1 of CS1020/CS1020E/CS2010/CS2020/CS2040/CS2040DE/CS2040S at a grade of at least D)",
                    " If undertaking an Undergraduate Degree THEN ( must have completed 1 of 06" +
                    " MATHEMATICS/07 FURTHER MATHEMATICS/21 PURE MATHEMATICS/22 APPLIED MATHEMATICS at a grade of at" +
                    " least E AND must be H2 OR must have completed 1 of MA1301/MA1301X at a grade of at least D)"),

            new Mod("Systems Thinking and Dynamics", "The course aims to introduce students" +
                    " to the fundamental concepts and underlying principles of system thinking, design and" +
                    " dynamics. It will provide students with an understanding of systems thinking and applying" +
                    " systems dynamics modelling to describe and simulate real world problems. At the end of the" +
                    " course, students should have the necessary knowledge and abilities to define, analyse," +
                    " design, and develop a system dynamics model that simulates a specific problem and recommend" +
                    " solutions for different scenarios.",
                    4, "IE2141", 2, 3, 0, 3, 2, "If undertaking an Undergraduate Degree THEN must not have completed" +
                    " 1 of any Courses beginning with UTC1702 at a grade of at least D, GEM1915/GET1011/IE2101 at a" +
                    " grade of at least D", "No prerequisites"),

            new Mod("Critique and Communication of Thinking and Design", "This course equips" +
                    " students with competencies that enable students to analyze, critique, and communicate" +
                    " engineering and design ideas in a systematic and thoughtful manner. Students will be" +
                    " introduced to the Engineering Reasoning Framework (Paul, Niewoehner and Elder, 2019)," +
                    " as well as key principles of effective academic communication. Students will learn to" +
                    " apply the critical thinking framework and communication principles to critique ideas" +
                    " expressed in different genres and to convey these in critique essays. They will also" +
                    " engage in a group project aimed at promoting critical analysis and communication in teams" +
                    " that will culminate in a team academic oral presentation.",
                    4, "ES2631", 1.5, 2, 0, 4, 2.5, "If undertaking an Undergraduate Degree THEN (( must not have" +
                    " completed 1 of GEK1549, GET1021, any Courses (Modules) beginning with UTW1001, ES1531/ES2531" +
                    " at a grade of at least D) AND (must not be undertaking 1 of 1501TMBSPL UTown College Programme" +
                    " - Tembusu, 1501TMRSPL UTown Resident - Tembusu, 1502ANRSPL UTown Resident - CAPT, 1502ANGSPL" +
                    " UTown College Programme - CAPT, 1503RC4SPL UTown College Programme - RC4, 1503R4RSPL UTown" +
                    " Resident - RC4, 1520RVCSPL Ridge View Residential College Programme))", "If undertaking" +
                    " an Undergraduate Degree THEN ((must be undertaking 1 of 2001CEGHON Bachelor of Engineering" +
                    " (Computer Engineering) (Hons), 0607ISEHON Bachelor of Engineering (Industrial and Systems" +
                    " Engineering) (Hons), 0609MEHON Bachelor of Engineering (Mechanical Engineering) (Hons)," +
                    " 0613EVEHON Bachelor of Engineering (Environmental Engineering) (Hons), 0605ESPHON Bachelor" +
                    " of Engineering (Engineering Science) (Hons), 0601BMEHON Bachelor of Engineering (Biomedical" +
                    " Engineering) (Hons), 0604ELEHON Bachelor of Engineering (Electrical Engineering) (Hons)," +
                    " 0608MSEHON Bachelor of Engineering (Materials Science and Engineering) (Hons), 0613CEHON" +
                    " Bachelor of Engineering (Civil Engineering) (Hons), 0602CHEHON Bachelor of Engineering" +
                    " (Chemical Engineering) (Hons), 0616IPMHON BEng (Infrastructure and Project Management)" +
                    " (Hons), 0616PFMHON BSc (Project and Facilities Management) (Hons)) AND (must be in one of" +
                    " the cohorts prior to 2013 inclusive OR must be in one of the cohorts from 2016 inclusive )" +
                    " AND must have completed EP ENGLISH LANGUAGE PROFICIENCY TEST at a grade of at least N)"),

            new Mod("Cultures and Connections", "", 4, "GEC1XXX",
                    0, 0, 0, 0, 0, "Unconfirmed preclusions", "Unconfirmed prerequisites")
    ));

    public static final List<Mod> YEAR2SEM2MODULES = new ArrayList<>(Arrays.asList(
            new Mod("Signals and Systems", "This is a fundamental course in signals and systems," +
                    " specially developed for computer engineering students. Signals play an important role in" +
                    " carrying information. In particular the idea of frequency domain analysis of signals and" +
                    " systems are important concepts for all computer engineers. The concepts which will be" +
                    " covered include time and frequency domain representations, Fourier transform, spectrum" +
                    " and bandwidth of a signal, frequency response of linear time-invaraint(LTI) systems," +
                    " system tranfer function and system stability, system Bode diagrams, sampling theorem," +
                    " aliasing, signal reconstruction, and filtering.",
                    4, "CG2023", 2, 2, 1, 2, 3, "If undertaking an Undergraduate Degree THEN must not have completed" +
                    " 1 of EE2023/EE2023E/TEE2023 at a grade of at least D", "If undertaking an Undergraduate" +
                    " Degree THEN must have completed 1 of CE2407B/MA1506/MA1512 at a grade of at least D"),

            new Mod("Software Engineering & Object-Oriented Programming", "This course introduces" +
                    " the necessary skills for systematic and rigorous development of software systems. It covers" +
                    " requirements, design, implementation, quality assurance, and project management aspects of" +
                    " small-to-medium size multi-person software projects. The course uses the Object Oriented" +
                    " Programming paradigm. Students of this course will receive hands-on practice of tools commonly" +
                    " used in the industry, such as test automation tools, build automation tools, and code" +
                    " revisioning tools will be covered.",
                    4, "CS2113", 2, 1, 0, 3, 4, "If undertaking an Undergraduate Degree THEN( must not have" +
                    " completed 1 of CS2103/CS2103DE/CS2103T/CS2113T at a grade of at least D)", "If undertaking" +
                    " an Undergraduate Degree THEN( must have completed CS2040C at a grade of at least DOR( must" +
                    " have completed CS2030 at a grade of at least D AND must have completed 1 of CS2040/CS2040S at" +
                    " a grade of at least D))"),

            new Mod("Introduction to Machine Learning", "This course introduces students to" +
                    " various machine learning concepts and applications, and the tools needed to understand" +
                    " them. Topics include supervised and unsupervised machine learning techniques, optimization," +
                    " overfitting, regularization, cross-validation and evaluation metrics. The mathematical" +
                    " tools include basic topics in probability and statistics, linear algebra, and optimization." +
                    " These concepts will be illustrated through various machine-learning techniques and examples.",
                    4, "EE2211", 2, 2, 0, 0, 5, "No preclusions",  "If undertaking an Undergraduate Degree " +
                    " ( must have completed 1 of any Courses (Modules) beginning with CS1010 at a grade of at least" +
                    " D AND must have completed 1 of MA1505/MA1511 at a grade of at least D AND must have completed" +
                    " 1 of CE2407B/MA1508E/MA1513 at a grade of at least D)"),

            new Mod("Digital Design", "This is a first course that introduces fundamental" +
                    " digital logic, digital circuits, and programmable devices. This course provides students" +
                    " with an understanding of the building blocks of modern digital systems and methods of" +
                    " designing, simulating and realizing such systems. The emphasis of this course is on" +
                    " understanding the fundamentals of digital design across different levels of abstraction" +
                    " using hardware description languages, and developing a solid design perspective towards" +
                    " complex digital systems.",
                    4, "EE2026", 3, 1, 1, 1, 4, "If undertaking an Undergraduate Degree THEN ( must not have" +
                    " completed EE2020 at a grade of at least D)", "If undertaking an Undergraduate Degree" +
                    " THEN ( must have completed 1 of CG1111A/EE1111A/EE1111B/EE2111A at a grade of at least D)" +
                    " AND ( must have completed 1 of CS1010/CS1010E at a grade of at least D)"),

            new Mod("Liveable Cities", "he course introduces students to how cities are" +
                    " governed, planned, developed and managed to achieve the liveability outcomes of quality" +
                    " of life, sustainable environment and a competitive economy using the case study of" +
                    " Singapore and other cities, through a systems thinking lens. Students will understand" +
                    " the role that urban systems professionals, such as urban policymakers, planners," +
                    " architects, engineers, real estate consultants and managers play in achieving liveable" +
                    " city outcomes in an integrated way, through combining their individual expertise in" +
                    " different disciplines.",
                    4, "CDE2501", 2, 2, 0, 4, 2, "If undertaking an Undergraduate Degree THEN ( must not have" +
                    " completed EG2501 at a grade of at least D)", "No prerequisites")
    ));

    public static final List<Mod> YEAR3SEM1MODULES = new ArrayList<>(Arrays.asList(
            new Mod("Engineering Professionalism", "This course aims to alert and sensitise" +
                    " students on the kinds of situations that may arise in his professional career and teaches" +
                    " students to improve his/her skills in appreciating and dealing with the moral challenges" +
                    " posed by such situations. Students will acquire skills in dealing with ethical issues," +
                    " learn about the 'codes of ethics' set by professional bodies and intellectual property rights" +
                    " and protection.",
                    2, "EG2401A", 2, 0.5, 0, 0, 2.5, "No preclusions", "If undertaking an Undergraduate Degree" +
                    " THEN must be Year 2,3 or 4"),

            new Mod("Industrial Attachment", "This internship course is for B.Eng. degree with" +
                    " minimum 20-week internship. The type of internship varies according to the programmes." +
                    " Internships integrate knowledge and theory learned in the classroom with practical application" +
                    " and skill development in a professional setting. It enables students to learn about the" +
                    " latest developments in the industries and to interact with engineers and other professionals" +
                    " as they join projects or tasks that help to develop or enhance their skills whilst" +
                    " contributing to the organisation.",
                    10, "EG3611A", 0, 0, 0, 36, 4, "If undertaking an Undergraduate Degree THEN must not have" +
                    " completed EG3601 AND must not have completed EG3611", "Students should be or are expected" +
                    " to be at least Year 3 in standing"),

            new Mod("Advanced Technology Attachment Programme", "This course enables students" +
                    " to apply the computing knowledge they have assimilated in class to industrial projects" +
                    " through six-month attachment to companies/organizations. Students under attachment will" +
                    " be jointly guided by supervisors from both the companies/organizations and the school." +
                    " Their progress on projects will be monitored during attachment, and their performance" +
                    " will be assessed (on Satisfactory/Unsatisfactory (S/U) basis) at the end of the attachment," +
                    " based on the interim and final project reports. During the attachment, students are not" +
                    " expected to take other courses offered by the university.",
                    12, "CP3880", 0, 0, 0, 30, 0, "If undertaking an Undergraduate Degree THEN ( must not have" +
                    " completed EG3601 at a grade of at least D)", "If undertaking an Undergraduate Degree THEN" +
                    " ( must have completed 1 of any Courses (Modules) beginning with UTW1001 at a grade of at" +
                    " least D, CS2101/ES1601/ES2002/ES2007D/ES2531/ES2631/IS2101/NTW2017/NTW2028/NTW2029/NTW2030/" +
                    "NTW2031/NTW2032/NTW2033/NTW2034/UWC2101% at a grade of at least D AND must have completed 1" +
                    " of BT3103/CS2103/CS2103T/CS2113/CS2113T/IS3106 at a grade of at least D)"),

            new Mod("Unrestricted Elective", "", 4, "UE",
                    0, 0, 0, 0, 0, "Unconfirmed preclusions", "Unconfirmed prerequisites")
    ));

    public static final List<Mod> YEAR3SEM2MODULES = new ArrayList<>(Arrays.asList(
            new Mod("Transistor-level Digital Circuits", "Building on the basic circuit" +
                    " concepts introduced through CG1111A and CG2111A, this course introduces the fundamental" +
                    " concept of carriers, operating principles of PN diodes and MOSFETs. Their IV" +
                    " characteristic in different operating region and their impact on the performance" +
                    " of logic gate will also be discussed. It explains the foundational concepts of" +
                    " inverters and analyses their performance in terms of power and delay trade-off." +
                    " It also introduces logic synthesis and the fundamental timing analysis of logic" +
                    " gates. Besides the static CMOS logic, it will also cover pass logics or transmission" +
                    " gates logics.",
                    2 , "CG2027", 1.5, 0.5, 0, 0, 3, "No preclusions", "If undertaking an Undergraduate Degree" +
                    " THEN ( must have completed 1 of BN1102/CG1111/CG1111A/EE1112/EE2111A/EG1111/EG1112 at a" +
                    " grade of at least D)"),

            new Mod("Computer Organization", "his course teaches students computer" +
                    " organization concepts and how to write efficient microprocessor programs using" +
                    " assembly language. The course covers computer microarchitecture and memory system" +
                    " fundamentals, and the ARM microprocessor instruction set. The course culminates" +
                    " in an assignment in which students design and implement an efficient assembly" +
                    " language solution to an engineering problem.",
                    2, "CG2028", 2, 1, 1, 0, 1, "If undertaking an Undergraduate Degree THEN must not have" +
                    " completed EE2028 at a grade of at least D", "If undertaking an Undergraduate Degree" +
                    " THEN ( must have completed 1 of CS1010/CS1010E/CS1010X at a grade of at least D AND" +
                    " must have completed EE2026 at a grade of at least D)"),

            new Mod("Real-Time Operating Systems", "Real-time systems must respond" +
                    " quickly to inputs from the environment in order to work effectively and safely," +
                    " and realtime operating systems (RTOS) are a critical part of such systems." +
                    " In this course the student is exposed to basic RTOS concepts like tasks," +
                    " scheduling algorithms, RTOS customisation and concurrent real-time programming." +
                    " By the end of this course a student will not only understand how an RTOS is built," +
                    " but will also gain practical hands-on experience in customising RTOSs and in writing" +
                    " real-time programs.",
                    4, "CG2271", 2, 1, 2, 3, 2, "If undertaking an Undergraduate Degree then ( must not have" +
                    " completed 1 of CS2271/CS2106 at a grade of at least D )", "If undertaking an Undergraduate" +
                    " Degree then ( must have completed 1 of CS1020/CS1020E/CS2020/CS2040/CS2040C at a grade" +
                    " of at least D )"),

            new Mod("Creating Narratives", "Creating Narratives is an interdisciplinary course" +
                    " which aims to explore the principles of communication in Design and Engineering. The" +
                    " purpose of the course is to make explicit to students how they can draw on visual and" +
                    " verbal resources to clearly articulate the valued knowledge in their disciplines to both" +
                    " specialist and non-specialist audiences in a succinct manner. Students will explore a" +
                    " range of narratives around multimodal artefacts such as posters, renderings, drawings," +
                    " models and exhibits from these disciplines to become familiar with the ways to engage," +
                    " inform, critique and persuade different audiences and communicate their designs" +
                    " effectively.",
                    4, "CDE2000", 1, 2, 0, 0, 3, "No preclusions", "No prerequisites"),

            new Mod("Probability and Statistics", "This course introduces students to basic" +
                    " probability theory and statistical inference. Topics include basic concepts of" +
                    " probability, conditional probability, independence, random variables, joint and marginal" +
                    " distributions, mean and variance, some common probability distributions, sampling" +
                    " distributions, estimation and hypothesis testing based on a normal population.",
                    4, "ST2334", 3, 1, 0, 3, 3, "If undertaking an Undergraduate Degree THEN ( must not have" +
                    " completed 1 of CE2407/DSC2008/EC2303/MA2116/MA2216/MA2301/PR2103/ST1232/ST2131 at a grade" +
                    " of at least D)", "If undertaking an Undergraduate Degree THEN ( must have completed 1" +
                    " of MA1102R/MA1312/MA1505/MA1507/MA1511/MA1521/MA2002 at a grade of at least D)")

            ));

    public static final List<Mod> YEAR4SEM1MODULES = new ArrayList<>(Arrays.asList(
            new Mod("Computer Engineering Capstone Project", "This course introduces students" +
                    " to the development of a large system from conceptualisation to its final implementation." +
                    " It is structured to contain substantial design and development of hardware and software" +
                    " components. This course is the culminating point of a series of courses integrating the" +
                    " theories which students learn in CS1010, CS2040C, CG2028, CG2271 and CS2113/T. With this" +
                    " capstone project, students would be able to better appreciate the relevance of the" +
                    " various components in the Computer Engineering curriculum to large scale computer" +
                    " engineering projects.",
                    8, "CG4002", 1, 0, 3, 12, 4, "If undertaking an Undergraduate Degree THEN ( must not have" +
                    " completed CG3002 at a grade of at least D)", "If undertaking an Undergraduate Degree" +
                    " THEN must have completed CS2113/CS2113T at a grade of at least D"),

            new Mod("Computer Networks", "This course provides an in-depth treatment of" +
                    " fundamental topics of network design based on the Internet protocol stack model. It is" +
                    " aimed at making students understand how networks work through understanding of the" +
                    " underlying principles of sound network design. This course covers topics including" +
                    " network requirements, architecture, protocol stack models, Ethernet Token Ring," +
                    " Wireless, and FDDI networks, bridges, switching and routing in IP and ATM networks," +
                    " and internetworking. Apart from learning the concepts in networks, the students will" +
                    " gain expertise in analyzing and designing networking protocols through mini-projects.",
                    4,"EE4204", 2, 1, 1, 1.5, 4.5, "(If undertaking a Graduate Degree Coursework OR if" +
                    " undertaking an Undergraduate Degree) THEN must not have completed 1 of CEG5101/CS2105" +
                    "/EE3204/EE5310/EE6310/TEE3204/TEE4204 at a grade of at least D", "If undertaking an" +
                    " Undergraduate Degree THEN ( must have completed 1 of EE2012/EE2012A/ESP2107/ST2334 at a" +
                    " grade of at least D OR (must be undertaking 2001CEGHON Bachelor of Engineering (Computer" +
                    " Engineering) (Hons) AND must be Year 2,3 or 4)). CEG students are encouraged to take" +
                    " ST2334 (as UEM) to better prepare themselves for EE4204. Otherwise, they need to self-study" +
                    " the necessary topics in ST2334 relevant to EE4204."),

            new Mod("Communities and Engagement", "", 4, "GEN1XXX",
                    0, 0, 0, 0, 0, "Unconfirmed preclusions", "Unconfirmed prerequisites"),
            new Mod("Unrestricted Elective", "", 4, "UE",
                    0, 0, 0, 0, 0, "Unconfirmed preclusions", "Unconfirmed prerequisites")

            ));

    public static final List<Mod> YEAR4SEM2MODULES = new ArrayList<>(Arrays.asList(
            new Mod("Unrestricted Elective", "", 4, "UE",
                    0, 0, 0, 0, 0, "Unconfirmed preclusions", "Unconfirmed prerequisites"),
            new Mod("Unrestricted Elective", "", 4, "UE",
                    0, 0, 0, 0, 0, "Unconfirmed preclusions", "Unconfirmed prerequisites"),
            new Mod("Unrestricted Elective", "", 4, "UE",
                    0, 0, 0, 0, 0, "Unconfirmed preclusions", "Unconfirmed prerequisites"),
            new Mod("Unrestricted Elective", "", 4, "UE",
                    0, 0, 0, 0, 0, "Unconfirmed preclusions", "Unconfirmed prerequisites"),
            new Mod("Unrestricted Elective", "", 4, "UE",
                    0, 0, 0, 0, 0, "Unconfirmed preclusions", "Unconfirmed prerequisites")

    ));

}
