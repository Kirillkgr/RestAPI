package com.kirillzhdanov.learningrestapi.controllers;

import com.kirillzhdanov.learningrestapi.models.User;
import com.kirillzhdanov.learningrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Random;

@RestController
public class testController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("test")
    public  String getTest(){
        return "Успешная  авторизация";
    }
    @PostConstruct
    public void createTestData(){
char a=' ';
String testWord ="";
        for (int i = 0; i < 255; i++) {
            Random random = new Random();

            User us = new User(testWord+=a++,String.valueOf(random.nextInt(1654465) + 1567),i);
            userRepository.save(us);
            random=null;
        }

    }
}
