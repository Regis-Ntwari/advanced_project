/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author regis
 */
@Entity
public class MuseumStatusTrack implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Museum museum;
    @Enumerated(EnumType.STRING)
    private MuseumStatus museumStatus;
    private LocalDateTime dateOfAction;
    private String comment;
    @ManyToOne
    private User doneBy;

    public MuseumStatusTrack() {
    }

    public MuseumStatusTrack(Museum museum, MuseumStatus museumStatus, LocalDateTime dateOfAction, String comment, User doneBy) {
        this.museum = museum;
        this.museumStatus = museumStatus;
        this.dateOfAction = dateOfAction;
        this.comment = comment;
        this.doneBy = doneBy;
    }

    public User getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(User doneBy) {
        this.doneBy = doneBy;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Museum getMuseum() {
        return museum;
    }

    public void setMuseum(Museum museum) {
        this.museum = museum;
    }

    public MuseumStatus getMuseumStatus() {
        return museumStatus;
    }

    public void setMuseumStatus(MuseumStatus museumStatus) {
        this.museumStatus = museumStatus;
    }

    public LocalDateTime getDateOfAction() {
        return dateOfAction;
    }

    public void setDateOfAction(LocalDateTime dateOfAction) {
        this.dateOfAction = dateOfAction;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
