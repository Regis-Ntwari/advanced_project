/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.dao;

import com.advanced_project.interfaces.VisitorDaoInterface;
import com.avanced_project.domain.Visitor;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author regis
 */
public class VisitorDao implements VisitorDaoInterface<Visitor>{

    private Session session;
    @Override
    public Visitor findByUsername(String username) {
        session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Visitor> query = builder.createQuery(Visitor.class);
        Root<Visitor> root = query.from(Visitor.class);
        
        query.select(root).where(builder.equal(root.get("username"), username));
        
        Visitor visitor = session.createQuery(query).getSingleResult();
        session.close();
        return visitor;
    }

    @Override
    public void save(Visitor t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Visitor t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Visitor> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Visitor> query = builder.createQuery(Visitor.class);
        Root<Visitor> root = query.from(Visitor.class);
        
        query.select(root);
        
        List<Visitor> visitors = session.createQuery(query).list();
        session.close();
        return visitors;
    }

    @Override
    public Visitor findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Visitor visitor = session.get(Visitor.class, id);
        session.close();
        return visitor;
    }
    
}
