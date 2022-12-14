package com.kirillzhdanov.learningrestapi.repository;

import com.kirillzhdanov.learningrestapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface UserRepository extends JpaRepository<User,Long> {
//    private List<User> users;
//
//    public UserRepository() {
//        this.users = List.of(new User("Slava", "1234", 0), new User("Anon", "12345", 2));
//    }
//    public User getByLogin(String login) {
//        User us = this.users.stream().filter(user -> login.equals(user.getLogin())).findFirst().orElse(null);
//         //return    this.users.stream().filter(user -> login.equals(user.getLogin())).findFirst().orElse(null);
//        return us;
//    }
//    public List<User> getAll() {
//        return this.users;
//    }


    User findBylogin(String login);
     List<User> findAll();
}
