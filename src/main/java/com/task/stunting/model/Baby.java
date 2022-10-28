package com.task.stunting.model;

import javax.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="baby")
public class Baby {
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

    @Column(name="isbreastmilk")
    private Boolean isBreastmilk;

    @Column(name="isimmunized")
    private Boolean isImmunized;

    @Column(name="stuntingpotention")
    private String stuntingPotention;


    @ManyToOne
    @JoinColumn(name = "pregnantmother_id")
    @JsonBackReference
    private Pregnantmother pregnantmother;

    public Pregnantmother getPregnantmother() {
        return pregnantmother;
    }

    public void setPregnantmother(Pregnantmother pregnantmother) {
        this.pregnantmother = pregnantmother;
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

    public Boolean getBreastmilk() {
        return isBreastmilk;
    }

    public void setBreastmilk(Boolean breastmilk) {
        isBreastmilk = breastmilk;
    }

    public Boolean getImmunized() {
        return isImmunized;
    }

    public void setImmunized(Boolean immunized) {
        isImmunized = immunized;
    }

    public String getStuntingPotention() {
        return stuntingPotention;
    }

    public void setStuntingPotention(String stuntingPotention) {
        this.stuntingPotention = stuntingPotention;
    }
}
