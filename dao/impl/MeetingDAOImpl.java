package dao.impl;

import dao.MeetingDAO;
import model.Meeting;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MeetingDAOImpl implements MeetingDAO {
    // Some fake data

    List<Meeting> meetings = new ArrayList<>( List.of(

            new Meeting(
                    1,
                    "Sprint Planning",
                    LocalDateTime.of(2026, 4, 29, 10, 0),
                    LocalDateTime.of(2026, 4, 29, 11, 0),
                    "Plan tasks for upcoming sprint",
                    4
            ),

            new Meeting(
                    2,
                    "Daily Standup",
                    LocalDateTime.of(2026, 4, 29, 9, 30),
                    LocalDateTime.of(2026, 4, 29, 9, 45),
                    "Discuss daily progress and blockers",
                    1
            ),

            new Meeting(
                    3,
                    "Client Meeting",
                    LocalDateTime.of(2026, 4, 30, 15, 0),
                    LocalDateTime.of(2026, 4, 30, 16, 0),
                    "Project requirement discussion",
                    2
            ),

            new Meeting(
                    4,
                    "Tech Review",
                    LocalDateTime.of(2026, 5, 1, 14, 0),
                    LocalDateTime.of(2026, 5, 1, 15, 30),
                    "Review architecture and code quality",
                    4
            ),

            new Meeting(
                    5,
                    "Retrospective",
                    LocalDateTime.of(2026, 5, 2, 11, 0),
                    LocalDateTime.of(2026, 5, 2, 12, 0),
                    "Discuss improvements from last sprint",
                    4
            ))
    );



    @Override
    public List<Meeting> findAllMeeting(int userId) {

        return meetings.stream().filter(
                user -> user.getOrganizer() == userId
        ).toList();
    }

    @Override
    public Meeting findMeetingById( int meetingId) {
        return meetings.stream().filter(
                user -> user.getMeetingId() == meetingId
        ).findFirst().orElse(null);
    }


}
