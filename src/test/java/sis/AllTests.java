package sis;

import sis.clock.ClockTest;
import sis.db.DataFileTest;
import sis.db.KeyFileTest;
import sis.search.SearchSchedulerTest;
import sis.search.SearchTest;
import sis.search.Server;
import sis.search.ServerTest;
import sis.security.SecureProxyTest;
import sis.studentinfo.*;
import sis.report.*;

import junit.framework.TestSuite;
import sis.summer.SummerCourseSessionTest;
import sis.ui.StudentUITest;
import sis.util.*;

public class AllTests {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();

        //Clock Tests
        suite.addTestSuite(ClockTest.class);

        //DataBase Tests
        suite.addTestSuite(DataFileTest.class);
        suite.addTestSuite(KeyFileTest.class);

        //Report Tests
        suite.addTestSuite(CourseReportTest.class);
        suite.addTestSuite(ReportCardTest.class);
        suite.addTestSuite(RosterReporterTest.class);

        //Search Tests
        suite.addTestSuite(SearchSchedulerTest.class);
        suite.addTestSuite(SearchTest.class);
        suite.addTestSuite(ServerTest.class);

        //Security Tests
        suite.addTestSuite(SecureProxyTest.class);

        //Student Info Tests
        suite.addTestSuite(AccountFactoryTest.class);
        suite.addTestSuite(AccountTest.class);
        suite.addTestSuite(BasicGradingStrategyTest.class);
        suite.addTestSuite(CourseCatalogTest.class);
        suite.addTestSuite(CourseSessionTest.class);
        suite.addTestSuite(CourseTest.class);
        suite.addTestSuite(DateUtilTest.class);
        suite.addTestSuite(HonorsGradingStrategyTest.class);
        suite.addTestSuite(MultithreadedAccountTest.class);
        suite.addTestSuite(PerformanceTest.class);
        suite.addTestSuite(ScorerTest.class);
        //suite.addTestSuite(SessionTest.class);
        suite.addTestSuite(StudentDirectoryTest.class);
        suite.addTestSuite(StudentTest.class);

        //Summer Tests
        suite.addTestSuite(SummerCourseSessionTest.class);

        //UI Tests
        suite.addTestSuite(StudentUITest.class);

        //Util Tests
        suite.addTestSuite(IOUtilTest.class);
        suite.addTestSuite(LineWriterTest.class);
        suite.addTestSuite(MathTest.class);
        suite.addTestSuite(ParityCheckerTest.class);
        suite.addTestSuite(PasswordGeneratorTest.class);
        suite.addTestSuite(StringUtilTest.class);

        return suite;
    }
}
