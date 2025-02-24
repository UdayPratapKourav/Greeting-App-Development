package com.example.GreetingAppDevelopment.service;

import com.example.GreetingAppDevelopment.model.Message;
import com.example.GreetingAppDevelopment.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Message> getAllMessage(){
        return messageRepository.findAll();
    }
    public Message updateMessage(Long id , Message message){
        Optional<Message>existingMessage=messageRepository.findById(id);
        if(existingMessage.isPresent()){
            Message message1=existingMessage.get();
            message1.setMessage(message.getMessage());
            return messageRepository.save(message1);
        }else{
            return null;
        }
    }
    public String deleteMessage(Long id ){
        Optional<Message>message=messageRepository.findById(id);
        if(message.isPresent()){
            messageRepository.deleteById(id);
            return "Greeting with id :"+id+" deleted successfully";
        }else{
            return "Greeting not found ";
        }
    }
}
