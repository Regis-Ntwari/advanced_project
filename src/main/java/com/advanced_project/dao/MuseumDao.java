/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.dao;

import com.avanced_project.domain.Museum;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author regis
 */
public class MuseumDao implements DaoInterface<Museum>{

    private Session session;
    @Override
    public void save(Museum t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Museum t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Museum> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Museum> museums = session.createQuery("from Museum").list();
        session.close();
        return museums;
    }

    @Override
    public Museum findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Museum museum = session.get(Museum.class, id);
        session.close();
        return museum;
    }
    
}
