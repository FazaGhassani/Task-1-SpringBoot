package com.task.stunting.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="pregnantmother")
public class Pregnantmother {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="birthdate")
    private Date birthdate;

    @Column(name="weight")
    private int weight;

    @Column(name="height")
    private int height;

    @Column(name="issmoking")
    private Boolean isSmoking;

    @Column(name="isvitamin")
    private Boolean isVitamin;

    @Column(name="recommendation")
    private String recommendation;

    @JsonManagedReference
    @OneToMany(mappedBy = "pregnantmother")
    private List<Baby> babyList;

    public List<Baby> getBabyList() {
        return babyList;
    }

    public void setBabyList(List<Baby> babyList) {
        this.babyList = babyList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Boolean getSmoking() {
        return isSmoking;
    }

    public void setSmoking(Boolean smoking) {
        isSmoking = smoking;
    }

    public Boolean getVitamin() {
        return isVitamin;
    }

    public void setVitamin(Boolean vitamin) {
        isVitamin = vitamin;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }


}
