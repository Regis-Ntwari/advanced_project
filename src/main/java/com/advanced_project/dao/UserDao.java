/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.dao;

import com.avanced_project.domain.Admin;
import com.avanced_project.domain.Staff;
import com.avanced_project.domain.User;
import com.avanced_project.domain.Visitor;
import java.util.List;
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
        List<User> users = session.createQuery("from User").list();
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
    public List<User> findAllStaff() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from Staff").list();
        session.close();
        return users;
    }
    public User findByStaffId(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        Staff u = session.get(Staff.class, id);
        session.close();
        return u;
    }
    public User findByVisitorId(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        Visitor visitor = session.get(Visitor.class, id);
        session.close();
        return visitor;
    }
    public Staff findStaffByUsername(String username){
        session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Staff> query = builder.createQuery(Staff.class);
        Root<Staff> root = query.from(Staff.class);
        
        query.select(root).where(builder.equal(root.get("username"), username));
        return session.createQuery(query).getSingleResult();
    }
    public Visitor findVisitorByUsername(String username){
        session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Visitor> query = builder.createQuery(Visitor.class);
        Root<Visitor> root = query.from(Visitor.class);
        
        query.select(root).where(builder.equal(root.get("username"), username));
        return session.createQuery(query).getSingleResult();
    }
    public Admin findAdminByUsername(String username){
        session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> query = builder.createQuery(Admin.class);
        Root<Admin> root = query.from(Admin.class);
        
        query.select(root).where(builder.equal(root.get("username"), username));
        return session.createQuery(query).getSingleResult();
    }
    
    
}
