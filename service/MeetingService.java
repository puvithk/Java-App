package service;

import model.Meeting;

import java.util.List;

public interface MeetingService {
    // Get all the meeting based on the user
    List<Meeting> getAllMeeting(int userId);
    // Get meeting based on ID
    Meeting getAllMeetingById(int userId , int meetingId);
}
