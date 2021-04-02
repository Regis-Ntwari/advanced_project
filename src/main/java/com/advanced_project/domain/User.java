/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *
 * @author regis
 */
@Entity
@Table(name = "users")
public class User extends Person implements Serializable {

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @Enumerated(EnumType.STRING)
    private UserWorkingStatus userWorkingStatus;

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

}
