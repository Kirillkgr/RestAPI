package com.kirillzhdanov.learningrestapi.controllers;

import com.kirillzhdanov.learningrestapi.models.User;
import com.kirillzhdanov.learningrestapi.repository.UserRepository;
import com.kirillzhdanov.learningrestapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Random;

@RestController
public class testController {
    @Autowired
    UserRepository userRepository;
    //TODO: some test
    @Autowired
    UserService userService;

    @GetMapping("test")
    public String getTest() {
        return "Успешная  авторизация";
    }

    @GetMapping("/logout")
    public String Logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        //userDetailsService.setLogin("");
        return "redirect: /login";
    }

    @PostConstruct
    public void createTestData() {
        char a = 'а';
        int count = 0;
        String testWord = "";
        for (int i = 0; i < 255; i++) {
            Random random = new Random();
            String pass = String.valueOf(random.nextInt(1654465) + 1567);
            User us = new User(testWord += a++, pass, pass, i);
            userService.save(us);
            if(i==254){
                count++;
                i=0;
                testWord="";
            }
            if(count>10){
                i=256;
            }
        }
    }
}
