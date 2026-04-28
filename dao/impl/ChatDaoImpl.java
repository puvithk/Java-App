package dao.impl;

import dao.ChatDAO;
import model.Chat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChatDaoImpl implements ChatDAO {
    List<Chat> chats = new ArrayList<>(List.of(
            new Chat(1,"Project Sync", 1, 2, LocalDateTime.of(2026, 4, 20, 10, 30)),
            new Chat(2,"Lunch Plans", 3, 5, LocalDateTime.of(2026, 4, 21, 12, 0)),
            new Chat(3,"Bug Report #402", 4, 3, LocalDateTime.of(2026, 4, 22, 9, 15)),
            new Chat(4,"Weekend Trip", 4, 1, LocalDateTime.of(2026, 4, 23, 18, 45)),
            new Chat(5,"Interview Prep", 4, 2, LocalDateTime.of(2026, 4, 24, 14, 20))
    ));


    @Override
    public List<Chat> findAllChatByUser(int userId) {
        return chats.stream().filter(
                user -> user.getUser1Id() == userId || user.getUser2Id() ==  userId
        ).toList();
    }
}
