package com.kirillzhdanov.learningrestapi.controllers;

import com.kirillzhdanov.learningrestapi.models.Users;
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
    @Autowired
    UserService service;

    @GetMapping("test")
    public String getTest() {
        return "Успешная  авторизация";
    }

    @GetMapping("/logout")
    public String Logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        service.setLogin("");
        return "redirect: /login";
    }

    @PostConstruct
    public void createTestData() {
        char a = 'а';
        String testWord = "";
        for (int i = 0; i < 8; i++) {
            Random random = new Random();

            Users us = new Users(testWord += a++, String.valueOf(random.nextInt(1654465) + 1567), i);
            userRepository.save(us);
            random = null;
        }
    }
}
