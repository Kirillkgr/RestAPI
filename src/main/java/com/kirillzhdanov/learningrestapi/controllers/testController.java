package com.kirillzhdanov.learningrestapi.controllers;

import com.kirillzhdanov.learningrestapi.models.Goods;
import com.kirillzhdanov.learningrestapi.models.User;
import com.kirillzhdanov.learningrestapi.repository.GoodsRepository;
import com.kirillzhdanov.learningrestapi.repository.UserRepository;
import com.kirillzhdanov.learningrestapi.security.base64.CodeEncodeBase64;
import com.kirillzhdanov.learningrestapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.Random;
import java.util.UUID;

@RestController
public class testController {
    @Autowired
    UserRepository userRepository;


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
        new CodeEncodeBase64();
        char a = 'а';
        int count = 0;
        String testWord = "";
        for (int i = 0; i < 4; i++) {
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

    @GetMapping( "/set-cookie")
    public ResponseEntity<?> setCookie(HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("nameCoki","Come_to_the_dark_side");//создаем объект Cookie,
        //в конструкторе указываем значения для name и value
        cookie.setPath("/");//устанавливаем путь
        cookie.setMaxAge(1024);//здесь устанавливается время жизни куки
        cookie.setComment("This comment ");
        cookie.setDomain("localhost");
        cookie.setVersion(1);
        response.addCookie(cookie);//добавляем Cookie в запрос
        response.setContentType("text/plain");//устанавливаем контекст
        return ResponseEntity.ok().body(HttpStatus.OK);//получилось как бы два раза статус ответа установили, выбирайте какой вариант лучше
    }
    @GetMapping( "/ge")
    public ResponseEntity<?> readCookie(@CookieValue(  "data") String data) {
        String ste = data;
        return ResponseEntity.ok().body(data);
    }
    @GetMapping(value = "/set-header")
    public ResponseEntity<?> setHeader(){
        return ResponseEntity.ok().header("Authorization","Basic NzkxNDMyOnpJSnpIVm1F").body(HttpStatus.OK);
    }


}
