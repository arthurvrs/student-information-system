package sis;

import sis.studentinfo.*;
import sis.report.*;

import junit.framework.TestSuite;

public class AllTests {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(StudentTest.class);
        suite.addTestSuite(CourseSessionTest.class);
        suite.addTestSuite(DateUtilTest.class);
        suite.addTestSuite(RosterReporterTest.class);
        suite.addTestSuite(CourseReportTest.class);

        return suite;
    }
}
