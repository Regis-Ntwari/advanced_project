/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.dao;

import com.advanced_project.interfaces.DaoInterface;
import com.advanced_project.domain.VisitationStatus;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author regis
 */
public class VisitationStatusDao implements DaoInterface<VisitationStatus>{

    private Session session;
    @Override
    public void save(VisitationStatus t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(VisitationStatus t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<VisitationStatus> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<VisitationStatus> query = builder.createQuery(VisitationStatus.class);
        Root<VisitationStatus> root = query.from(VisitationStatus.class);
        
        query.select(root);
        List<VisitationStatus> report = session.createQuery(query).getResultList();
        session.close();
        return report;
    }

    @Override
    public VisitationStatus findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        VisitationStatus status = session.get(VisitationStatus.class, id);
        session.close();
        return status;
    }
    
}
