/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.services;

import com.advanced_project.dao.MuseumDao;
import com.advanced_project.dao.UserDao;
import com.advanced_project.interfaces.UserDaoInterface;
import com.avanced_project.domain.Museum;
import com.avanced_project.domain.MuseumStatus;
import com.avanced_project.domain.User;
import com.avanced_project.domain.UserRole;
import com.avanced_project.domain.UserWorkingStatus;

/**
 *
 * @author regis
 */
public class AdminService {
    
    private final UserDaoInterface userDao = new UserDao();
    private final MuseumDao museumDao = new MuseumDao();
    
    public void addManager(User staff){
        staff.setUserRole(UserRole.MANAGER);
        staff.setUserWorkingStatus(UserWorkingStatus.ACTIVE);
        userDao.save(staff);
    }
    public void fireManager(int userId){
        User s = (User) userDao.findById(userId);
        s.setUserWorkingStatus(UserWorkingStatus.FIRED);
        userDao.update(s);
    }
    public void suspendManager(int userId){
        User s = (User) userDao.findById(userId);
        s.setUserWorkingStatus(UserWorkingStatus.SUSPENDED);
        userDao.update(s);
    }
    public void addMuseum(Museum museum){
        museumDao.save(museum);
    }
    public void disableMuseum(int museumId){
        Museum m = museumDao.findById(museumId);
        m.setStatus(MuseumStatus.INACTIVE);
        museumDao.update(m);
    }
}
