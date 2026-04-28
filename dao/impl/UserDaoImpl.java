package dao.impl;

import dao.UserDAO;
import model.Status;
import model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDAO {
    List<User> users = new ArrayList<>(List.of(

            new User(1, "Aarav Sharma", "aarav.sharma@gmail.com", "TechCorp",
                    Status.AVAILABLE, "Software Engineer", "Backend Developer",
                    "img1.jpg", "pass123", new Date(), true),

            new User(2, "Diya Patel", "diya.patel@gmail.com", "InnoSoft",
                    Status.AVAILABLE, "Frontend Developer", "React Specialist",
                    "img2.jpg", "pass123", new Date(), true),

            new User(3, "Rohan Verma", "rohan.verma@gmail.com", "CloudNet",
                    Status.OUT_OF_OFFICE, "DevOps Engineer", "AWS & CI/CD",
                    "img3.jpg", "pass123", new Date(), false),

            new User(4, "Ananya Reddy", "ananya.reddy@gmail.com", "DataWorks",
                    Status.AVAILABLE, "Data Scientist", "ML Models",
                    "img4.jpg", "pass123", new Date(), true),

            new User(5, "Karan Mehta", "karan.mehta@gmail.com", "FinTechX",
                    Status.AVAILABLE, "QA Engineer", "Automation Testing",
                    "img5.jpg", "pass123", new Date(), true),

            new User(6, "Sneha Iyer", "sneha.iyer@gmail.com", "HealthPlus",
                    Status.AVAILABLE, "Product Manager", "Agile & Scrum",
                    "img6.jpg", "pass123", new Date(), true),

            new User(7, "Vikram Singh", "vikram.singh@gmail.com", "EduCore",
                    Status.OUT_OF_OFFICE, "System Analyst", "System Design",
                    "img7.jpg", "pass123", new Date(), false),

            new User(8, "Priya Nair", "priya.nair@gmail.com", "AI Labs",
                    Status.PRESENTING, "AI Engineer", "Deep Learning",
                    "img8.jpg", "pass123", new Date(), true),

            new User(9, "Rahul Das", "rahul.das@gmail.com", "SecureIT",
                    Status.AVAILABLE, "Cybersecurity Analyst", "Network Security",
                    "img9.jpg", "pass123", new Date(), true),

            new User(10, "Meera Joshi", "meera.joshi@gmail.com", "DesignHub",
                    Status.AVAILABLE, "UI/UX Designer", "Figma & UX Research",
                    "img10.jpg", "pass123", new Date(), true)
    ));
    // Method to find the index based on the user
    private int getIndexByUserId( int userId){
        for(int i = 0 ;i<users.size() ;  i++){
            if(users.get(i).getUserId() == userId){
                return i;
            }
        }
        return -1;
    }
    @Override
    public List<User> findAllUsers() {
        if(users.isEmpty()){
            return List.of();
        }
        return users;
    }

    @Override
    public User findUserById(int id) {
        return users
                .stream()
                .filter(user1 ->
                        user1.getUserId() == (id)
                )
                .findFirst()
                .orElse(null);

    }

    @Override
    public User findUserByEmail(String email) {
        return users
                .stream()
                .filter(
                        user -> user.getEmail().equals(email)
                ).findFirst()
                .orElse(null);
    }

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User editUserById(User newUser) {
        // Get the index
        int index = getIndexByUserId(newUser.getUserId());
        // Update the data
        users.set(index , newUser);
        // Return the updated user
        return newUser;
    }

    @Override
    public User deleteUserByUserId(User user) {
        users.remove(user);
        return user;
    }

    @Override
    public int findLastUserId() {
        return users.getLast().getUserId();

    }


}
