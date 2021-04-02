/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.services;

import com.advanced_project.dao.UserDao;
import com.advanced_project.domain.User;
import com.advanced_project.interfaces.UserDaoInterface;

/**
 *
 * @author regis
 */
public class LoginService {
    private final UserDaoInterface userDao = new UserDao();
    
    public User findByUsername(String username){
        User user = (User) userDao.findByUsername(username);
        return user;
    }
    
}
