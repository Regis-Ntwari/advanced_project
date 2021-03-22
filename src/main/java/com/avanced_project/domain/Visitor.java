/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avanced_project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author regis
 */
@Entity
public class Visitor extends User implements Serializable{
    private String passportNumber;
    @OneToMany(mappedBy = "visitor")
    private List<Visitation> visits = new ArrayList<>();

    public Visitor() {
    }
    

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public List<Visitation> getVisits() {
        return visits;
    }

    public void setVisits(List<Visitation> visits) {
        this.visits = visits;
    }
    
    
}
