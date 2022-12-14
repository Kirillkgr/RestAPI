package com.kirillzhdanov.learningrestapi.models;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
public class UsedJWSTokens {
    public UsedJWSTokens() {
    }

    public UsedJWSTokens(String tokenId, Date now, Date exp, String fullToken) {
        this.tokenId = tokenId;
        this.now = now;
        this.exp = exp;
        this.fullToken = fullToken;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String tokenId;
    private Date now;
    private Date exp;
    private String fullToken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    public String getFullToken() {
        return fullToken;
    }

    public void setFullToken(String fullToken) {
        this.fullToken = fullToken;
    }
}
