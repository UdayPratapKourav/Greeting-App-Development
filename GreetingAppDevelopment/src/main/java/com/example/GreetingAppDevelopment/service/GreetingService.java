package com.example.GreetingAppDevelopment.service;

import com.example.GreetingAppDevelopment.model.Message;
import com.example.GreetingAppDevelopment.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingService {

    private final MessageRepository messageRepository;

    @Autowired
    public GreetingService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message saveGreeting(Message message) {
        return messageRepository.save(message);
    }

    public String getGreetingMessage(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello " + lastName + "!";
        } else {
            message = "Hello, world!";
        }
        Message message1 = new Message(message);
        saveGreeting(message1);
        return message;
    }

    public Message getMessageById(Long id){
        Optional<Message> message=messageRepository.findById(id);
        return message.orElse(null);
    }
}
