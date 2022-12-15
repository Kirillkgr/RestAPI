package com.kirillzhdanov.learningrestapi.models;


import lombok.Data;

import javax.persistence.*;

@Entity
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private int bruto;
    private int netto;
    private int belki;
    private int zire;
    private int ugliv;
    private Long price;

    private Long idTableOne;
    private Long idTableTwo;
    private Long idTableThree;
    private Long idTableFour;
    private Long idTableFive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBruto() {
        return bruto;
    }

    public void setBruto(int bruto) {
        this.bruto = bruto;
    }

    public int getNetto() {
        return netto;
    }

    public void setNetto(int netto) {
        this.netto = netto;
    }

    public int getBelki() {
        return belki;
    }

    public void setBelki(int belki) {
        this.belki = belki;
    }

    public int getZire() {
        return zire;
    }

    public void setZire(int zire) {
        this.zire = zire;
    }

    public int getUgliv() {
        return ugliv;
    }

    public void setUgliv(int ugliv) {
        this.ugliv = ugliv;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getIdTableOne() {
        return idTableOne;
    }

    public void setIdTableOne(Long idTableOne) {
        this.idTableOne = idTableOne;
    }

    public Long getIdTableTwo() {
        return idTableTwo;
    }

    public void setIdTableTwo(Long idTableTwo) {
        this.idTableTwo = idTableTwo;
    }

    public Long getIdTableThree() {
        return idTableThree;
    }

    public void setIdTableThree(Long idTableThree) {
        this.idTableThree = idTableThree;
    }

    public Long getIdTableFour() {
        return idTableFour;
    }

    public void setIdTableFour(Long idTableFour) {
        this.idTableFour = idTableFour;
    }

    public Long getIdTableFive() {
        return idTableFive;
    }

    public void setIdTableFive(Long idTableFive) {
        this.idTableFive = idTableFive;
    }
}
