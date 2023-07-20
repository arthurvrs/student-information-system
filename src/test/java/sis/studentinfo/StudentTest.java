package sis.studentinfo;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class StudentTest extends TestCase {

    private Student student;
    public StudentTest() {
        student = new Student("Arthur Vinícius");
    }

    @Test
    public void testCreate() {
        final String firstStudentName = "Arthur Vinícius";
        Student student1 = new Student(firstStudentName);
        assertEquals(firstStudentName, student1.getName());

        final String secondStudentName = "José João";
        Student student2 = new Student(secondStudentName);
        assertEquals(secondStudentName, student2.getName());

        assertEquals(firstStudentName, student1.getName());
    }

    @Test
    public void testFullTime() {
        assertFalse(student.isFullTime());
    }

    @Test
    public void testCredits() {
        assertEquals(0, student.getCredits());
        student.addCredits(3);
        assertEquals(3, student.getCredits());
        student.addCredits(4);
        assertEquals(7, student.getCredits());
    }

    @Test
    public void testStudentStatus() {
        assertEquals(0, student.getCredits());
        enoughCredits();
        student.addCredits(3);
        assertEquals(3, student.getCredits());
        enoughCredits();
        student.addCredits(4);
        assertEquals(7, student.getCredits());
        assertFalse(student.isFullTime());
        student.addCredits(5);
        assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
        assertTrue(student.isFullTime());
    }

    private void enoughCredits() {
        assertFalse("Okay, now you are a full time studente. Enjoy this miserable life! :)", student.isFullTime());
    }

    public void testInState() {
        assertFalse(student.isInState());
        student.setState(Student.IN_STATE);
        assertTrue(student.isInState());
        student.setState("MD");
        assertFalse(student.isInState());
    }
}