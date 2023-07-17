package studentinfo;

import java.util.*;

/**
 * Representa uma sessão em um único semestre
 * de um curso universitário.
 * @author Arthur Santos
 */
public class CourseSession {

    private String department;
    private int number;
    private ArrayList<Student> students =
            new ArrayList<Student>();
    private Date startDate;

    /**
     * Construtor da classe
     * @param department o departamento do curso.
     * @param number o número da sessão.
     * @param startDate a data de início da sessão.
     */
    public CourseSession(String department, int number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void enroll(Student student) {
        this.students.add(student);
    }

    public int getNumberOfStudents() {
        return this.students.size();
    }

    public Student get(int index) {
        return students.get(index);
    }

    public Date getStartDate() {
        return startDate;
    }

    /**
     * @return Retorna o último dia da sessão.
     */
    public Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        final int sessionLength = 16;
        final int daysInWeek = 7;
        final int daysFromFridayToMonday = 3;
        int numberOfDays = sessionLength * daysInWeek - daysFromFridayToMonday;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }
}
