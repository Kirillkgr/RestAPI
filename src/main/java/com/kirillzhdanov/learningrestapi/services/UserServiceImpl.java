package com.kirillzhdanov.learningrestapi.services;

import com.kirillzhdanov.learningrestapi.models.User;
import com.kirillzhdanov.learningrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private Pbkdf2PasswordEncoder pbkdf2PasswordEncoder;

    @Override
    public void save(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPassword(pbkdf2PasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findBylogin(String login) {
        return userRepository.findBylogin(login);
    }
}