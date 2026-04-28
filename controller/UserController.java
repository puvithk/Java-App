package controller;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import java.util.Date;
import java.util.List;

// The Class which has operation related to the User Objects
public class UserController {
    // Creating Basic operation like
    // Get Users Object
    // Get user Object by UserId
    // Create User Object
    // Edit user Object by userId
    // Delete User object By userId
    private final UserService userService = new UserServiceImpl();
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }
    public User getUserById(int userId){
        // Get the user from Service
        return userService.getUserById(userId);
    }
    //Method to Create user
    public User createUser(User user){
        // Creating a user
        return userService.createUser(user);
    }
    // Methods to edit the user using User Id
    public User editUserById(int userId, User newUser){
        return userService.editUserById(newUser , userId);
    }
    // method to remove the user from the list
    public User deleteUserById(int userId){
        return userService.deleteUserByUserId(userId);
    }

    public boolean isEmailExists(String email) {
        return userService.isEmailExists(email);
    }
    // Checking weather the DOB is correct
    public boolean isDobValid(Date dob){
        return userService.isDobValid(dob);
    }
    // Checking weather the email is valid
    public boolean isEmailValid(String email){
        return userService.isEmailValid(email);
    }
    // Checking weather the password
    public boolean isPasswordValid(String password) {
        return userService.isPasswordValid(password);
    }
}
