package sis.studentinfo;

import junit.framework.TestCase;

import java.util.logging.Logger;

public class StudentTest extends TestCase {

    private Student student;

    private static final double GRADE_TOLERANCE = 0.05;

    public StudentTest() {
        student = new Student("Arthur Vinícius");
    }

    public void testCreate() {
        final String firstStudentName = "Arthur Santos";
        Student student1 = new Student(firstStudentName);
        assertEquals(firstStudentName, student1.getName());
        assertEquals("Arthur", student1.getFirstName());
        assertEquals("Santos", student1.getLastName());
        assertEquals("", student1.getMiddleName());

        final String secondStudentName = "José";
        Student student2 = new Student(secondStudentName);
        assertEquals(secondStudentName, student2.getName());
        assertEquals("", student2.getFirstName());
        assertEquals("José", student2.getLastName());
        assertEquals("", student2.getMiddleName());

        final String thirdStudentName = "Maria Madalena Silva";
        Student thirdStudent = new Student(thirdStudentName);
        assertEquals(thirdStudentName, thirdStudent.getName());
        assertEquals("Maria", thirdStudent.getFirstName());
        assertEquals("Silva", thirdStudent.getLastName());
        assertEquals("Madalena", thirdStudent.getMiddleName());
    }

    public void testFullTime() {
        assertFalse(student.isFullTime());
    }

    public void testCredits() {
        assertEquals(0, student.getCredits());
        student.addCredits(3);
        assertEquals(3, student.getCredits());
        student.addCredits(4);
        assertEquals(7, student.getCredits());
    }

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
        assertFalse("Okay, now you are a full time student. Enjoy this miserable life! :)", student.isFullTime());
    }

    public void testInState() {
        assertFalse(student.isInState());
        student.setState(Student.IN_STATE);
        assertTrue(student.isInState());
        student.setState("MD");
        assertFalse(student.isInState());
    }

    public void testCalculateGpa() {

        assertGpa(student, 0.0);
        student.addGrade(Student.Grade.A);
        assertGpa(student, 4.0);
        student.addGrade(Student.Grade.B);
        assertGpa(student, 3.5);
        student.addGrade(Student.Grade.C);
        assertGpa(student, 3.0);
        student.addGrade(Student.Grade.D);
        assertGpa(student, 2.5);
        student.addGrade(Student.Grade.F);
        assertGpa(student, 2.0);
    }

    private void assertGpa(Student student, double expectedGpa) {
        assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
    }

    public void testCalculateHonorsStudentGpa() {
        assertGpa(createHonorsStudent(), 0.0);
        assertGpa(createHonorsStudent(Student.Grade.A), 5.0);
        assertGpa(createHonorsStudent(Student.Grade.B), 4.0);
        assertGpa(createHonorsStudent(Student.Grade.C), 3.0);
        assertGpa(createHonorsStudent(Student.Grade.D), 2.0);
        assertGpa(createHonorsStudent(Student.Grade.F), 0.0);
    }

    private Student createHonorsStudent(Student.Grade grade) {
        student = createHonorsStudent();
        student.addGrade(grade);
        return student;
    }

    private Student createHonorsStudent() {
        student = new Student("Luisa Mel");
        student.setGradingStrategy(new HonorsGradingStrategy());
        return student;
    }

    public void testCharges() {
        Student student = new Student("a");
        student.addCharge(500);
        student.addCharge(200);
        student.addCharge(399);
        assertEquals(1099, student.totalCharges());
    }

    public void testBadlyFormattedName() {
        TestHandler handler = new TestHandler();
        Student.logger.addHandler(handler);
        String studentName = "a b c d";
        try {
            new Student("a b c d");
            fail("expected exception from 4-part name");
        } catch (StudentNameFormatException e) {
            String message = String.format(Student.TOO_MANY_NAME_PARTS_MSG, studentName, 3);
            assertEquals(message, e.getMessage());
            assertEquals(message, handler.getMessage());
        }
    }

    public void testLoggingHierarchy() {
        Logger logger = Logger.getLogger("sis.studentinfo.Student");
        assertTrue(logger == Logger.getLogger("sis.studentinfo.Student"));

        Logger parent = Logger.getLogger("sis.studentinfo");
        assertEquals(parent, logger.getParent());
        assertEquals(Logger.getLogger("sis"), parent.getParent());
    }

}