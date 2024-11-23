package com.smartTravelPlanner.Service;

import org.springframework.ai.mistralai.MistralAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {


    @Autowired
    private MistralAiChatModel chatModel;
    public String getResponse(String message) {
        try {
          String response=chatModel.call(message);
          return response;
        } catch (Exception e) {
        return "Sorry cant process your request now !";
        }
    }
}
