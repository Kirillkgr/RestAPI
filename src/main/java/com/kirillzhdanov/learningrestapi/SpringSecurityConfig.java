package com.kirillzhdanov.learningrestapi;

import com.kirillzhdanov.learningrestapi.security.JwtCsrfFilter;
import com.kirillzhdanov.learningrestapi.security.JwtTokenRepository;
import com.kirillzhdanov.learningrestapi.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl service;

    private final JwtTokenRepository jwtTokenRepository;

    private final HandlerExceptionResolver resolver;
    @Value("${secretKey.secretPass}")
    private String secretWord;

    @Autowired
    public SpringSecurityConfig(UserDetailsServiceImpl service, JwtTokenRepository jwtTokenRepository, @Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver) {
        this.service = service;
        this.jwtTokenRepository = jwtTokenRepository;
        this.resolver = resolver;
    }

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


    @Bean
    public Pbkdf2PasswordEncoder pbkdf2PasswordEncoder() {
        return new Pbkdf2PasswordEncoder(secretWord, 25, 512);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                .addFilterAt(new JwtCsrfFilter(jwtTokenRepository, resolver), CsrfFilter.class)
                .csrf().ignoringAntMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers("/auth/login")
                .authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(((request, response, e) -> resolver.resolveException(request, response, null, e)));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.service);
    }

}
