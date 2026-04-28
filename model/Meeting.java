package model;

import java.time.LocalDateTime;

public class Meeting {
    private int meetingId;
    private String meetingName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String meetingAgenda;
    private int organizer;

    public Meeting(int meetingId, String meetingName, LocalDateTime startTime, LocalDateTime endTime, String meetingAgenda, int organizer) {
        this.meetingId = meetingId;
        this.meetingName = meetingName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.meetingAgenda = meetingAgenda;
        this.organizer = organizer;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getMeetingAgenda() {
        return meetingAgenda;
    }

    public void setMeetingAgenda(String meetingAgenda) {
        this.meetingAgenda = meetingAgenda;
    }

    public int getOrganizer() {
        return organizer;
    }
    public void setOrganizer(int organizer) {
        this.organizer = organizer;
    }
    @Override
    public String toString() {
        return "Meeting{" + '\n'+
                "meetingId=" + meetingId+ '\n' +
                "meetingName='" + meetingName + '\n' +
                "startTime=" + startTime+ '\n' +
                "endTime=" + endTime+ '\n' +
                "meetingAgenda='" + meetingAgenda+ '\n' +
                "organizer=" + organizer + '\n'+
                '}';
    }


}
