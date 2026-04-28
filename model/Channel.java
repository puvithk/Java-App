package model;

import java.time.LocalDateTime;

public class Channel {
    private int channelId;
    private String channelName;
    private String channelDescription;
    private LocalDateTime createdAt;
    private int teamId;

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelDescription() {
        return channelDescription;
    }

    public void setChannelDescription(String channelDescription) {
        this.channelDescription = channelDescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getTeamId() {
        return teamId;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "channelId=" + channelId +
                ", channelName='" + channelName + '\'' +
                ", channelDescription='" + channelDescription + '\'' +
                ", createdAt=" + createdAt +
                ", teamId=" + teamId +
                '}';
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Channel(int teamId, LocalDateTime createdAt, String channelDescription, String channelName) {
        this.teamId = teamId;
        this.createdAt = createdAt;
        this.channelDescription = channelDescription;
        this.channelName = channelName;
    }
}
