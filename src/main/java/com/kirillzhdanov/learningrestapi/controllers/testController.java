package com.kirillzhdanov.learningrestapi.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @GetMapping("test")
    public  String getTest(){
        return "Успешная  авторизация";
    }
}
