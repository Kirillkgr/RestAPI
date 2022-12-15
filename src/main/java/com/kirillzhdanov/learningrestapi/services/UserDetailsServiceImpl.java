package com.kirillzhdanov.learningrestapi.services;

import com.kirillzhdanov.learningrestapi.models.User;
import com.kirillzhdanov.learningrestapi.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private static String login;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        UserDetailsServiceImpl.login = login;
    }
    public User getByLogin(String login) {
        return this.userRepository.findBylogin(login);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User u = getByLogin(login);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
        return new org.springframework.security.core.userdetails.User(u.getLogin(), u.getPassword(), true, true, true, true, new HashSet<>());
    }
}
