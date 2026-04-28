package ui;
import controller.UserController;
import exceptions.DataAlreadyExistsException;
import exceptions.InvalidDateOfBrith;
import exceptions.UserNotFound;
import model.Status;
import model.User;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class UserControllerUi {
    // Create a scanner
    private static final Scanner scanner =new Scanner(System.in);
    // Create a user controller
    private static final UserController userController =  new UserController();
    private static final Logger logger = Logger.getLogger(UserControllerUi.class.getName());

    // Function of the terminal ui
    public void userControllerSystem(){
        while(true){
            logger.info("""
        
        ========= USER MANAGEMENT =========
        1 : Get all users
        2 : Get user by ID
        3 : Create new user
        4 : Edit user by ID
        5 : Delete user by ID
        6 : Exit
        Enter your choice:
        """);
            int choice = scanner.nextInt();
            if(choice > 6 ){
                logger.info("Invalid choice");
            }
            if(choice==6){
                logger.info("Thank you");
                break;
            }
            switch (choice){
                case 1: handleGetAllUser();
                    break;
                case 2:
                    scanner.nextLine();
                    handleGetUserById();
                    break;

                case 3 :
                    scanner.nextLine();
                    handleCreateUser();
                    break;

                default:
                    logger.info("Enter a valid input : ");
                    break;
            }


        }
    }
    private void handleCreateUser() {

        logger.info("User id is auto generated");

        logger.info("Enter Name:");
        String name = scanner.nextLine();


        String email;
        while (true) {
            logger.info("Enter Email:");
            email = scanner.nextLine();

            if (!userController.isEmailExists(email)) {
                break;
            }

            logger.info("Email already exists!");
            logger.info("Try different email? (y/n):");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("n")) {
                logger.info("Exiting create user...");
                return;
            } else if (!choice.equalsIgnoreCase("y")) {
                logger.info("Invalid input. Exiting...");
                return;
            }
        }

        logger.info("Enter Organization:");
        String organization = scanner.nextLine();

        logger.info("Enter Status (AVAILABLE / OUT_OF_OFFICE / IN_OTHER_CALL /PRESENTING):");
        String statusInput = scanner.nextLine();
        Status status;
        try {
            status = Status.valueOf(statusInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            logger.info("Invalid status. Defaulting to AVAILABLE");
            status = Status.AVAILABLE;
        }

        logger.info("Enter Designation:");
        String designation = scanner.nextLine();

        logger.info("Enter Work Details:");
        String workDetails = scanner.nextLine();

        logger.info("Enter Profile Image URL:");
        String profileImage = scanner.nextLine();

        logger.info("Enter Password:");
        String password = scanner.nextLine();
        Date dob;

        while (true) {
            try {
                logger.info("Enter DOB (yyyy-mm-dd):");
                String dobInput = scanner.nextLine();

                dob = java.sql.Date.valueOf(dobInput);

                if (userController.isDobValid(dob)) {
                    break;
                } else {
                    logger.info("Invalid DOB! It cannot be future date.");
                }

            } catch (IllegalArgumentException e) {
                logger.info("Invalid format! Please use yyyy-mm-dd");
            }
        }


        logger.info("Is Active? (true/false):");
        Boolean isActive = scanner.nextBoolean();
        scanner.nextLine();

        // Create user (no ID constructor)
        User user = new User(
                name,
                email,
                organization,
                status,
                designation,
                workDetails,
                profileImage,
                password,
                dob,
                isActive
        );
        try{
            userController.createUser(user);
        }catch (DataAlreadyExistsException alreadyExistsException){
            logger.info("Email already exists : Exiting ");
            return;
        }catch (InvalidDateOfBrith invalidDateOfBrith){
            logger.info("Date of birth is in Valid: Exiting ");
            return;
        }


        logger.info("User created successfully!");
    }
    private void handleGetUserById() {
        while (true) {
            logger.info("Enter the user Id:");

            int userId = scanner.nextInt();
            try {
                User user = userController.getUserById(userId);
                logger.info("User Found:");
                logger.info(user.toString());
                return;
            } catch (UserNotFound e) {
                logger.info("User not found with id: " + userId);
                logger.info("Try again? (y/n):");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("n")) {
                    return;
                } else if (!choice.equalsIgnoreCase("y")) {
                    logger.info("Invalid input. Exiting...");
                    return;
                }
            }
        }
    }


    private void handleGetAllUser(){
        List<User> users = userController.getAllUser();
        for(User user : users){
            logger.info(user.toString());
        }
    }
}
