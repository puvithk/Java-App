package dao;

import model.Chat;

import java.util.List;

public interface ChatDAO {
    List<Chat> findAllChatByUser(int userId);
}
