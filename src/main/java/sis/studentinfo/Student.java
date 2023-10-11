package sis.studentinfo;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;

public class Student implements Comparable<Student>, Serializable {

    private String id;
    private String name;
    private String firstName = "";
    private String middleName = "";
    private String lastName;
    private int credits;
    private String state = "";
    private final ArrayList<Grade> grades = new ArrayList<>();
    public enum Grade {
        A(4),
        B(3),
        C(2),
        D(1),
        F(0);

        private final int points;

        Grade(int points) {
            this.points = points;
        }

        int getPoints() {
            return points;
        }

    }
    private GradingStrategy gradingStrategy = new BasicGradingStrategy();
    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "CO";
    private final List<Integer> charges = new ArrayList<>();

    final static Logger logger = Logger.getLogger(Student.class.getName());
    static final String TOO_MANY_NAME_PARTS_MSG =
            "Student name '%s' contains more than %d parts";
    public enum Flag {
        ON_CAMPUS(1),
        TAX_EXEMPT(2),
        MINOR(4),
        TROUBLEMAKER(8);

        private int mask;

        Flag(int mask) {
            this.mask = mask;
        }
    }
    private int settings = 0x0;

    public Student(String name) {
        this.name = name;
        this.credits = 0;
        List<String> nameParts = split(name);
        if(nameParts.size() > 3) {
            String message = String.format(TOO_MANY_NAME_PARTS_MSG, name, 3);
            Student.logger.info(message);
            throw new StudentNameFormatException(message);
        }
        setName(nameParts);
    }

    private void setName(List<String> nameParts) {
        this.lastName = removeLast(nameParts);
        String name = removeLast(nameParts);
        if (nameParts.isEmpty())
            this.firstName = name;
        else {
            this.middleName = name;
            this.firstName = removeLast(nameParts);
        }
    }
    private String removeLast(List<String> list) {
        if (list.isEmpty())
            return "";
        return list.remove(list.size() - 1);
    }

    private List<String> split(String fullName) {
        List<String> results = new ArrayList<>();
        for(String name : fullName.split(" ")) {
            results.add(name);
        }
        return results;
    }

    @Override
    public int compareTo(Student student) {
        return this.getName().compareTo(student.getName());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return this.name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addCredits(int credits) {
        this.credits += credits;
    }

    public int getCredits() {
        return this.credits;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public double getGpa() {
        Student.logger.fine("begin getGpa " + System.currentTimeMillis());
        if(grades.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for(Grade grade : grades) {
            total += gradingStrategy.getGradePointsFor(grade);
        }
        Student.logger.fine("end getGpa " + System.currentTimeMillis());
        return total / grades.size();
    }

    public boolean isFullTime() {
        return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isInState() {
        return state.equalsIgnoreCase(IN_STATE);
    }

    public void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }

    public void addCharge(int charge) {
        charges.add(charge);
    }

    public int totalCharges() {
        int total = 0;
        for(int charge : charges)
            total += charge;
        return total;
    }

    public void set(Flag... flags) {
        for(Flag flag : flags)
            settings |= flag.mask;
    }

    public void unset(Flag... flags) {
        for(Flag flag : flags)
            settings &= ~flag.mask;
    }

    public boolean isOn(Flag flag) {
        return (settings & flag.mask) == flag.mask;
    }

    public boolean isOff(Flag flag) {
        return !isOn(flag);
    }

    public static Student findByLastName(String lastName) { return new Student(lastName); }
}
