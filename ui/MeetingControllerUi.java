package ui;

import controller.MeetingController;
import exceptions.AccessDeniedException;
import exceptions.MeetingNotFound;
import model.Meeting;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class MeetingControllerUi {
    private final int userId ;
    public MeetingControllerUi(int userId){
        
        this.userId = userId;
    }
    // Scanner object 
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(MeetingControllerUi.class.getName());
    // Object of the Meeting controller
    private static  final MeetingController meetingController = new MeetingController();
    // Function of the terminal ui
    public void meetingControllerSystem(){
        while(true){

            logger.info("""
        
        ========= MEETING MANAGEMENT =========
        1 : Get all Meetings assigned
        2 : Get meeting by ID
        3 : Create new meeting
        4 : Edit meeting by ID
        5 : Delete meeting by ID
        6 : Exit
        =======================================
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
                case 1: handleGetAllMeeting();
                    break;
                case 2:
                    scanner.nextLine();
                    handleGetMeetingById();
                    break;

                case 3 :
                    scanner.nextLine();
                    handleCreateMeeting();
                    break;

                default:
                    logger.info("Enter a valid input : ");
                    break;
            }


        }
    }

    private void handleCreateMeeting() {
    }

    private void handleGetMeetingById() {
        while(true){
            logger.info("Enter the meeting Id :");
            int meetingId = scanner.nextInt();
            scanner.nextLine();
            try {
                Meeting meeting = meetingController.getMeetingById(this.userId , meetingId);
                logger.info(meeting.toString());
                return ;
            }catch (MeetingNotFound meetingNotFound){
                logger.info("The Meeting with meeting is " +  meetingId +  " is Not found");
                logger.info("Try again (y/n) :");
                String choice = scanner.nextLine();
                if(choice.equalsIgnoreCase("n")){
                    logger.info("Stoping get by Id ...");
                    return;
                }else if (!choice.equalsIgnoreCase("y")){
                    logger.info("Invalid choice , Exiting ....");
                    return;
                }
            }catch (AccessDeniedException accessDeniedException){
                logger.info("Access denied for the id " +  meetingId );
                logger.info("Try again (y/n) :");
                String choice = scanner.nextLine();
                if(choice.equalsIgnoreCase("n")){
                    logger.info("Stoping get by Id ...");
                    return;
                }else if (!choice.equalsIgnoreCase("y")){
                    logger.info("Invalid choice , Exiting ....");
                    return;
                }
            }
        }
    }

    private void handleGetAllMeeting() {
        List<Meeting> meetingList = meetingController.getAllMeetings(this.userId);
        if(meetingList.isEmpty()){
            logger.info("No Meeting is found");
            return ;
        }
        meetingList.forEach(System.out::println);

    }

}
