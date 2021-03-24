/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.services;

import com.avanced_project.domain.Staff;
import com.avanced_project.domain.StaffWorkingStatus;
import com.avanced_project.domain.Visitation;
import com.avanced_project.domain.VisitationRequestStatus;
import com.pupa.advanced_project.dao.UserDao;
import com.pupa.advanced_project.dao.VisitationDao;

/**
 *
 * @author regis
 */
public class ManagerService {
    private final UserDao userDao = new UserDao();
    private final VisitationDao visitationDao = new VisitationDao();
    
    public void addReceptionist(Staff staff){
        userDao.save(staff);
    }
    public void suspendReceptionist(int staffId){
        Staff receptionist = (Staff) userDao.findById(staffId);
        receptionist.setStaffWorkingStatus(StaffWorkingStatus.SUSPENDED);
        userDao.update(receptionist);
    }
    public void activateReceptionist(int staffId){
        Staff receptionist = (Staff) userDao.findById(staffId);
        receptionist.setStaffWorkingStatus(StaffWorkingStatus.ACTIVE);
        userDao.update(receptionist);
    }
    public void fireReceptionist(int staffId){
        Staff receptionist = (Staff) userDao.findById(staffId);
        receptionist.setStaffWorkingStatus(StaffWorkingStatus.FIRED);
        userDao.update(receptionist);
    }
    public void approveVisit(int visitId){
        Visitation visit = visitationDao.findById(visitId);
        visit.setRequestStatus(VisitationRequestStatus.APPROVED);
        visitationDao.update(visit);
    }
    public void cancelVisit(int visitId){
        Visitation visit = visitationDao.findById(visitId);
        visit.setRequestStatus(VisitationRequestStatus.CANCELLED);
        visitationDao.update(visit);
    }
}
