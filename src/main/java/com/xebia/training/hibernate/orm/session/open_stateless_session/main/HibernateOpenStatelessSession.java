package com.xebia.training.hibernate.orm.session.open_stateless_session.main;

import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import com.xebia.training.hibernate.orm.session.open_stateless_session.model.Employee;
import com.xebia.training.hibernate.orm.session.open_stateless_session.util.HibernateUtil;
 
public class HibernateOpenStatelessSession {
 
	  public static void main(String[] args) {
	         
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	         
	        //open stateless session
	        StatelessSession statelessSession = sessionFactory.openStatelessSession();
	        Transaction tx=statelessSession.beginTransaction();
	        //Get employee with id=1
	        //Employee emp = (Employee) statelessSession.load(Employee.class, new Long(1));
	        Employee emp = (Employee) statelessSession.get(Employee.class, new Long(1));
	        printData(emp,1);
	        tx.commit();
	         
	        //close session
	        statelessSession.close();
	         
	        //close session factory
	        sessionFactory.close();
	  }
	  
	    private static void printData(Employee emp, int count) {
	        System.out.println(count+":: Name="+emp.getName());
	        System.out.println("Zipcode="+emp.getAddress().getZipcode());
	    }
 
 
}