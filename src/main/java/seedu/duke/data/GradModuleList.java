package seedu.duke.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradModuleList {

    public static final List<Mod> Year1Sem1Modules = new ArrayList<>(Arrays.asList(
            new Mod("Engineering Principles and Practice I",
    "This course is the first of the two Engineering Principles and Practice (EPP) courses taken by " +
            "computer engineering students, which aim to inculcate in them the computer engineer's way of thinking." +
            " They are first taught the fundamental principles of electronic circuits through experiential learning," +
            " along which they also build up their hands-on circuit designing, building, and debugging skills. They" +
            " are then guided to apply these principles and skills to build a sensor-assisted autonomous robotic" +
            " vehicle as a grand finale challenge. Upon completing the course, they can appreciate the importance of" +
            " circuits, signals, and sensors in system implementation.", 4, "CG1111A"),

            new Mod("Programming Methodology", "This course introduces the fundamental concepts of " +
                    "problem solving by computing and programming using an imperative programming language. It is the" +
                    " first and foremost introductory course to computing. Topics covered include computational " +
                    "thinking and computational problem solving, designing and specifying an algorithm, basic problem" +
                    " formulation and problem solving approaches, program development, coding, testing and debugging," +
                    " fundamental programming constructs (variables, types, expressions, assignments, functions," +
                    " control structures, etc.), fundamental data structures (arrays, strings, composite data types)," +
                    " basic sorting, and recursion.", 4, "CS1010"),

            new Mod("Design and Make", "This course covers the fundamentals of engineering design" +
                    " and prototyping. Students will learn design principles and tools through lectures and engage" +
                    " in experiential learning through group design projects. A stage-based design process will be" +
                    " covered. Students will develop skills in Arduino-controlled electronics, CAD modelling, and" +
                    " rapid prototyping to demonstrate their ideas.\n", 4, "EG1311"),

            new Mod("Engineering Calculus", "This is a seven-week course specially designed for" +
                    " students majoring in Engineering. It introduces the basic concepts in one variable and several" +
                    " variable calculus with applications in engineering. Main topics: One variable calculus." +
                    " Power series. Partial differentiation. Multiple integrals. Vector Calculus.", 2,
                    "MA1511"),

            new Mod("Differential Equations for Engineering", "This is a seven-week course specially" +
                    " designed for students majoring in Engineering. It introduces the basic concepts in the study" +
                    " of differential equations, with an emphasis on applications in engineering and other fields" +
                    ". Major topics include modelling with differential equations, first-order ordinary differential" +
                    " equations, higher-order linear differential equations, the Laplace transform, and partial" +
                    " differential equations.", 2, "MA1512"),

            new Mod("English for Academic Purposes", "ES1103 serves as a bridging course for" +
                    " students who have taken the university’s Qualifying English Test and are deemed to require" +
                    " additional language support for the academic context. It aims to equip students with the" +
                    " knowledge of the academic genre and the ability to apply such knowledge in academic" +
                    " communication. The course adopts a reading-into-writing approach using themed readings" +
                    " as springboard texts for students’ writing and provides opportunities for analysing and" +
                    " internalising ways of organising academic texts. Students will acquire essential academic" +
                    " skills required to cope with the rigour of academic writing at a tertiary level.",
                    4, "ES1103")
    ));

    public static final List<Mod> Year1Sem2Modules = new ArrayList<>(Arrays.asList(
            new Mod("Engineering Principles and Practice II", "This course will be for the students" +
                    " who have completed EPP I and the project scope extends to handle challenges in large-scale" +
                    " systems. Similar to EPP I, students will first learn the fundamental principles on certain" +
                    " advanced concepts and then design and programme a real-world system. The course involves" +
                    " designing a complex computer engineering system that facilitates information processing," +
                    " real-world interfacing, and understanding the effects of certain useful metrics such as," +
                    " scaling, safety, security, sustainability, societal impact, fault-tolerant design, etc."
                    , 4, "CG2111A"),

            new Mod("Design Thinking", "In this course, students use design principles to develop" +
                    " their creative potential and practise design thinking using a people-centered approach to" +
                    " solve problems and create new possibilities. Through practical activities, students will" +
                    " discover tools and mindsets that guide them in navigating ambiguity in a creative process," +
                    " observing and learning from others in unfamiliar contexts, and generating and experimenting" +
                    " with ideas quickly. While students draw on design thinking as a personal creative skillset," +
                    " they will also value the impact of design that affords people the opportunity and privilege" +
                    " to shape the world that they, and others, inhabit.", 4, "DTK1234"),

            new Mod("Linear Algebra for Engineering","This course is targeted at Engineering" +
                    " students from the College of Design and Engineering (CDE) and it provides the basic fundamental" +
                    " principles of Linear Algebra relevant to the field of Engineering. Topics include: System of" +
                    " linear equations and their solutions, Gaussian elimination, Matrices, Matrix operations and" +
                    " Invertibility, Determinant of a matrix, Euclidean space and vectors, Subspaces, Linear" +
                    " combinations and linear span, Linear independence, Basis and coordinate vectors, Dimension" +
                    " of a vector space, Rank and nullity theorem for matrices, Linear approximation and least" +
                    " squares solution to a linear system, Orthogonal projection, Eigenvalues, eigenvectors and" +
                    " diagonalisation, Complex numbers and Applications of eigenvalues and eigenvectors to" +
                    " differential equations.", 4, "MA1508E"),

            new Mod("Fundamentals of Project Management", "The course covers the fundamental" +
                    " concepts of project management, identifying nine broad project management knowledge areas." +
                    " Students are given an introduction to theories relating to the management of project scope," +
                    " time, cost, risk, quality, human resources, communications and procurement. The overall" +
                    " integration of these eight knowledge areas and the management of externalities as the ninth" +
                    " project management knowledge area is also emphasised.", 4, "PF1101"),

            new Mod("Quantitative Reasoning with Data", "This course aims to equip undergraduate" +
                    " students with essential data literacy skills to analyse data and make decisions under" +
                    " uncertainty. It covers the basic principles and practice for collecting data and extracting" +
                    " useful insights, illustrated in a variety of application domains. For example, when two " +
                    "issues are correlated (e.g., smoking and cancer), how can we tell whether the relationship" +
                    " is causal (e.g., smoking causes cancer)? How can we deal with categorical data? Numerical" +
                    " data? What about uncertainty and complex relationships? These and many other questions will" +
                    " be addressed using data software and computational tools, with real-world data sets. " +
                    "Short Syllabus: The PPDAC cycle (Spiegelhalter, D., 2019, The Art of Statistics; MacKay," +
                    " R.J., R.W. Oldford, 2000, “Scientific Method, Statistical Method and the Speed of Light,”" +
                    " Statistical Science) will be used as a framework to highlight and demonstrate the process" +
                    " of dealing with and making sense of data. The course will consist of four chapters" +
                    ", broadly described below. Getting data: collection/sampling, experiments/observational studies" +
                    ", data cleaning/recoding, interpreting summary statistics (mode, mean, quartiles," +
                    " standard deviation, etc.). Categorical data analysis: bar plots, contingency tables" +
                    ", rates/ratios, association, Simpson’s Paradox. Dealing with numerical data: histograms," +
                    " boxplots, scatter plots, correlation, ecological and atomistic fallacies, simple linear" +
                    " regression. Statistical Inference: probability, conditional probability, prosecutor's" +
                    " fallacy, base rate fallacy, conjunction fallacy, understanding hypothesis tests," +
                    " interpreting confidence intervals, learning about a population based on a sample," +
                    " simple simulation. Exploratory data analysis (EDA) will be incorporated extensively" +
                    " into the content. Students will appreciate that even simple plots and contingency " +
                    "tables can give them valuable insights about data. There will be an emphasis on using " +
                    "suitable real world data sets as motivating examples to introduce content and through " +
                    "the process of problem solving, elucidate techniques/materials in the syllabus.",
                    4 ,"GEA1000")
    ));

    public static final List<Mod> Year2Sem1Modules = new ArrayList<>(Arrays.asList(
            new Mod("Discrete Structures", "This course introduces mathematical tools " +
                    "required in the study of computer science. Topics include: (1) Logic and proof techniques:" +
                    " propositions, conditionals, quantifications. (2) Relations and Functions: Equivalence" +
                    " relations and partitions. Partially ordered sets. Well-Ordering Principle. Function" +
                    " equality. Boolean/identity/inverse functions. Bijection. (3) Mathematical formulation" +
                    " of data models (linear model, trees, graphs). (4) Counting and Combinatoric:" +
                    " Pigeonhole Principle. Inclusion-Exclusion Principle. Number of relations on a set," +
                    " number of injections from one finite set to another, Diagonalisation proof: An infinite" +
                    " countable set has an uncountable power set; Algorithmic proof: An infinite set has a" +
                    " countably infinite subset. Subsets of countable sets are countable.", 4, "CS1231"),

            new Mod("Data Structures and Algorithms", "This course introduces students to" +
                    " the design and implementation of fundamental data structures and algorithms. The course" +
                    " covers basic data structures (linked lists, stacks, queues, hash tables, binary heaps, trees," +
                    " and graphs), searching and sorting algorithms, basic analysis of algorithms, " +
                    "and basic object-oriented programming concepts.", 4, "CS2040C"),

            new Mod("Systems Thinking and Dynamics", "The course aims to introduce students " +
                    "to the fundamental concepts and underlying principles of system thinking, design and" +
                    " dynamics. It will provide students with an understanding of systems thinking and applying " +
                    "systems dynamics modelling to describe and simulate real world problems. At the end of the " +
                    "course, students should have the necessary knowledge and abilities to define, analyse, " +
                    "design, and develop a system dynamics model that simulates a specific problem and recommend " +
                    "solutions for different scenarios.", 4, "IE2141"),

            new Mod("Critique and Communication of Thinking and Design", "This course equips " +
                    "students with competencies that enable students to analyze, critique, and communicate" +
                    " engineering and design ideas in a systematic and thoughtful manner. Students will be " +
                    "introduced to the Engineering Reasoning Framework (Paul, Niewoehner and Elder, 2019)," +
                    " as well as key principles of effective academic communication. Students will learn to " +
                    "apply the critical thinking framework and communication principles to critique ideas " +
                    "expressed in different genres and to convey these in critique essays. They will also " +
                    "engage in a group project aimed at promoting critical analysis and communication in " +
                    "teams that will culminate in a team academic oral presentation.", 4, "ES2631"),

            new Mod("Cultures and Connections", "", 4, "GEC1XXX" )
    ));

    public static final List<Mod> Year2Sem2Modules = new ArrayList<>(Arrays.asList(
            new Mod("Signals and Systems", "This is a fundamental course in signals and systems, " +
                    "specially developed for computer engineering students. Signals play an important role in " +
                    "carrying information. In particular the idea of frequency domain analysis of signals and " +
                    "systems are important concepts for all computer engineers. The concepts which will be " +
                    "covered include time and frequency domain representations, Fourier transform, spectrum " +
                    "and bandwidth of a signal, frequency response of linear time-invaraint(LTI) systems, " +
                    "system tranfer function and system stability, system Bode diagrams, sampling theorem, " +
                    "aliasing, signal reconstruction, and filtering.", 4, "CG2023"),

            new Mod("Software Engineering & Object-Oriented Programming", "This course introduces " +
                    "the necessary skills for systematic and rigorous development of software systems. It covers" +
                    " requirements, design, implementation, quality assurance, and project management aspects of" +
                    " small-to-medium size multi-person software projects. The course uses the Object Oriented " +
                    "Programming paradigm. Students of this course will receive hands-on practice of tools commonly " +
                    "used in the industry, such as test automation tools, build automation tools, and code " +
                    "revisioning tools will be covered.", 4, "CS2113"),

            new Mod("Introduction to Machine Learning", "This course introduces students to" +
                    " various machine learning concepts and applications, and the tools needed to understand" +
                    " them. Topics include supervised and unsupervised machine learning techniques, optimization," +
                    " overfitting, regularization, cross-validation and evaluation metrics. The mathematical " +
                    "tools include basic topics in probability and statistics, linear algebra, and optimization. " +
                    "These concepts will be illustrated through various machine-learning techniques and examples.",
                    4, "EE2211"),

            new Mod("Digital Design", "This is a first course that introduces fundamental " +
                    "digital logic, digital circuits, and programmable devices. This course provides students" +
                    " with an understanding of the building blocks of modern digital systems and methods of " +
                    "designing, simulating and realizing such systems. The emphasis of this course is on " +
                    "understanding the fundamentals of digital design across different levels of abstraction " +
                    "using hardware description languages, and developing a solid design perspective towards " +
                    "complex digital systems.", 4, "EE2026"),

            new Mod("Liveable Cities", "he course introduces students to how cities are " +
                    "governed, planned, developed and managed to achieve the liveability outcomes of quality" +
                    " of life, sustainable environment and a competitive economy using the case study of " +
                    "Singapore and other cities, through a systems thinking lens. Students will understand " +
                    "the role that urban systems professionals, such as urban policymakers, planners, " +
                    "architects, engineers, real estate consultants and managers play in achieving liveable " +
                    "city outcomes in an integrated way, through combining their individual expertise in " +
                    "different disciplines.", 4, "CDE2501")
    ));

    public static final List<Mod> Year3Sem1Modules = new ArrayList<>(Arrays.asList(
            new Mod("Engineering Professionalism", "This course aims to alert and sensitise " +
                    "students on the kinds of situations that may arise in his professional career and teaches " +
                    "students to improve his/her skills in appreciating and dealing with the moral challenges " +
                    "posed by such situations. Students will acquire skills in dealing with ethical issues, " +
                    "learn about the 'codes of ethics' set by professional bodies and intellectual property rights " +
                    "and protection.", 2, "EG2401A"),

            new Mod("Industrial Attachment", "This internship course is for B.Eng. degree with " +
                    " minimum 20-week internship. The type of internship varies according to the programmes. " +
                    "Internships integrate knowledge and theory learned in the classroom with practical application" +
                    " and skill development in a professional setting. It enables students to learn about the" +
                    " latest developments in the industries and to interact with engineers and other professionals" +
                    " as they join projects or tasks that help to develop or enhance their skills whilst " +
                    "contributing to the organisation.", 10, "EG3611A"),

            new Mod("Advanced Technology Attachment Programme", "This course enables students " +
                    "to apply the computing knowledge they have assimilated in class to industrial projects " +
                    "through six-month attachment to companies/organizations. Students under attachment will" +
                    " be jointly guided by supervisors from both the companies/organizations and the school." +
                    " Their progress on projects will be monitored during attachment, and their performance " +
                    "will be assessed (on Satisfactory/Unsatisfactory (S/U) basis) at the end of the attachment," +
                    " based on the interim and final project reports. During the attachment, students are not" +
                    " expected to take other courses offered by the university.", 12, "CP3880"),

            new Mod("Unrestricted Elective", "", 4, "UE")
    ));

    public static final List<Mod> Year3Sem2Modules = new ArrayList<>(Arrays.asList(
            new Mod("Transistor-level Digital Circuits", "Building on the basic circuit " +
                    "concepts introduced through CG1111A and CG2111A, this course introduces the fundamental" +
                    " concept of carriers, operating principles of PN diodes and MOSFETs. Their IV" +
                    " characteristic in different operating region and their impact on the performance" +
                    " of logic gate will also be discussed. It explains the foundational concepts of " +
                    "inverters and analyses their performance in terms of power and delay trade-off." +
                    " It also introduces logic synthesis and the fundamental timing analysis of logic " +
                    "gates. Besides the static CMOS logic, it will also cover pass logics or transmission" +
                    " gates logics.", 2 , "CG2027"),

            new Mod("Computer Organization", "his course teaches students computer " +
                    "organization concepts and how to write efficient microprocessor programs using " +
                    "assembly language. The course covers computer microarchitecture and memory system " +
                    "fundamentals, and the ARM microprocessor instruction set. The course culminates" +
                    " in an assignment in which students design and implement an efficient assembly" +
                    " language solution to an engineering problem.", 2, "CG2028"),

            new Mod("Real-Time Operating Systems", "Real-time systems must respond" +
                    " quickly to inputs from the environment in order to work effectively and safely" +
                    ", and realtime operating systems (RTOS) are a critical part of such systems. " +
                    "In this course the student is exposed to basic RTOS concepts like tasks, " +
                    "scheduling algorithms, RTOS customisation and concurrent real-time programming." +
                    " By the end of this course a student will not only understand how an RTOS is built," +
                    " but will also gain practical hands-on experience in customising RTOSs and in writing " +
                    "real-time programs.", 4, "CG2271"),

            new Mod("Creating Narratives", "Creating Narratives is an interdisciplinary course" +
                    " which aims to explore the principles of communication in Design and Engineering. The purpose " +
                    "of the course is to make explicit to students how they can draw on visual and verbal resource" +
                    "s to clearly articulate the valued knowledge in their disciplines to both specialist and no" +
                    "n-specialist audiences in a succinct manner. Students will explore a range of narratives a" +
                    "round multimodal artefacts such as posters, renderings, drawings, models and exhibits from t" +
                    "hese disciplines to become familiar with the ways to engage, inform, critique and persuade d" +
                    "ifferent audiences and communicate their designs effectively.", 4, "CDE2000"),

            new Mod("Probability and Statistics", "This course introduces students to basic prob" +
                    "ability theory and statistical inference. Topics include basic concepts of probability, condit" +
                    "ional probability, independence, random variables, joint and marginal distributions, mean and v" +
                    "ariance, some common probability distributions, sampling distributions, estimation and hypothes" +
                    "is testing based on a normal population.", 4, "ST2334")

            ));

    public static final List<Mod> Year4Sem1Modules = new ArrayList<>(Arrays.asList(
            new Mod("Computer Engineering Capstone Project", "This course introduces students to the" +
                    " development of a large system from conceptualisation to its final implementation. It is struc" +
                    "tured to contain substantial design and development of hardware and software components. This" +
                    " course is the culminating point of a series of courses integrating the theories which studen" +
                    "ts learn in CS1010, CS2040C, CG2028, CG2271 and CS2113/T. With this capstone project, student" +
                    "s would be able to better appreciate the relevance of the various components in the Computer " +
                    "Engineering curriculum to large scale computer engineering projects.", 8, "CG4002"),

            new Mod("Computer Networks", "This course provides an in-depth treatment of fundamental" +
                    " topics of network design based on the Internet protocol stack model. It is aimed at making" +
                    " students understand how networks work through understanding of the underlying principles " +
                    "of sound network design. This course covers topics including network requirements," +
                    " architecture, protocol stack models, Ethernet Token Ring, Wireless, and FDDI networks" +
                    ", bridges, switching and routing in IP and ATM networks, and internetworking. Apart " +
                    "from learning the concepts in networks, the students will gain expertise in analyzing" +
                    " and designing networking protocols through mini-projects.", 4,"EE4204"),

            new Mod("Communities and Engagement", "", 4, "GEN1XXX"),
            new Mod("Unrestricted Elective", "", 4, "UE")

            ));

    public static final List<Mod> Year4Sem2Modules = new ArrayList<>(Arrays.asList(
            new Mod("Unrestricted Elective", "", 4, "UE"),
            new Mod("Unrestricted Elective", "", 4, "UE"),
            new Mod("Unrestricted Elective", "", 4, "UE"),
            new Mod("Unrestricted Elective", "", 4, "UE"),
            new Mod("Unrestricted Elective", "", 4, "UE")

    ));

}
