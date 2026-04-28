package ui;

import controller.AuthController;
import exceptions.LoginFailed;
import exceptions.StopApplication;
import exceptions.UserNotFound;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class LoginUi {
    // Create a scanner
    private static final Scanner scanner =new Scanner(System.in);
    // LoginController app
    private static  final AuthController authController = new AuthController();

    public int loginUi(){
        while(true) {
            System.out.println("========LOGIN========");
            System.out.println("Enter the Email : ");
            String username = scanner.nextLine();
            System.out.println("Enter the Password : ");
            String password = scanner.nextLine();
            try{
                int userId =  authController.login(username , password);
                return userId;
            }catch (LoginFailed loginFailed){
                System.out.println("Email id or Password is wrong");
                System.out.println("Try Again (y/n)");
                String choice = scanner.nextLine();
                if(choice.equalsIgnoreCase("n")){
                    throw new StopApplication("Stoping the App ..........");

                }else if (!choice.equalsIgnoreCase("y")){
                    throw new StopApplication("Stoping the App ..........");
                }
            }
        }
    }
}
