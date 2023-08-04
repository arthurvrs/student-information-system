package sis.studentinfo;

import java.util.ArrayList;

public class Student implements Comparable<Student>{

    private String name;
    private int credits;
    private String state;
    private ArrayList<Grade> grades;
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
    private GradingStrategy gradingStrategy;

    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "CO";
    public Student(String name) {
        this.name = name;
        this.credits = 0;
        this.state = "";
        this.grades = new ArrayList<>();
        gradingStrategy = new BasicGradingStrategy();
    }

    @Override
    public int compareTo(Student student) {
        int compare = this.getName().compareTo(student.getName());
        return compare;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
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
        if(grades.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for(Grade grade : grades) {
            total += gradingStrategy.getGradePointsFor(grade);;
        }
        return total / grades.size();
    }


    public boolean isFullTime() {
        return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isInState() {
        return state.toUpperCase().equals(IN_STATE);
    }

    public void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }
}
