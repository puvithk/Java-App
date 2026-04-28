package service.impl;

import exceptions.LoginFailed;
import exceptions.UserNotFound;
import model.User;
import service.AuthService;
import service.UserService;

public class DaoAuthServiceImpl implements AuthService {
    // Get User service for retrieval of user data
    private final  static UserService userService = new UserServiceImpl();
    @Override
    public int login(String email, String pass) {
        // Get the user from email
        try {
            // Check weather the data is there
            User user = userService.getUserByEmail(email);
            // Check weather the password and password in user is correct

            if(user!=null && user.getPassword().equals(pass)){
                // IF password is correct then return the userId
                return user.getUserId();
            }else {
                throw new LoginFailed("Email or password is not found");
            }

        }catch (UserNotFound userNotFound) {
            throw new LoginFailed("Email or password is wrong ");
        }



    }
}
