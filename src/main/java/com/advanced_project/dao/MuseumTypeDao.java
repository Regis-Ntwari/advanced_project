/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.dao;

import com.avanced_project.domain.MuseumType;
import java.util.List;
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
        List<MuseumType> types = session.createQuery("from MuseumType").list();
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
