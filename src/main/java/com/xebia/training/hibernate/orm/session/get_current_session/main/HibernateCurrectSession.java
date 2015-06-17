package com.xebia.training.hibernate.orm.session.get_current_session.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xebia.training.hibernate.orm.session.get_current_session.util.HibernateUtil;
import com.xebia.training.hibernate.orm.session.get_current_session.model.Employee;
 
public class HibernateCurrectSession {
 
	  public static void main(String[] args) {
	         
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	         
	        //Current Session - no need to close
	        Session currentSession = sessionFactory.getCurrentSession();
	        
	        Transaction tx = currentSession.beginTransaction();
	        
	        //Get employee with id=1
	        Employee emp = (Employee) currentSession.load(Employee.class, new Long(1));
	        printData(emp,1);
	         
	        tx.commit();
	        
	        //close session factory
	        sessionFactory.close();
	        
	        //close session factory
	        sessionFactory.close();
	  }
	  
	    private static void printData(Employee emp, int count) {
	        System.out.println(count+":: Name="+emp.getName()+", Zipcode="+emp.getAddress().getZipcode());
	    }
 
}