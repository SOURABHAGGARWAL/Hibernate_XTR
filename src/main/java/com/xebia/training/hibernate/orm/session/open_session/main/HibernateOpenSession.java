package com.xebia.training.hibernate.orm.session.open_session.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xebia.training.hibernate.orm.session.open_session.model.Employee;
import com.xebia.training.hibernate.orm.session.open_session.util.HibernateUtil;
 
public class HibernateOpenSession {
 
	  public static void main(String[] args) {
	         
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        
	        //open new session
	        Session session = sessionFactory.openSession();
	        
	        //Get employee with id=1
	        Employee emp = (Employee) session.load(Employee.class, new Long(1));
	        printData(emp,1);
	         
	        //close session
	        session.close();
	         
	        //close session factory
	        sessionFactory.close();
	  }
	  
	    private static void printData(Employee emp, int count) {
	        System.out.println(count+":: Name="+emp.getName()+", Zipcode="+emp.getAddress().getZipcode());
	    }
 
}