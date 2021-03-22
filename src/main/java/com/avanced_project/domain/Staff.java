/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avanced_project.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author regis
 */
@Entity
public class Staff extends User implements Serializable{
    @Enumerated(EnumType.STRING)
    private StaffRole staffRole;
    @Enumerated(EnumType.STRING)
    private StaffWorkingStatus staffWorkingStatus;

    public Staff() {
    }

    public StaffWorkingStatus getStaffWorkingStatus() {
        return staffWorkingStatus;
    }

    public void setStaffWorkingStatus(StaffWorkingStatus staffWorkingStatus) {
        this.staffWorkingStatus = staffWorkingStatus;
    }
    

    public StaffRole getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(StaffRole staffRole) {
        this.staffRole = staffRole;
    }
    
    
}
