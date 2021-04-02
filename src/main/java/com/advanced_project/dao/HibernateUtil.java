package com.advanced_project.dao;


import com.advanced_project.domain.Museum;
import com.advanced_project.domain.MuseumStatusTrack;
import com.advanced_project.domain.MuseumType;
import com.advanced_project.domain.Person;
import com.advanced_project.domain.User;
import com.advanced_project.domain.UserStatus;
import com.advanced_project.domain.Visitation;
import com.advanced_project.domain.VisitationStatus;
import com.advanced_project.domain.Visitor;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author regis
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try {
                Configuration configuration = new Configuration();
                
                //Hibernate Settings
                
                Properties settings = new Properties();
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/advanced_project");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "postgres");
                settings.put(Environment.HBM2DDL_AUTO, "update");
                
                //showing SQL queries and formatting SQL
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL, "true");
                
                //setting our properties to our configuration
                
                configuration.setProperties(settings);
                
                // adding our classes to our configuration
                
                configuration.addAnnotatedClass(MuseumType.class);
                configuration.addAnnotatedClass(Museum.class);
                configuration.addAnnotatedClass(Visitor.class);
                configuration.addAnnotatedClass(Visitation.class);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(VisitationStatus.class);
                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(UserStatus.class);
                configuration.addAnnotatedClass(MuseumStatusTrack.class);
                
                sessionFactory = configuration.buildSessionFactory();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
