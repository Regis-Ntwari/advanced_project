package com.advanced_project.dao;


import com.avanced_project.domain.Admin;
import com.avanced_project.domain.Museum;
import com.avanced_project.domain.MuseumType;
import com.avanced_project.domain.Staff;
import com.avanced_project.domain.User;
import com.avanced_project.domain.Visitation;
import com.avanced_project.domain.Visitor;
import java.util.Properties;
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
        if(sessionFactory != null){
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
                
                configuration.addAnnotatedClass(Admin.class);
                configuration.addAnnotatedClass(Staff.class);
                configuration.addAnnotatedClass(MuseumType.class);
                configuration.addAnnotatedClass(Museum.class);
                configuration.addAnnotatedClass(Visitor.class);
                configuration.addAnnotatedClass(Visitation.class);
                configuration.addAnnotatedClass(User.class);
                
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
