/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.interfaces;

import com.advanced_project.domain.UserRole;
import com.advanced_project.domain.UserWorkingStatus;
import java.util.Set;

/**
 *
 * @author regis
 * @param <T>
 */
public interface UserDaoInterface<T> extends DaoInterface<T>{
    public T findByUsername(String username);
    public Set<T> findAllUsersByRoleAndWorkingStatus(UserRole userRole, UserWorkingStatus userWorkingStatus);
}
