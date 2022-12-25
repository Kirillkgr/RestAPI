package com.kirillzhdanov.learningrestapi.models;

import javax.persistence.*;

@Entity
public class Goods {
    public Goods() {
    }

    public Goods(Long id, String name, int bruto, int netto, int belki, int zire, int ugliv, Long price, Long idTableOne, Long idTableTwo, Long idTableThree, Long idTableFour, Long idTableFive) {
        this.id = id;
        this.name = name;
        this.bruto = bruto;
        this.netto = netto;
        this.belki = belki;
        this.zire = zire;
        this.ugliv = ugliv;
        this.price = price;
        this.idTableOne = idTableOne;
        this.idTableTwo = idTableTwo;
        this.idTableThree = idTableThree;
        this.idTableFour = idTableFour;
        this.idTableFive = idTableFive;
    }

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
