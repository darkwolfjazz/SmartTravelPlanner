package com.smartTravelPlanner.Controller;

import com.smartTravelPlanner.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {


@Autowired
    private ChatService chatService;

@PostMapping("/chat")
    public String getResponse(@RequestBody String message) {
        return chatService.getResponse(message);
    }
}
