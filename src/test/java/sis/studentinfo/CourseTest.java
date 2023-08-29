package sis.studentinfo;

import junit.framework.TestCase;
import java.util.*;

public class CourseTest extends TestCase {

    public void testCreate() {
        Course course = new Course("CMSC", "120");
        assertEquals("CMSC", course.getDepartment());
        assertEquals("120", course.getNumber());
    }

    public void testEquality() {
        Course courseA1 = new Course("NURS", "201");
        Course courseA2 = new Course("NURS", "201");
        assertEquals(courseA1, courseA2);
        Course courseB = new Course("ARTH", "330");
        assertFalse(courseA1.equals(courseB));
        assertEquals(courseA1, courseA1);
        Course courseA3 = new Course("NURS", "201");
        assertEquals(courseA2, courseA3);
        assertEquals(courseA1, courseA3);
        assertEquals(courseA1, courseA2);
        assertFalse(courseA1.equals(null));
        assertFalse(courseA1.equals("CMSC-120"));
    }

    public void testHashCode() {
        Course courseA1 = new Course("NURS", "201");
        Course courseA2 = new Course("NURS", "201");
        assertEquals(courseA1.hashCode(), courseA2.hashCode());
        assertEquals(courseA1.hashCode(), courseA1.hashCode());
    }

    public void testHashCodePerformance() {
        final int count = 10000;
        long start = System.currentTimeMillis();
        Map<Course, String> map = new HashMap<>();
        int i = 0;
        while(i < count) {
            Course course = new Course("C" + i, "" + i);
            map.put(course, "");
            i++;
        }
        long stop = System.currentTimeMillis();
        long elapsed = stop - start;
        final long arbitraryThreshold = 200;
        assertTrue("elapsed time = " + elapsed, elapsed < arbitraryThreshold);
    }

    public void testToString() {
        Course course = new Course("ENGL", "301");
        assertEquals("ENGL 301", course.toString());
    }
}