package controller;

import model.Chat;
import service.ChatMessageService;
import service.impl.ChatServiceImplChat;

import java.util.List;

public class ChatController {
    private final ChatMessageService chatMessageService =  new ChatServiceImplChat();
    public List<Chat> getAllChatByUser(int userId){
        return chatMessageService.getAllChatByUser(userId);

    }
}
