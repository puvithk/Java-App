package model;

import java.time.LocalDateTime;

public class Message {
    private int messageId;
    private String text;
    private LocalDateTime timestamp;
    private Scope messageScope;
    private int composedBy;
    private int chatId;
    private int channelId;

    public Message(int messageId, String text, LocalDateTime timestamp, Scope messageScope, int composedBy, int chatId, int channelId) {
        this.messageId = messageId;
        this.text = text;
        this.timestamp = timestamp;
        this.messageScope = messageScope;
        this.composedBy = composedBy;
        this.chatId = chatId;
        this.channelId = channelId;
    }

    public Message(String text, Scope messageScope,
                   int composedBy, Integer chatId, Integer channelId) {

        this.text = text;
        this.timestamp = LocalDateTime.now();
        this.messageScope = messageScope;
        this.composedBy = composedBy;
        this.chatId = chatId;
        this.channelId = channelId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public int getComposedBy() {
        return composedBy;
    }

    public void setComposedBy(int composedBy) {
        this.composedBy = composedBy;
    }

    public Scope getMessageScope() {
        return messageScope;
    }

    public void setMessageScope(Scope messageScope) {
        this.messageScope = messageScope;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", text='" + text + '\'' +
                ", timestamp=" + timestamp +
                ", messageScope=" + messageScope +
                ", composedBy=" + composedBy +
                ", chatId=" + chatId +
                ", channelId=" + channelId +
                '}';
    }
}
