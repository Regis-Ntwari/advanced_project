/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avanced_project.domain;

import java.io.Serializable;
import java.time.LocalDate;
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
public class VisitationStatus implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Visitation visitation;
    @ManyToOne
    private Person person;
    @Enumerated(EnumType.STRING)
    private VisitationOccurrenceStatus visitationOccurrenceStatus;
    @Enumerated(EnumType.STRING)
    private VisitationRequestStatus visitationRequestStatus;
    private LocalDate dateOfOperation;

    public VisitationStatus() {
    }

    public VisitationStatus(Visitation visitation, Person person, VisitationOccurrenceStatus visitationOccurrenceStatus, VisitationRequestStatus visitationRequestStatus, LocalDate dateOfOperation) {
        this.visitation = visitation;
        this.person = person;
        this.visitationOccurrenceStatus = visitationOccurrenceStatus;
        this.visitationRequestStatus = visitationRequestStatus;
        this.dateOfOperation = dateOfOperation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public Visitation getVisitation() {
        return visitation;
    }

    public void setVisitation(Visitation visitation) {
        this.visitation = visitation;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public VisitationOccurrenceStatus getVisitationOccurrenceStatus() {
        return visitationOccurrenceStatus;
    }

    public void setVisitationOccurrenceStatus(VisitationOccurrenceStatus visitationOccurrenceStatus) {
        this.visitationOccurrenceStatus = visitationOccurrenceStatus;
    }

    public VisitationRequestStatus getVisitationRequestStatus() {
        return visitationRequestStatus;
    }

    public void setVisitationRequestStatus(VisitationRequestStatus visitationRequestStatus) {
        this.visitationRequestStatus = visitationRequestStatus;
    }

    public LocalDate getDateOfOperation() {
        return dateOfOperation;
    }

    public void setDateOfOperation(LocalDate dateOfOperation) {
        this.dateOfOperation = dateOfOperation;
    }
    
    
    
}
