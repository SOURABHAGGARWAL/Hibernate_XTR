package com.xebia.training.hibernate.orm.session_factory.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xebia.training.hibernate.orm.session_factory.util.HibernateUtil;

public class HibernateSessionFactoryUsingXmlExample {

	public static void main(String[] args) {
		
		//Initialise Sessions
		SessionFactory sessionFactory = HibernateUtil.getSessionFactoryByXml();
		 // Get current session
		 Session session = sessionFactory.getCurrentSession();
		 // Begin transaction
		 session.getTransaction().begin();
		
		 // Print out all required information
		 System.out.println("Session Is Opened :: "+session.isOpen());
		 System.out.println("Session Is Connected :: "+session.isConnected()); 
		
		 // Commit transaction
		 session.getTransaction().commit();
		sessionFactory.close();
	}

}
