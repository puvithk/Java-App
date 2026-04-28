package service.impl;

import dao.UserDAO;
import dao.impl.UserDaoImpl;
import exceptions.CreationFailed;
import exceptions.DataAlreadyExistsException;
import exceptions.InvalidDateOfBrith;
import exceptions.UserNotFound;
import model.Status;
import model.User;
import service.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {
    // DAO Object
    private final UserDAO userDAO = new UserDaoImpl();



    public boolean checkUserPresent( String mailId){
        User userByEmail = userDAO.findUserByEmail(mailId);
        return userByEmail != null ;
    }
    @Override
    public List<User> getAllUsers() {
        List<User> users = userDAO.findAllUsers();
        if (users==null){
            throw new UserNotFound("Users List is empty");
        }
        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = userDAO.findUserById(id);
        if(user == null){
            throw new UserNotFound("User not found");
        }
        return user;
    }
    @Override
    public User getUserByEmail(String email){
        User user = userDAO.findUserByEmail(email);
        if(user == null){
            throw new UserNotFound("User not found");
        }
        return user;
    }

    @Override
    public User createUser(User user) {


        // Check the DOB
        if(user.getDob().after(new Date())){
            throw  new InvalidDateOfBrith("Date must be before now");
        }
        // Check weather the user is already present based on the user id and email
        if(checkUserPresent( user.getEmail())){
            // Throw data already exist exception
            throw new DataAlreadyExistsException("User mail or user Id already exist");
        }
        // Add id for the user
        int lastUserId = userDAO.findLastUserId();
        user.setUserId(lastUserId+1);
        // Update the DB
        User newUser = userDAO.createUser(user);
        // Check weather the update is successfully
        if (newUser==null){
            throw new CreationFailed("User Creation failed");
        }
        return user;
    }

    @Override
    public User editUserById(User newUser, int userId) {
        // Check if the user is present
        User user = userDAO.findUserById(userId);
        // Check weather the user is present
        if(user==null){
            throw new UserNotFound("User not found by the id");
        }
        // Check weather the details are valid
        if(newUser.getDob().after(new Date()) || newUser.getDob().equals(new Date())){
            throw new InvalidDateOfBrith("DOB must be before today");
        }
        // Update the user id of new user
        newUser.setUserId(userId);

        // Update using user DAo
        return userDAO.editUserById(newUser);
    }

    @Override
    public User deleteUserByUserId(int userId) {
        User user =  userDAO.findUserById(userId);

        // check is the index is present or not
        if(user ==null){
            // Throw user not found error
            throw new UserNotFound("User Not found ");
        }
        // Delete the user object
        userDAO.deleteUserByUserId(user);

        // Return the deleted user
        return user;
    }

    @Override
    public boolean isEmailExists(String email) {
        return checkUserPresent(email);
    }

    @Override
    public boolean isDobValid(Date dob) {
        return dob.before(new Date());
    }
}
