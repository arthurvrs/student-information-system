package sis.studentinfo;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest extends TestCase {

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
}