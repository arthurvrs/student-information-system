package sis.report;

import junit.framework.TestCase;
import sis.studentinfo.*;
import java.io.*;

public class RosterReporterTest extends TestCase {

    private Session session;

    protected void setUp() {
        session = CourseSession.create(new Course("ENGL", "101"), DateUtil.createDate(2003, 1, 6));
        session.enroll(new Student("Bryan"));
        session.enroll(new Student("Toretto"));
    }

    public void testRosterReport() throws IOException {

        Writer writer = new StringWriter();
        new RosterReporter(session).writeReport(writer);
        assertReportContents(writer.toString());
    }

    private void assertReportContents(String rosterReport) {
        assertEquals(
                String.format(
                        RosterReporter.ROSTER_REPORT_HEADER
                                + "Bryan%n"
                                + "Toretto%n"
                                + RosterReporter.ROSTER_REPORT_FOOTER, session.getNumberOfStudents()
                ), rosterReport
        );
    }

    public void testFiledReport() throws IOException {
        final String filename = "testFiledReport.txt";
        try {
            delete(filename);

            new RosterReporter(session).writeReport(filename);

            StringBuffer buffer = new StringBuffer();
            String line;

            BufferedReader reader = new BufferedReader(new FileReader(filename));

            while((line = reader.readLine()) != null) {
                buffer.append(String.format(line + "%n"));
            }
            reader.close();

            assertReportContents(buffer.toString());
        } finally {
            delete(filename);
        }
    }

    private void delete(String filename) {
        File file = new File(filename);
        if(file.exists())
            assertTrue("unable to delete " + filename, file.delete());
    }


}