package service.impl;

import dao.ChatDAO;
import dao.impl.ChatDaoImpl;
import model.Chat;
import model.Message;
import service.ChatMessageService;

import java.util.List;

public class ChatServiceImpl implements ChatMessageService {

    //Get the Chat Dao
    private final ChatDAO chatDAO = new ChatDaoImpl();
    @Override

    public void sendMessage(Message message) {
        return;
    }
    @Override
    public List<Chat> getAllChatByUser(int userId){
        List<Chat> chats = chatDAO.findAllChatByUser(userId);
        if(chats.isEmpty()){
            return List.of();
        }
        return chats;
    }
}
