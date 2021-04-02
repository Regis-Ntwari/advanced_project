/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.dao;

import com.advanced_project.interfaces.DaoInterface;
import com.advanced_project.interfaces.VisitationDaoInterface;
import com.advanced_project.domain.Museum;
import com.advanced_project.domain.Visitation;
import com.advanced_project.domain.VisitationOccurrenceStatus;
import com.advanced_project.domain.VisitationRequestStatus;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author regis
 */
public class VisitationDao implements VisitationDaoInterface<Visitation>{

    private Session session;
    @Override
    public void save(Visitation t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Visitation t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Visitation> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Visitation> visits = session.createQuery("from VIsitation").list();
        session.close();
        return visits;
    }

    @Override
    public Visitation findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Visitation visit = session.get(Visitation.class, id);
        session.close();
        return visit;
    }
    @Override
    public List<Visitation> findAllVisitationsByRequestStatus(VisitationRequestStatus vrs, Museum museum){
        List<Visitation> visits = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Visitation> query = builder.createQuery(Visitation.class);
            Root<Visitation> root = query.from(Visitation.class);
            
            query.select(root).where(builder.and(builder.equal(root.get("requestStatus"), vrs), 
                                                builder.equal(root.get("museum"), museum)));
            query.select(root).where(builder.equal(root.get("requestStatus"), vrs));
            Query<Visitation> q = session.createQuery(query);
            visits = q.list();
            
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return visits;
    }
    @Override
    public List<Visitation> findAllVisitationByOccurrenceStatus(VisitationOccurrenceStatus vos, Museum museum){
        List<Visitation> visits = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Visitation> query = builder.createQuery(Visitation.class);
            Root<Visitation> root = query.from(Visitation.class);
            
            query.select(root).where(builder.and(builder.equal(root.get("museum"), museum), 
                                                builder.equal(root.get("occurrenceStatus"), vos)));
            Query<Visitation> q = session.createQuery(query);
            
            visits = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return visits;
    }
    @Override
    public List<Visitation> findAllTodayVisitation(Museum museum){
        List<Visitation> visits = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Visitation> query = builder.createQuery(Visitation.class);
            Root<Visitation> root = query.from(Visitation.class);
            
            query.select(root).where(builder.and(builder.equal(root.get("museum"), museum), 
                                                builder.equal(root.get("visitationDate"), LocalDate.now())));
            Query<Visitation> q = session.createQuery(query);
            
            visits = q.list();
            
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return visits;
    } 
}
