/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author regis
 */
@Entity
public class Museum implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String district;
    @Enumerated(value = EnumType.STRING)
    private MuseumStatus status;
    @ManyToOne
    private MuseumType type;
    @OneToMany(mappedBy = "museum")
    private List<Visitation> visits;

    public Museum() {
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public MuseumStatus getStatus() {
        return status;
    }

    public void setStatus(MuseumStatus status) {
        this.status = status;
    }

    public MuseumType getType() {
        return type;
    }

    public void setType(MuseumType type) {
        this.type = type;
    }

    public List<Visitation> getVisits() {
        return visits;
    }

    public void setVisits(List<Visitation> visits) {
        this.visits = visits;
    }
    
    
}
