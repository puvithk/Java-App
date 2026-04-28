package service;

import model.Chat;
import model.Message;

import java.util.List;

public interface ChatMessageService {
    void sendMessage(Message message);
    List<Chat> getAllChatByUser(int userId);
}
