package com.kirillzhdanov.learningrestapi.models;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {
    public User(String login, String password, String passwordConfirm, int count) {
        this.login = login;
        this.password = password;
        this.count = count;
        this.passwordConfirm=passwordConfirm;
    }
    public User(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String passwordConfirm;
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
