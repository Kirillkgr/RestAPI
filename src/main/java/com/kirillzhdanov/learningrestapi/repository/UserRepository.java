package com.kirillzhdanov.learningrestapi.repository;

import com.kirillzhdanov.learningrestapi.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
//    private List<Users> users;
//
//    public UserRepository() {
//        this.users = List.of(new Users("Slava", "1234", 0), new Users("Anon", "12345", 2));
//    }
//    public Users getByLogin(String login) {
//        Users us = this.users.stream().filter(user -> login.equals(user.getLogin())).findFirst().orElse(null);
//         //return    this.users.stream().filter(user -> login.equals(user.getLogin())).findFirst().orElse(null);
//        return us;
//    }
//    public List<Users> getAll() {
//        return this.users;
//    }


    Users findBylogin(String login);
     List<Users> findAll();
}
