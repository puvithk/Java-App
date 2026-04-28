package dao;

import model.Message;

import java.util.List;

public interface MessageDAO {
    List<Message> getMessageFromChat(int chatId);
}
