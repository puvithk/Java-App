package dao;

import model.User;

import java.util.List;

//  Repository to get the data
public interface UserDAO {
    List<User> findAllUsers();
    User findUserById(int id);
    
    User findUserByEmail(String email);
    User createUser(User user);

    User editUserById(User newUser);

    User deleteUserByUserId(User userId);

    int findLastUserId();

}
