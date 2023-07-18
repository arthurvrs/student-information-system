package sis.report;

import sis.studentinfo.*;

import java.util.ArrayList;

public class RosterReporter {

    static final String NEWLINE =
            System.getProperty("line.separator");
    static final String ROSTER_REPORT_HEADER =
            "Student" + NEWLINE + "-" + NEWLINE;
    static final String ROSTER_REPORT_FOOTER =
            NEWLINE + "# students = ";

    private CourseSession session;

    public RosterReporter(CourseSession session) {
        this.session = session;
    }

    public String getReport() {
        StringBuilder buffer = new StringBuilder();

        buffer.append(ROSTER_REPORT_HEADER);

        ArrayList<Student> students = session.getAllStudents();

        for(Student student: students) {
            buffer.append(student.getName());
            buffer.append(NEWLINE);
        }

        buffer.append(ROSTER_REPORT_FOOTER + students.size() + NEWLINE);

        return buffer.toString();
    }

    private void writeHeader(StringBuilder buffer) {
        buffer.append(ROSTER_REPORT_HEADER);
    }

    private void writeBody(StringBuilder buffer) {
        for(Student student: session.getAllStudents()) {
            buffer.append(student.getName());
            buffer.append(NEWLINE);
        }
    }

    private void writeFooter(StringBuilder buffer) {
        buffer.append(ROSTER_REPORT_FOOTER);
    }

}