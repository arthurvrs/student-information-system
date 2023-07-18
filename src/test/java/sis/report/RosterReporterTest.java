package sis.report;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import sis.studentinfo.*;

import static org.junit.jupiter.api.Assertions.*;

public class RosterReporterTest extends TestCase {

    @Test
    public void testRosterReport() {
        CourseSession session =
                new CourseSession("ENGL", 101, new DateUtil().createDate(2003, 1, 6));

        session.enroll(new Student("Bryan"));
        session.enroll(new Student("Toretto"));
        String rosterReport = new RosterReporter(session).getReport();
        System.out.println(rosterReport);
        assertEquals(
                RosterReporter.ROSTER_REPORT_HEADER
                + "Bryan" + RosterReporter.NEWLINE
                + "Toretto" + RosterReporter.NEWLINE
                + RosterReporter.ROSTER_REPORT_FOOTER
                + "2" + RosterReporter.NEWLINE, rosterReport
        );
    }


}