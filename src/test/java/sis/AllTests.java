package sis;

import sis.studentinfo.*;
import sis.report.*;

import junit.framework.TestSuite;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sis.report.RosterReporter;

public class AllTests {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(StudentTest.class);
        suite.addTestSuite(CourseSessionTest.class);
        suite.addTestSuite(DateUtilTest.class);
        suite.addTestSuite(RosterReporterTest.class);

        return suite;
    }
}
