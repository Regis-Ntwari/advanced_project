/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.services;

import com.avanced_project.domain.Admin;
import com.avanced_project.domain.Staff;
import com.avanced_project.domain.Visitor;
import com.advanced_project.dao.UserDao;

/**
 *
 * @author regis
 */
public class LoginService {
    private final UserDao userDao = new UserDao();
    public Staff findStaffByUsername(String username){
        return userDao.findStaffByUsername(username);
        
    }
    public Visitor findVisitorByUsername(String username){
        return userDao.findVisitorByUsername(username);
    }
    public Admin findAdminByUsername(String username){
        return userDao.findAdminByUsername(username);
    }
    
}
