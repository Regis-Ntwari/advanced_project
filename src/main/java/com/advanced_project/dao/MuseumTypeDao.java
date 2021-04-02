/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.dao;

import com.advanced_project.interfaces.DaoInterface;
import com.advanced_project.domain.MuseumType;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author regis
 */
public class MuseumTypeDao implements DaoInterface<MuseumType>{

    private Session session;
    @Override
    public void save(MuseumType t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(MuseumType t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<MuseumType> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MuseumType> query = builder.createQuery(MuseumType.class);
        Root<MuseumType> root = query.from(MuseumType.class);
        
        query.select(root);
        
        List<MuseumType> types = session.createQuery(query).list();
        session.close();
        return types;
    }

    @Override
    public MuseumType findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        MuseumType type = session.get(MuseumType.class, id);
        session.close();
        return type;
    }
    
}
