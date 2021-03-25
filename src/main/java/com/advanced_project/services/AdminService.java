/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.services;

import com.advanced_project.dao.MuseumDao;
import com.avanced_project.domain.Staff;
import com.advanced_project.dao.UserDao;
import com.avanced_project.domain.Museum;
import com.avanced_project.domain.MuseumStatus;
import com.avanced_project.domain.StaffRole;
import com.avanced_project.domain.StaffWorkingStatus;

/**
 *
 * @author regis
 */
public class AdminService {
    
    private final UserDao userDao = new UserDao();
    private final MuseumDao museumDao = new MuseumDao();
    
    public void addManager(Staff staff){
        staff.setStaffRole(StaffRole.MANAGER);
        staff.setStaffWorkingStatus(StaffWorkingStatus.ACTIVE);
        userDao.save(staff);
    }
    public void fireManager(int StaffId){
        Staff s = (Staff) userDao.findByStaffId(StaffId);
        s.setStaffWorkingStatus(StaffWorkingStatus.FIRED);
        userDao.update(s);
    }
    public void suspendManager(int StaffId){
        Staff s = (Staff) userDao.findByStaffId(StaffId);
        s.setStaffWorkingStatus(StaffWorkingStatus.SUSPENDED);
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
