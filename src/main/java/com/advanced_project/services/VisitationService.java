/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.services;

import com.avanced_project.domain.Museum;
import com.avanced_project.domain.Visitation;
import com.avanced_project.domain.VisitationOccurrenceStatus;
import com.avanced_project.domain.VisitationRequestStatus;
import com.avanced_project.domain.Visitor;
import com.pupa.advanced_project.dao.DaoInterface;
import com.pupa.advanced_project.dao.MuseumDao;
import com.pupa.advanced_project.dao.UserDao;
import com.pupa.advanced_project.dao.UserDaoInterface;
import com.pupa.advanced_project.dao.VisitationDao;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author regis
 */
public class VisitationService {

    private final VisitationDao visitationDao = new VisitationDao();
    private final UserDaoInterface visitorDao = new UserDao();
    private final DaoInterface<Museum> museumDao = new MuseumDao();

    public void visit(int visitorId, int museumId, LocalDate visitationDate) {
        Visitor visitor = (Visitor) visitorDao.findById(visitorId);
        Museum museum = museumDao.findById(museumId);

        Visitation visit = new Visitation();
        visit.setMuseum(museum);
        visit.setVisitor(visitor);
        visit.setVisitationDate(visitationDate);
        visit.setVisitationRequestDate(LocalDate.now());
        visit.setRequestStatus(VisitationRequestStatus.PENDING);
        visit.setOccurrenceStatus(VisitationOccurrenceStatus.NOT_OCCURRED);

        visitationDao.save(visit);
    }

    public void cancelVisitation(int visitationId) {
        Visitation visit = visitationDao.findById(visitationId);
        visit.setRequestStatus(VisitationRequestStatus.CANCELLED);
        visitationDao.update(visit);
    }

    public void approveVisitation(int visitationId) {
        Visitation visit = visitationDao.findById(visitationId);
        visit.setRequestStatus(VisitationRequestStatus.APPROVED);
        visitationDao.update(visit);
    }

    public void occurVisitation(int visitationId) {
        Visitation visit = visitationDao.findById(visitationId);
        visit.setOccurrenceStatus(VisitationOccurrenceStatus.OCCURRED);
        visitationDao.update(visit);
    }

    public List<Visitation> findAllVisitationOfCertainMuseum(int museumId) {
        Museum m = museumDao.findById(museumId);
        List<Visitation> visits = visitationDao.findAllMuseumVisitation(m);
        return visits;
    }

    public List<Visitation> findAllTodayVisitation() {
        return visitationDao.findAllTodayVisitation();
    }

    public List<Visitation> findAllPendingVisitation() {
        return visitationDao.findAllVisitationsByRequestStatus(VisitationRequestStatus.PENDING);
    }

    public List<Visitation> findAllApprovedVisitation() {
        return visitationDao.findAllVisitationsByRequestStatus(VisitationRequestStatus.APPROVED);
    }

    public List<Visitation> findAllCancelledVisitation() {
        return visitationDao.findAllVisitationsByRequestStatus(VisitationRequestStatus.CANCELLED);
    }

    public List<Visitation> findAllNonOccurredVisitation() {
        return visitationDao.findAllVisitationByOccurrenceStatus(VisitationOccurrenceStatus.NOT_OCCURRED);
    }

    public List<Visitation> findAllOccurredVisitation() {
        return visitationDao.findAllVisitationByOccurrenceStatus(VisitationOccurrenceStatus.OCCURRED);
    }
}
