package com.smartTravelPlanner.Service;

import com.smartTravelPlanner.Entity.UserEntity;
import com.smartTravelPlanner.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(String username, String password) {
        // Check if the email already exists in the database
        if (userRepository.findByUsername(username) != null) {
            return "Email already exists. Please choose a different email.";
        } else {
            // Hash the password
            String hashedPassword = passwordEncoder.encode(password);
            // Save the user to the database
            UserEntity user = new UserEntity();
            user.setUsername(username);
            user.setPassword(hashedPassword);
            userRepository.save(user);
            return "User registered successfully.";
        }
    }


    public UserEntity loginUser(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new IllegalArgumentException("Invalid email or password.");
        }
    }

}