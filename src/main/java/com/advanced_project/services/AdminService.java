/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.services;

import com.avanced_project.domain.Staff;
import com.pupa.advanced_project.dao.UserDao;

/**
 *
 * @author regis
 */
public class AdminService {
    
    private final UserDao userDao = new UserDao();
    
    public void addManager(Staff staff){
        userDao.save(staff);
    }
    public void deActivateManager(int StaffId){
        
    }
}
