package com.kirillzhdanov.learningrestapi.services;

import com.kirillzhdanov.learningrestapi.models.Users;
import com.kirillzhdanov.learningrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    private static String login;

    public   String getLogin() {
        String logina = login;
//       login = "";
        return logina;
    }

    public   void setLogin(String login) {
        UserService.login = login;
    }

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<Users> getAll() {
        return this.repository.findAll();
    }

    public Users getByLogin(String login) {
        return this.repository.findBylogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Users u = getByLogin(login);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("Users %s is not found", login));
        }
        return new org.springframework.security.core.userdetails.User(u.getLogin(), u.getPassword(), true, true, true, true, new HashSet<>());
    }
}
