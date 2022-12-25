package com.kirillzhdanov.learningrestapi.models;


import lombok.Data;

import javax.persistence.*;


@Entity
public class OutSait {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String outSatteDate;
    @ManyToOne
    private Insait insait;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOutSatteDate() {
        return outSatteDate;
    }

    public void setOutSatteDate(String outSatteDate) {
        this.outSatteDate = outSatteDate;
    }

    public Insait getInsait() {
        return insait;
    }

    public void setInsait(Insait insait) {
        this.insait = insait;
    }
}
