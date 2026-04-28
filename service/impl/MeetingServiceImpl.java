package service.impl;

import dao.MeetingDAO;
import dao.impl.MeetingDAOImpl;
import exceptions.AccessDeniedException;
import exceptions.MeetingNotFound;
import model.Meeting;
import service.MeetingService;

import java.util.List;

public class MeetingServiceImpl implements MeetingService {
    // Object of DAO object
    private static final MeetingDAO meetingDao = new MeetingDAOImpl();
    @Override
    public List<Meeting> getAllMeeting(int userId) {
        List<Meeting> meetings =  meetingDao.findAllMeeting(userId);
        if (meetings.isEmpty()) return List.of();
        else return meetings;
    }

    @Override
    public Meeting getAllMeetingById(int userId, int meetingId) {
        Meeting meeting = meetingDao.findMeetingById( meetingId);
        if(meeting == null){
            throw new MeetingNotFound("Meeting not found");
        }
        if(meeting.getOrganizer() !=  userId){
            throw new AccessDeniedException("Meeting Access Denied");
        }
        return meeting;
    }
}
