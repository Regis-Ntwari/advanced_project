/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.services;

import com.advanced_project.domain.UserWorkingStatus;
import com.advanced_project.domain.Visitation;
import com.advanced_project.domain.VisitationRequestStatus;
import com.advanced_project.dao.UserDao;
import com.advanced_project.dao.VisitationDao;
import com.advanced_project.interfaces.UserDaoInterface;
import com.advanced_project.interfaces.VisitationDaoInterface;
import com.advanced_project.domain.User;
import com.advanced_project.domain.UserRole;
import java.util.Set;

/**
 *
 * @author regis
 */
public class ManagerService {
    private final UserDaoInterface userDao = new UserDao();
    private final VisitationDaoInterface visitationDao = new VisitationDao();
    
    public void addReceptionist(User staff){
        staff.setUserRole(UserRole.RECEPTIONIST);
        userDao.save(staff);
    }
    public void suspendReceptionist(int userId){
        User receptionist = (User) userDao.findById(userId);
        receptionist.setUserWorkingStatus(UserWorkingStatus.NOT_AVAILABLE);
        userDao.update(receptionist);
    }
    public void activateReceptionist(int userId){
        User receptionist = (User) userDao.findById(userId);
        receptionist.setUserWorkingStatus(UserWorkingStatus.ACTIVE);
        userDao.update(receptionist);
    }
    public void fireReceptionist(int userId){
        User receptionist = (User) userDao.findById(userId);
        receptionist.setUserWorkingStatus(UserWorkingStatus.DISMISSED);
        userDao.update(receptionist);
    }
    public void approveVisit(int visitId){
        Visitation visit = (Visitation) visitationDao.findById(visitId);
        visit.setRequestStatus(VisitationRequestStatus.APPROVED);
        visitationDao.update(visit);
    }
    public void cancelVisit(int visitId){
        Visitation visit = (Visitation) visitationDao.findById(visitId);
        visit.setRequestStatus(VisitationRequestStatus.CANCELLED);
        visitationDao.update(visit);
    }
    public Set<User> findAllActiveReceptionists(){
        return userDao.findAllUsersByRoleAndWorkingStatus(UserRole.RECEPTIONIST, 
                                                            UserWorkingStatus.ACTIVE);
    }
    public Set<User> findAllNonAvailableReceptionists(){
        return userDao.findAllUsersByRoleAndWorkingStatus(UserRole.RECEPTIONIST, 
                                                            UserWorkingStatus.NOT_AVAILABLE);
    }
    public Set<User> findAllDismissedReceptionists(){
        return userDao.findAllUsersByRoleAndWorkingStatus(UserRole.RECEPTIONIST, 
                                                            UserWorkingStatus.DISMISSED);
    }
}
