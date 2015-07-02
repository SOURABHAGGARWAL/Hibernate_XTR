package com.xebia.training.hibernate.orm.session_factory.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xebia.training.hibernate.orm.session_factory.util.HibernateUtil;

public class HibernateSessionFactoryUsingPropertiesExample {

	public static void main(String[] args) {
		
		//Initialise Sessions
		SessionFactory sessionFactory = HibernateUtil.getSessionFactoryByProperties();
		 // Get current session
		 Session currentSession = sessionFactory.getCurrentSession();
		 // Begin transaction
		 currentSession.getTransaction().begin();
		
		 // Print out all required information
		 System.out.println("Session Is Opened :: "+currentSession.isOpen());
		 System.out.println("Session Is Connected :: "+currentSession.isConnected()); 
		
		 // Commit transaction
		 currentSession.getTransaction().commit();
		sessionFactory.close();
		
	}

}
