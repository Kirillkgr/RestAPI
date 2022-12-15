package com.kirillzhdanov.learningrestapi.services;


import com.kirillzhdanov.learningrestapi.models.User;

public interface UserService   {
    void save(User user);


 User findBylogin(String login);

}
