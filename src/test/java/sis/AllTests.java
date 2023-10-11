package sis;

import sis.db.DataFileTest;
import sis.db.KeyFileTest;
import sis.studentinfo.*;
import sis.report.*;

import junit.framework.TestSuite;
import sis.summer.SummerCourseSessionTest;
import sis.ui.StudentUITest;
import sis.util.IOUtilTest;

public class AllTests {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();

        //Student Tests
        suite.addTestSuite(StudentTest.class);
        suite.addTestSuite(PerformanceTest.class);
        suite.addTestSuite(ScorerTest.class);
        suite.addTestSuite(StudentDirectoryTest.class);
        suite.addTestSuite(ReportCardTest.class);
        suite.addTestSuite(StudentUITest.class);

        //Course Tests
        //suite.addTestSuite(SessionTest.class);
        suite.addTestSuite(CourseTest.class);
        suite.addTestSuite(CourseSessionTest.class);
        suite.addTestSuite(CourseReportTest.class);
        suite.addTestSuite(RosterReporterTest.class);
        suite.addTestSuite(BasicGradingStrategyTest.class);
        suite.addTestSuite(HonorsGradingStrategyTest.class);
        suite.addTestSuite(SummerCourseSessionTest.class);
        suite.addTestSuite(CourseCatalogTest.class);

        //DataBase Tests
        suite.addTestSuite(DataFileTest.class);
        suite.addTestSuite(KeyFileTest.class);
        suite.addTestSuite(IOUtilTest.class);

        suite.addTestSuite(DateUtilTest.class);

        return suite;
    }
}
