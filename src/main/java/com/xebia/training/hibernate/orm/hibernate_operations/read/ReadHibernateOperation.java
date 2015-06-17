package com.xebia.training.hibernate.orm.hibernate_operations.read;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xebia.training.hibernate.orm.get_vs_load.model.Employee;
import com.xebia.training.hibernate.orm.get_vs_load.util.HibernateUtil;


public class ReadHibernateOperation {
	
	  public static void main(String[] args) {
	         
	        //Prep Work
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	         
	        //Get Example
	        Employee emp = (Employee) session.get(Employee.class, new Long(2));
	        System.out.println("Employee get called");
	        System.out.println("Employee ID= "+emp.getId());
	        System.out.println("Employee Get Details:: "+emp+"\n");
	         
	        //load Example
	        Employee emp1 = (Employee) session.load(Employee.class, new Long(1));
	        System.out.println("Employee load called");
	        System.out.println("Employee ID= "+emp1.getId());
	        System.out.println("Employee load Details:: "+emp1+"\n");
	         
	        //Close resources
	        tx.commit();
	        sessionFactory.close();
	  }
	
}