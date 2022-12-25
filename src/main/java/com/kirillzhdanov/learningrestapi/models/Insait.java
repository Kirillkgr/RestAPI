package com.kirillzhdanov.learningrestapi.models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Insait {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String testInDate;
    @OneToMany
    private List<OutSait> outSaitList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestInDate() {
        return testInDate;
    }

    public void setTestInDate(String testInDate) {
        this.testInDate = testInDate;
    }

    public List<OutSait> getOutSaitList() {
        return outSaitList;
    }

    public void setOutSaitList(List<OutSait> outSaitList) {
        this.outSaitList = outSaitList;
    }
}
