/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.domain;

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
public class Visitation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Museum museum;
    @ManyToOne
    private Visitor visitor;
    private LocalDate visitationDate;
    private LocalDate visitationRequestDate;
    @Enumerated(EnumType.STRING)
    private VisitationRequestStatus requestStatus;
    @Enumerated(EnumType.STRING)
    private VisitationOccurrenceStatus occurrenceStatus;

    public Visitation() {
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

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    

    public LocalDate getVisitationDate() {
        return visitationDate;
    }

    public void setVisitationDate(LocalDate visitationDate) {
        this.visitationDate = visitationDate;
    }

    public LocalDate getVisitationRequestDate() {
        return visitationRequestDate;
    }

    public void setVisitationRequestDate(LocalDate visitationRequestDate) {
        this.visitationRequestDate = visitationRequestDate;
    }

    

    public VisitationRequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(VisitationRequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public VisitationOccurrenceStatus getOccurrenceStatus() {
        return occurrenceStatus;
    }

    public void setOccurrenceStatus(VisitationOccurrenceStatus occurrenceStatus) {
        this.occurrenceStatus = occurrenceStatus;
    }
    
    
    
}
