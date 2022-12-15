package com.kirillzhdanov.learningrestapi.models;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class Users {
    public Users(String login, String password, int count) {
        this.login = login;
        this.password = password;
        this.count = count;
    }
    public Users(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
