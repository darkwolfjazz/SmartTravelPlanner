package com.smartTravelPlanner.Controller;

import com.smartTravelPlanner.Entity.UserEntity;
import com.smartTravelPlanner.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

@Autowired
    private UserService userService;

@PostMapping("/register")
public String registerUser(@RequestParam String username, @RequestParam String password) {
    return userService.registerUser(username, password);
}

@PostMapping("/login")
public UserEntity loginUser(@RequestParam String username, @RequestParam String password) {
    return userService.loginUser(username, password);
}
}
