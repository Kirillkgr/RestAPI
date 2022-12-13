package com.kirillzhdanov.learningrestapi.repository;

import com.kirillzhdanov.learningrestapi.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = List.of(new User("Slave", "1234", 0), new User("Whore", "12345", 2));
    }

    public User getByLogin(String login) {
        return this.users.stream().filter(user -> login.equals(user.getLogin())).findFirst().orElse(null);
    }

    public List<User> getAll() {
        return this.users;
    }
}
