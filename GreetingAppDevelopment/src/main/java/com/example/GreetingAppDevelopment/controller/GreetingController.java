package com.example.GreetingAppDevelopment.controller;

import com.example.GreetingAppDevelopment.model.Greeting;
import com.example.GreetingAppDevelopment.model.Message;
import com.example.GreetingAppDevelopment.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @GetMapping("/message")
    public String getGreetingMessage(@RequestParam(required = false) String firstName,
                                     @RequestParam(required = false) String lastName) {
        return greetingService.getGreetingMessage(firstName, lastName);
    }

    @PostMapping("/save")
    public Message saveGreeting(@RequestBody Message message) {
        return greetingService.saveGreeting(message);
    }
    @GetMapping("/{id}")
    public Message getMessage(@PathVariable Long id){
        return greetingService.getMessageById(id);
    }
    @GetMapping("/all")
    public List<Message> getAllMessage(){
        return greetingService.getAllMessage();
    }
    @GetMapping
    public Greeting getGreeting() {
        return new Greeting("Hello, this is a GET request!");
    }

    @PostMapping
    public Greeting postGreeting() {
        return new Greeting("Hello, this is a POST request!");
    }

    @PutMapping
    public Greeting putGreeting() {
        return new Greeting("Hello, this is a PUT request!");
    }

    @DeleteMapping
    public Greeting deleteGreeting() {
        return new Greeting("Hello, this is a DELETE request!");
    }
}
