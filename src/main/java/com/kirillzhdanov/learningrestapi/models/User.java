package com.kirillzhdanov.learningrestapi.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String login;
    private String password;
    private int count;
}
