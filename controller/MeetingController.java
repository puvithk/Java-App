package controller;

import model.Meeting;
import model.User;
import service.MeetingService;
import service.impl.MeetingServiceImpl;

import java.util.List;

public class MeetingController {
    // Get all meeting of the user
    // Get the meeting based on id  if user is allowed
    // Create a meeting
    // Delete a meeting
    // Create a object of Meeting service
    private static final MeetingService meetingService = new MeetingServiceImpl();
    public List<Meeting> getAllMeetings(int userId){
        return meetingService.getAllMeeting(userId);
    }
    public Meeting getMeetingById(int userId , int meetingId){
        return meetingService.getAllMeetingById(userId  , meetingId);
    }

}
