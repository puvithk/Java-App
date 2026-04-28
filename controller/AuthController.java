package controller;

import service.AuthService;
import service.impl.DaoAuthServiceImpl;

// Controller to login
public class AuthController {
    // Make a DaoAuthService
    private final AuthService authService = new DaoAuthServiceImpl();
    // Login setup
    public int login(String email , String password){
        // Send the data to the service layer
        return authService.login(email , password);
    }
}
