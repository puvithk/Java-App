package model;

import java.time.LocalDateTime;

public class Chat {
    private int chatId;
    private String chatName;
    private int user1Id;
    private int user2Id;
    private LocalDateTime createdAt;

    public Chat(int chatId, String chatName, int user1Id, int user2Id, LocalDateTime createdAt) {
        this.chatId = chatId;
        this.chatName = chatName;
        this.user1Id = user1Id;
        this.user2Id = user2Id;
        this.createdAt = createdAt;
    }

    public Chat(String chatName, int user1Id, int user2Id, LocalDateTime createdAt) {
        this.chatName = chatName;
        this.user1Id = user1Id;
        this.user2Id = user2Id;
        this.createdAt = createdAt;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public int getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(int user1Id) {
        this.user1Id = user1Id;
    }

    public int getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(int user2Id) {
        this.user2Id = user2Id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return  chatId +". Chat{" +
                "chatId=" + chatId +
                ", chatName='" + chatName + '\'' +
                ", user1Id=" + user1Id +
                ", user2Id=" + user2Id +
                ", createdAt=" + createdAt +
                "}\n";
    }
}
