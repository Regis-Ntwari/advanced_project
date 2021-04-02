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
public class UserStatus implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User doneTo;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @Enumerated(EnumType.STRING)
    private UserWorkingStatus userWorkingStatus;
    @ManyToOne
    private User doneBy;
    private LocalDateTime dateOfAction;
    private String comment;

    public UserStatus() {
    }

    
    public UserStatus(User doneTo, UserRole userRole, UserWorkingStatus userWorkingStatus, User doneBy, LocalDateTime dateOfAction, String comment) {
        this.doneTo = doneTo;
        this.userRole = userRole;
        this.userWorkingStatus = userWorkingStatus;
        this.doneBy = doneBy;
        this.dateOfAction = dateOfAction;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getDoneTo() {
        return doneTo;
    }

    public void setDoneTo(User doneTo) {
        this.doneTo = doneTo;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserWorkingStatus getUserWorkingStatus() {
        return userWorkingStatus;
    }

    public void setUserWorkingStatus(UserWorkingStatus userWorkingStatus) {
        this.userWorkingStatus = userWorkingStatus;
    }

    public User getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(User doneBy) {
        this.doneBy = doneBy;
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
