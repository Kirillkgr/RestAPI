package com.kirillzhdanov.learningrestapi.rest;

import com.kirillzhdanov.learningrestapi.models.User;
import com.kirillzhdanov.learningrestapi.repository.UserRepository;
import com.kirillzhdanov.learningrestapi.security.JwtTokenRepository;
import com.kirillzhdanov.learningrestapi.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    JwtTokenRepository jwtTokenRepository;
    private final UserRepository userRepository;

    public AuthController(UserDetailsServiceImpl userDetailsService,
                          UserRepository userRepository) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User getAuthUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        org.springframework.security.core.userdetails.User user = (principal instanceof org.springframework.security.core.userdetails.User) ? (org.springframework.security.core.userdetails.User) principal : null;
        userDetailsService.setLogin(user.getUsername() != null ? user.getUsername() : "");
        return Objects.nonNull(user) ? this.userDetailsService.getByLogin(user.getUsername()) : null;
    }

    @PostConstruct
    public void test() {
        new GetJsonFromServer("http://localhost:36/auth/login?besad=Director&daseb=Director");
    }
}
