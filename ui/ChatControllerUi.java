package ui;

import controller.ChatController;
import controller.MessageController;
import dao.UserDAO;
import dao.impl.UserDaoImpl;
import model.Chat;
import model.Message;
import model.User;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ChatControllerUi {
    private final int userId ;
    private final ChatController chatController = new ChatController();
    private final MessageController messageController =  new MessageController();
    private final Logger logger =Logger.getLogger(ChatControllerUi.class.getName());
    private  final Scanner scanner = new Scanner(System.in);
    private final UserDAO userDAO = new UserDaoImpl();

    public ChatControllerUi(int userId) {
    this.userId = userId;
    }


    public void chatControllerSystem() {
        List<Chat> chats = chatController.getAllChatByUser(this.userId);
        if(chats.isEmpty()){
            logger.info("Chat is Empty");
            return;
        }
        for(int i = 0  ; i<chats.size() ; i++){
            Chat currentChat = chats.get(i);

            User user1 = userDAO.findUserById(currentChat.getUser1Id());
            User user2 = userDAO.findUserById(currentChat.getUser2Id());
            System.out.println(i+". " + currentChat.getChatName() + "( " + user1.getName() + " , " + user2.getName() + " )" );
        }
        //
        logger.info("Select the chat : (-1 to exit )");
        int choice = scanner.nextInt();
        if(choice==-1){
            logger.info("Exiting....");
            return;
        }
        if(choice> chats.size() || choice < 0 ){
            logger.info("Invalid Choice ...");
            return;
        }
        handleChatMessaging(chats , choice);
    }

    private void handleChatMessaging(List<Chat> chats, int choice) {

        Chat currentChat = chats.get(choice);
        int page = 0;

        while (true) {

            List<Message> newMessages =
                    messageController.getMessageByChatId(currentChat.getChatId(), page);

            if (newMessages.isEmpty()) {
                System.out.println("No more messages.");
                break;
            }

            System.out.println("==========" + currentChat.getChatName() + "==========");

            for (Message message : newMessages) {
                String composedBy = (this.userId == message.getComposedBy()) ? "YOU" : userDAO.findUserById(message.getComposedBy()).getName();

                System.out.println(composedBy + " : " + message.getText());
            }
            scanner.nextLine();
            logger.info("Load more? (y/n): ");
            String nextOp = scanner.nextLine();

            if (nextOp.equalsIgnoreCase("y")) {
                page++;
            } else {
                break;
            }
        }
    }
}
