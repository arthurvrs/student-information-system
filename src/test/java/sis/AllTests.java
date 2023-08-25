package sis;

import sis.studentinfo.*;
import sis.report.*;

import junit.framework.TestSuite;
import sis.summer.SummerCourseSessionTest;

public class AllTests {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();

        //Student Tests
        suite.addTestSuite(StudentTest.class);
        suite.addTestSuite(PerformanceTest.class);
        suite.addTestSuite(ScorerTest.class);
        suite.addTestSuite(StudentDirectoryTest.class);
        suite.addTestSuite(ReportCardTest.class);

        //Course Tests
        //suite.addTestSuite(SessionTest.class);
        suite.addTestSuite(CourseTest.class);
        suite.addTestSuite(CourseSessionTest.class);
        suite.addTestSuite(CourseReportTest.class);
        suite.addTestSuite(RosterReporterTest.class);
        suite.addTestSuite(BasicGradingStrategyTest.class);
        suite.addTestSuite(HonorsGradingStrategyTest.class);
        suite.addTestSuite(SummerCourseSessionTest.class);


        suite.addTestSuite(DateUtilTest.class);

        return suite;
    }
}
