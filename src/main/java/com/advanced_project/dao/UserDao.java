/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.dao;

import com.advanced_project.interfaces.UserDaoInterface;
import com.advanced_project.domain.User;
import com.advanced_project.domain.UserRole;
import com.advanced_project.domain.UserWorkingStatus;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author regis
 */
public class UserDao implements UserDaoInterface<User>{
    private Session session;
    @Override
    public User findByUsername(String username) {
        User user;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        
        query.select(root).where(builder.equal(root.get("username"), username));
        
        Query<User> q = session.createQuery(query);
        user = q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
        return user;
    }

    @Override
    public void save(User t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(User t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        
        query.select(root);
        
        List<User> users = session.createQuery(query).list();
        session.close();
        return users;
    }

    @Override
    public User findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        User u = session.get(User.class, id);
        session.close();
        return u;
    }

    @Override
    public Set<User> findAllUsersByRoleAndWorkingStatus(UserRole userRole, UserWorkingStatus userWorkingStatus) {
        session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        
        query.select(root).where(builder.and(builder.equal(root.get("userRole"), userRole), 
                                            builder.equal(root.get("userWorkingStatus"), userWorkingStatus)));
        
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return new HashSet<>(users);
    }
    
}
