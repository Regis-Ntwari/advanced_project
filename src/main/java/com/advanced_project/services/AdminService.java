/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.services;

import com.advanced_project.dao.MuseumDao;
import com.advanced_project.dao.MuseumStatusTrackDao;
import com.advanced_project.dao.UserDao;
import com.advanced_project.dao.UserStatusDao;
import com.advanced_project.interfaces.UserDaoInterface;
import com.advanced_project.domain.Museum;
import com.advanced_project.domain.MuseumStatus;
import com.advanced_project.domain.MuseumStatusTrack;
import com.advanced_project.domain.User;
import com.advanced_project.domain.UserRole;
import com.advanced_project.domain.UserStatus;
import com.advanced_project.domain.UserWorkingStatus;
import com.advanced_project.interfaces.DaoInterface;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author regis
 */
public class AdminService {
    
    private final UserDaoInterface userDao = new UserDao();
    private final MuseumDao museumDao = new MuseumDao();
    private final DaoInterface userStatusDao = new UserStatusDao();
    private final DaoInterface museumStatusTrackDao = new MuseumStatusTrackDao();
    
    public void addManager(int adminId, User staff, String comment){
        User admin = (User) userDao.findById(adminId);
        staff.setUserRole(UserRole.MANAGER);
        staff.setUserWorkingStatus(UserWorkingStatus.ACTIVE);
        userDao.save(staff);
        userStatusDao.save(new UserStatus(staff, UserRole.MANAGER, staff.getUserWorkingStatus(), admin, LocalDateTime.now(), comment));
        
    }
    public void fireManager(int adminId, int userId, String comment){
        User admin = (User) userDao.findById(adminId);
        User s = (User) userDao.findById(userId);
        s.setUserWorkingStatus(UserWorkingStatus.DISMISSED);
        userDao.update(s);
        userStatusDao.save(new UserStatus(s, UserRole.MANAGER, s.getUserWorkingStatus(), admin, LocalDateTime.now(), comment));
    }
    public void suspendManager(int adminId, int userId, String comment){
        User admin = (User) userDao.findById(adminId);
        User s = (User) userDao.findById(userId);
        s.setUserWorkingStatus(UserWorkingStatus.NOT_AVAILABLE);
        userDao.update(s);
        userStatusDao.save(new UserStatus(s, UserRole.MANAGER, s.getUserWorkingStatus(), admin, LocalDateTime.now(), comment));
    }
    public void addMuseum(int userId, Museum museum, String comment){
        User user = (User) userDao.findById(userId);
        museum.setStatus(MuseumStatus.ACTIVATED);
        museumDao.save(museum);
        museumStatusTrackDao.save(
                new MuseumStatusTrack(
                        museum, 
                        museum.getStatus(), 
                        LocalDateTime.now(), 
                        comment, 
                        user));
    }
    public void disableMuseum(int userId, int museumId, String comment){
        User user = (User) userDao.findById(userId);
        Museum museum = museumDao.findById(museumId);
        museum.setStatus(MuseumStatus.DEACTIVATED);
        museumDao.update(museum);
        museumStatusTrackDao.save(
                new MuseumStatusTrack(
                        museum, 
                        museum.getStatus(), 
                        LocalDateTime.now(), 
                        comment, 
                        user));
        
    }
    public Set<User> findAllActiveManagers(){
        return userDao.findAllUsersByRoleAndWorkingStatus(UserRole.MANAGER, 
                                                        UserWorkingStatus.ACTIVE);
    }
    public Set<User> findAllNonAvailableManagers(){
        return userDao.findAllUsersByRoleAndWorkingStatus(UserRole.MANAGER, 
                                                        UserWorkingStatus.NOT_AVAILABLE);
    }
    public Set<User> findAllDismissedManagers(){
        return userDao.findAllUsersByRoleAndWorkingStatus(UserRole.MANAGER, 
                                                        UserWorkingStatus.DISMISSED);
    }
    public Set<User> findAllMuseumTrack(){
        return new HashSet<>(museumStatusTrackDao.findAll());
    }
    public Set<User> findAllUserTrack(){
        return new HashSet<>(userStatusDao.findAll());
    }
}
