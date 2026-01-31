package com.smartTravelPlanner.ServiceTest;

import com.smartTravelPlanner.Entity.UserEntity;
import com.smartTravelPlanner.Repository.UserRepository;
import com.smartTravelPlanner.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void registerUserTest_Success(){
        Mockito.when(userRepository.findByUsername("Rahul")).thenReturn(null);
        Mockito.when(passwordEncoder.encode("121")).thenReturn("hashed121");
        Mockito.when(userRepository.save(any(UserEntity.class))).thenReturn(new UserEntity());
        String result=userService.registerUser("Rahul","121");
        Assertions.assertEquals("User registered successfully.",result);
        Mockito.verify(userRepository).save(Mockito.any(UserEntity.class));
    }
    @Test
    void loginUser_Success()
    {
     UserEntity fakeUser=new UserEntity();
     fakeUser.setUsername("Rahul");
     fakeUser.setPassword("hii");
     Mockito.when(userRepository.findByUsername("Rahul")).thenReturn(fakeUser);
     Mockito.when(passwordEncoder.matches("hii","hii")).thenReturn(true);
     UserEntity result=userService.loginUser("Rahul","hii");
     Assertions.assertEquals("Rahul",result.getUsername());
     Assertions.assertEquals("hii",result.getPassword());
     //Mockito.verify(userRepository).findByUsername("Rahul");
     //Mockito.verify(passwordEncoder).matches("hii","hii");

    }
}
