package service;

import model.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    User createUser(User user);

    User editUserById(User newUser, int userId);

    User deleteUserByUserId(int userId);
    User getUserByEmail(String email);

    boolean isEmailExists(String email);

    boolean isDobValid(Date dob);
}
