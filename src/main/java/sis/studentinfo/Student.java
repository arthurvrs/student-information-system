package sis.studentinfo;

public class Student {

    private String name;
    private int credits;
    private String state;
    private boolean isFullTime;

    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "CO";

    public Student(String name) {

        this.name = name;
        this.credits = 0;
        this.isFullTime = false;
        this.state = "";
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

    public boolean isFullTime() {
        return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isInState() {
        return state.toUpperCase().equals(IN_STATE);
    }
}
