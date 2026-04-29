package controller;

import model.Chat;
import service.ChatMessageService;
import service.impl.ChatServiceImpl;

import java.util.List;

public class ChatController {
    private final ChatMessageService chatMessageService =  new ChatServiceImpl();
    public List<Chat> getAllChatByUser(int userId){
        return chatMessageService.getAllChatByUser(userId);

    }
}
