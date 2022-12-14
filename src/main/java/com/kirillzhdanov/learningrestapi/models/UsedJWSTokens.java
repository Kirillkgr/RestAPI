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
}
