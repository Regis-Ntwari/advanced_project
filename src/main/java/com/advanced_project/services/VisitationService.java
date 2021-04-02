/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.services;

import com.advanced_project.utils.EmailUtil;
import com.advanced_project.domain.Museum;
import com.advanced_project.domain.Visitation;
import com.advanced_project.domain.VisitationOccurrenceStatus;
import com.advanced_project.domain.VisitationRequestStatus;
import com.advanced_project.domain.Visitor;
import com.advanced_project.interfaces.DaoInterface;
import com.advanced_project.dao.MuseumDao;
import com.advanced_project.dao.UserDao;
import com.advanced_project.interfaces.UserDaoInterface;
import com.advanced_project.dao.VisitationDao;
import com.advanced_project.dao.VisitationStatusDao;
import com.advanced_project.dao.VisitorDao;
import com.advanced_project.interfaces.VisitorDaoInterface;
import com.advanced_project.domain.User;
import com.advanced_project.domain.VisitationStatus;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author regis
 */
public class VisitationService {

    private final VisitationDao visitationDao = new VisitationDao();
    private final VisitorDaoInterface visitorDao = new VisitorDao();
    private final DaoInterface museumDao = new MuseumDao();
    private final DaoInterface visitationStatusDao = new VisitationStatusDao();
    private final UserDaoInterface userDao = new UserDao();

    public void visit(int visitorId, int museumId, LocalDate visitationDate) {
        Visitor visitor = (Visitor) visitorDao.findById(visitorId);
        Museum museum = (Museum) museumDao.findById(museumId);

        Visitation visit = new Visitation();
        visit.setMuseum(museum);
        visit.setVisitor(visitor);
        visit.setVisitationDate(visitationDate);
        visit.setVisitationRequestDate(LocalDate.now());
        visit.setRequestStatus(VisitationRequestStatus.PENDING);
        visit.setOccurrenceStatus(VisitationOccurrenceStatus.NOT_OCCURRED);

        visitationDao.save(visit);
        if (!visit.getVisitor().getEmail().equalsIgnoreCase("")) {
            EmailUtil.sendApprovalEmail(visit);

        }
        visitationStatusDao.save(
                new VisitationStatus(
                        visit, 
                        visitor, 
                        visit.getOccurrenceStatus(), 
                        visit.getRequestStatus(), 
                        LocalDate.now()));
    }

    public void cancelByUserVisitation(int userId,int visitationId) {
        Visitation visit = visitationDao.findById(visitationId);
        User user = (User) userDao.findById(userId);
        visit.setRequestStatus(VisitationRequestStatus.CANCELLED);
        visitationDao.update(visit);
        if (!visit.getVisitor().getEmail().equalsIgnoreCase("")) {
            EmailUtil.sendApprovalEmail(visit);

        }
        visitationStatusDao.save(
                new VisitationStatus(
                        visit, 
                        user, 
                        visit.getOccurrenceStatus(), 
                        visit.getRequestStatus(), 
                        LocalDate.now()));
    }
    public void cancelByVisitorVisitation(int visitorId,int visitationId) {
        Visitation visit = visitationDao.findById(visitationId);
        Visitor visitor = (Visitor) userDao.findById(visitorId);
        visit.setRequestStatus(VisitationRequestStatus.CANCELLED);
        visitationDao.update(visit);
        if (!visit.getVisitor().getEmail().equalsIgnoreCase("")) {
            EmailUtil.sendApprovalEmail(visit);

        }
        visitationStatusDao.save(
                new VisitationStatus(
                        visit, 
                        visitor, 
                        visit.getOccurrenceStatus(), 
                        visit.getRequestStatus(), 
                        LocalDate.now()));
    }

    public void approveVisitation(int userId, int visitationId) {
        Visitation visit = visitationDao.findById(visitationId);
        User user = (User) userDao.findById(userId);
        visit.setRequestStatus(VisitationRequestStatus.APPROVED);
        visitationDao.update(visit);
        if (!visit.getVisitor().getEmail().equalsIgnoreCase("")) {
            EmailUtil.sendApprovalEmail(visit);

        }
        visitationStatusDao.save(
                new VisitationStatus(
                        visit, 
                        user, 
                        visit.getOccurrenceStatus(), 
                        visit.getRequestStatus(), 
                        LocalDate.now()));
    }

    public void occurVisitation(int userId, int visitationId) {
        Visitation visit = visitationDao.findById(visitationId);
        User user = (User) userDao.findById(userId);
        visit.setOccurrenceStatus(VisitationOccurrenceStatus.OCCURRED);
        visitationDao.update(visit);
        visitationStatusDao.save(
                new VisitationStatus(
                        visit, 
                        user, 
                        visit.getOccurrenceStatus(), 
                        visit.getRequestStatus(), 
                        LocalDate.now()));
    }

    public List<Visitation> findAllTodayVisitation(int museumId) {
        Museum m = (Museum) museumDao.findById(museumId);
        return visitationDao.findAllTodayVisitation(m);
    }

    public List<Visitation> findAllPendingVisitation(int museumId) {
        Museum m = (Museum) museumDao.findById(museumId);
        return visitationDao.findAllVisitationsByRequestStatus(VisitationRequestStatus.PENDING, m);
    }

    public List<Visitation> findAllApprovedVisitation(int museumId) {
        Museum m = (Museum) museumDao.findById(museumId);
        return visitationDao.findAllVisitationsByRequestStatus(VisitationRequestStatus.APPROVED, m);
    }

    public List<Visitation> findAllCancelledVisitation(int museumId) {
        Museum m = (Museum) museumDao.findById(museumId);
        return visitationDao.findAllVisitationsByRequestStatus(VisitationRequestStatus.CANCELLED, m);
    }

    public List<Visitation> findAllNonOccurredVisitation(int museumId) {
        Museum m = (Museum) museumDao.findById(museumId);
        return visitationDao.findAllVisitationByOccurrenceStatus(VisitationOccurrenceStatus.NOT_OCCURRED, m);
    }

    public List<Visitation> findAllOccurredVisitation(int museumId) {
        Museum m = (Museum) museumDao.findById(museumId);
        return visitationDao.findAllVisitationByOccurrenceStatus(VisitationOccurrenceStatus.OCCURRED, m);
    }
}
