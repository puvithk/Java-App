package ui;

import controller.ChatController;
import model.Chat;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ChatControllerUi {
    private final int userId ;
    private final ChatController chatController = new ChatController();
    private final Logger logger =Logger.getLogger(ChatControllerUi.class.getName());
    private  final Scanner scanner = new Scanner(System.in);
    public ChatControllerUi(int userId) {
    this.userId = userId;
    }


    public void chatControllerSystem() {
        List<Chat> chats = chatController.getAllChatByUser(this.userId);
        if(chats.isEmpty()){
            logger.info("Chat is Empty");
            return;
        }

        chats.forEach(chat -> logger.info(chat.toString()));
        //
        logger.info("Select the chat : (number)");
        int choice = scanner.nextInt();
        logger.info(String.valueOf(choice));
    }
}
