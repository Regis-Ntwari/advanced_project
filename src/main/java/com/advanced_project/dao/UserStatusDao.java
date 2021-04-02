/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.dao;

import com.advanced_project.interfaces.DaoInterface;
import com.advanced_project.domain.UserStatus;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author regis
 */
public class UserStatusDao implements DaoInterface<UserStatus>{
    private Session session;

    @Override
    public void save(UserStatus t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(UserStatus t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<UserStatus> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserStatus> query = builder.createQuery(UserStatus.class);
        Root<UserStatus> root = query.from(UserStatus.class);
        
        query.select(root);
        
        List<UserStatus> report = session.createQuery(query).getResultList();
        session.close();
        return report;
    }

    @Override
    public UserStatus findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        UserStatus report = session.get(UserStatus.class, id);
        session.close();
        return report;
    }
    
}
