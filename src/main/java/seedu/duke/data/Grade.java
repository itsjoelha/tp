package seedu.duke.data;

public enum Grade {
    A_PLUS("A+", 5.0),
    A("A", 5.0),
    A_MINUS("A-", 4.5),
    B_PLUS("B+", 4.0),
    B("B", 3.5),
    B_MINUS("B-", 3.0),
    C_PLUS("C+", 2.5),
    C("C", 2.0),
    D_PLUS("D+", 1.5),
    D("D", 1.0),
    F("F", 0.0);

    private final String label;
    private final double gpa;

    Grade(String label, double gpa) {
        this.label = label;
        this.gpa = gpa;
    }

    public String getLabel() {
        return label == null ? "null" : label;
    }

    public double getGradePoint() {
        return gpa;
    }

    public static Grade fromString(String text) {
        for (Grade g : Grade.values()) {
            if (g.label.equalsIgnoreCase(text)) {
                return g;
            }
        }
        throw new IllegalArgumentException("Invalid grade: " + text);
    }

    public static boolean isHigherOrEqual(Grade grade1, Grade grade2) {
        return grade1.getGradePoint() >= grade2.getGradePoint();
    }
}
