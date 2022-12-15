package com.kirillzhdanov.learningrestapi.controllers;

import com.kirillzhdanov.learningrestapi.models.Goods;
import com.kirillzhdanov.learningrestapi.models.User;
import com.kirillzhdanov.learningrestapi.repository.GoodsRepository;
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

    @Autowired
    GoodsRepository goodsRepository;
    @PostConstruct
    public void createTestData() {
        char a = 'а';
        int count = 0;
        String testWord = "";
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            Goods goods = new Goods();
            goods.setPrice(2l*i);
            goods.setBelki(12+i);
            goods.setZire(131+i);
            goods.setUgliv(456+i);
            goods.setIdTableOne(1l);
            goods.setIdTableTwo(2l);
            goods.setIdTableThree(3l);
            goods.setIdTableFour(4l);
            goods.setIdTableFive(5l);
            goods.setName("First goods");
            goods.setBruto(100+i);
            goods.setNetto(94+i);
            goodsRepository.save(goods);
            String pass = String.valueOf(random.nextInt(1654465) + 1567);
            User us = new User(testWord += a++, pass, pass, i);
            userService.save(us);
        }
    }
}
