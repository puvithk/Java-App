package dao;

import model.Meeting;

import java.util.List;

public interface MeetingDAO {
    // Get all meeting based on the user
    List<Meeting> findAllMeeting(int userId);
    // Get the meeting based on the meeting id
    Meeting findMeetingById( int meetingId);
}
