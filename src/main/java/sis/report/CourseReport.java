package sis.report;

import java.util.*;
import sis.studentinfo.*;
import static sis.report.RosterReporter.NEWLINE;

public class CourseReport implements Comparable{

    private ArrayList<CourseSession> sessions = new ArrayList<>();

    public void add(CourseSession session) {
        this.sessions.add(session);
    }

    public String text() {
        Collections.sort(sessions);
        StringBuilder builder = new StringBuilder();
        for(CourseSession session : sessions) {
            builder.append(session.getDepartment() + " " +
                    session.getNumber() + NEWLINE);
        }
        return builder.toString();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
