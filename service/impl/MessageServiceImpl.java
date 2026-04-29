package service.impl;

import dao.MessageDAO;
import dao.impl.MessageDaoImpl;
import model.Meeting;
import model.Message;
import service.MeetingService;
import service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    private final MessageDAO messageDAO = new MessageDaoImpl();
    @Override
    public List<Message> getAllMessagesByChat(int chatId , int page ) {
        return messageDAO.findAllMessageFromChat(chatId , page);
    }
}
