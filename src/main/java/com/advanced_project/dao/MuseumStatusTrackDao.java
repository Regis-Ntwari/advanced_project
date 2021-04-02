/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.dao;

import com.advanced_project.domain.MuseumStatusTrack;
import com.advanced_project.interfaces.DaoInterface;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author regis
 */
public class MuseumStatusTrackDao implements DaoInterface<MuseumStatusTrack>{

    private Session session;
    @Override
    public void save(MuseumStatusTrack t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(MuseumStatusTrack t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<MuseumStatusTrack> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MuseumStatusTrack> query = builder.createQuery(MuseumStatusTrack.class);
        Root<MuseumStatusTrack> root = query.from(MuseumStatusTrack.class);
        
        query.select(root);
        List<MuseumStatusTrack> allTracks = session.createQuery(query).getResultList();
        session.close();
        return allTracks;
    }

    @Override
    public MuseumStatusTrack findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        MuseumStatusTrack track = session.get(MuseumStatusTrack.class, id);
        session.close();
        return track;
    }
    
}
