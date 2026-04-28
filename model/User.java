package model;

import java.util.Date;

// User Model
public class User {
    // Id of the user which is PRIMARY KEY
    private int userId ;
    // Name of the Object
    private String name;
    // Email of the users object
    private String email;
    //Organization of the User Object
    private String organization;
    // Status of the Users
    private Status status;
    // Designation of the Users
    private String designation;
    // Work Details of the user
    private String workDetails;
    // Profile Image URL of the User
    private String profileImage;
    // Hashed Password of the user
    private String password;
    // Date of birth of the user
    private Date dob;
    // Is the User active or not
    private Boolean isActive = true;


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\n' +
                "name='" + name + '\n' +
                "email='" + email + '\n' +
                "organization='" + organization + '\n' +
                "status=" + status +
                "designation='" + designation + '\n' +
                "workDetails='" + workDetails + '\n' +
                "profileImage='" + profileImage + '\n' +
                "dob=" + dob + '\n' +
                "isActive=" + isActive + '\n' +
                '}';
    }

    public User(String name, String email, String organization, Status status, String designation, String workDetails, String profileImage, String password, Date dob, Boolean isActive) {
        this.name = name;
        this.email = email;
        this.organization = organization;
        this.status = status;
        this.designation = designation;
        this.workDetails = workDetails;
        this.profileImage = profileImage;
        this.password = password;
        this.dob = dob;
        this.isActive = isActive;
    }

    // ALl argument constructor
    public User(int userId,
                String name,
                String email,
                String organization,
                Status status,
                String designation,
                String workDetails,
                String profileImage,
                String password,
                Date dob,
                Boolean isActive) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.organization = organization;
        this.status = status;
        this.designation = designation;
        this.workDetails = workDetails;
        this.profileImage = profileImage;
        this.password = password;
        this.dob = dob;
        if(isActive == null) this.isActive = true;
        else this.isActive = isActive;
    }
    // Getter and Setter of all the object typically we use lombok


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getWorkDetails() {
        return workDetails;
    }

    public void setWorkDetails(String workDetails) {
        this.workDetails = workDetails;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
