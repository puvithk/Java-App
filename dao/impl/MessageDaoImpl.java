package dao.impl;


import dao.MessageDAO;
import model.Message;
import model.Scope;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MessageDaoImpl implements MessageDAO {
    List<Message> messages = new ArrayList<>(List.of(

            new Message(1, "Hey, did you check the bug?", LocalDateTime.of(2026, 4, 22, 9, 20), Scope.CHAT, 4, 3, 0),
            new Message(2, "Yes, I'm working on it", LocalDateTime.of(2026, 4, 22, 9, 22), Scope.CHAT, 3, 3, 0),

            new Message(5, "Weekend plan finalized?", LocalDateTime.of(2026, 4, 23, 18, 50), Scope.CHAT, 4, 4, 0),
            new Message(6, "Not yet, thinking Goa 😄", LocalDateTime.of(2026, 4, 23, 18, 52), Scope.CHAT, 1, 4, 0),

            new Message(9, "Did you prepare for interview?", LocalDateTime.of(2026, 4, 24, 14, 25), Scope.CHAT, 4, 5, 0),
            new Message(10, "Yes, mostly DSA and system design", LocalDateTime.of(2026, 4, 24, 14, 27), Scope.CHAT, 2, 5, 0)


    ));

    @Override
    public List<Message> findAllMessageFromChat(int chatId , int page) {
        int pageSize = 5 ;
        return messages.stream()
                .filter(message -> message.getMessageScope() == Scope.CHAT
                        && message.getChatId()== chatId)
                .sorted(Comparator.comparing(Message::getTimestamp)) // Sorts based on the time
                .skip((long) page *  pageSize ) // Skips the pages
                .limit(5) // Limits the size
                .toList();
    }
}
