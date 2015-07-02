package com.xebia.training.hibernate.orm.session_factory.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactoryByXml() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration.configure("/com/xebia/training/hibernate/orm/session_factory/resources/hibernate.cfg.xml");
        	System.out.println("Hibernate Configuration loaded");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	System.out.println("Hibernate serviceRegistry created");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
	
	private static SessionFactory buildSessionFactoryByProperties() {
        try {
        	
			// Create configuration instance
			Configuration configuration = new Configuration();
			
			// Create properties file
			Properties properties = new Properties();
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/xebia/training/hibernate/orm/session_factory/resources/hibernate.properties"));
			
			System.out.println("Hibernate propeties loaded");
			// Pass hibernate properties file
			configuration.setProperties(properties);
			
			// Since version 4.x, service registry is being used
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build(); 
			
			System.out.println("Hibernate serviceRegistry created");
			
			// Create session factory instance
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
	
	public static SessionFactory getSessionFactoryByXml() {
		if(sessionFactory == null) sessionFactory = buildSessionFactoryByXml();
        return sessionFactory;
    }
	
	public static SessionFactory getSessionFactoryByProperties() {
		if(sessionFactory == null) sessionFactory = buildSessionFactoryByProperties();
        return sessionFactory;
    }
}
