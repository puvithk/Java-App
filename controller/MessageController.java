package controller;

import model.Message;
import service.MessageService;
import service.impl.MessageServiceImpl;

import java.util.List;

public class MessageController {
    // Create a object of messageService
    private final MessageService messageService = new MessageServiceImpl();
    // Get messaged based on the chatId
    public List<Message> getMessageByChatId(int chatId , int page){
        return messageService.getAllMessagesByChat(chatId , page);
    }
}
