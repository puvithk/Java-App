package service;

import model.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAllMessagesByChat(int chatId , int page );
}
