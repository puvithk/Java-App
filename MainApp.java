import ui.ChatControllerUi;
import ui.LoginUi;
import ui.MeetingControllerUi;
import ui.UserControllerUi;
import java.util.Scanner;
import java.util.logging.Logger;



// Main file Which correspond to the starting point
public class MainApp {


    private static final Logger logger = Logger.getLogger(MainApp.class.getName());
    public static final Scanner scanner =new Scanner(System.in);


    private static final LoginUi loginui = new LoginUi();

    public static void main(String[] args) {



        int userId = loginui.loginUi();

        if (userId == -1) {
            logger.info("Exiting application...");
            return;
        }

        MeetingControllerUi meetingControllerUi = new MeetingControllerUi(userId);
        UserControllerUi userControllerUi = new UserControllerUi();
        ChatControllerUi chatControllerUi = new ChatControllerUi(userId);


        while (true) {
            logger.info("""
        ===== MAIN CONSOLE =====
        1 : User Management
        2 : Meeting Management
        3 : Chats Management
        4 : Exit
        ========================
        Enter your choice:
        """);

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    userControllerUi.userControllerSystem();
                    break;

                case 2:
                    meetingControllerUi.meetingControllerSystem();
                    break;
                case 3 :
                    chatControllerUi.chatControllerSystem();
                    break;
                case 4:
                    logger.info("Exiting application...");
                    return;

                default:
                    logger.info("Invalid choice!");
            }
        }
    }
}
