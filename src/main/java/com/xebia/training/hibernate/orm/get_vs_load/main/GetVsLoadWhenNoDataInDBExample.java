package com.xebia.training.hibernate.orm.get_vs_load.main;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xebia.training.hibernate.orm.get_vs_load.model.Employee;
import com.xebia.training.hibernate.orm.get_vs_load.util.HibernateUtil;


public class GetVsLoadWhenNoDataInDBExample {
	
	  public static void main(String[] args) {
	         
	        //Prep Work
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	         

			try{
				Employee emp = (Employee) session.get(Employee.class, new Long(200));
				System.out.println("Employee get called");
				if(emp != null){
					System.out.println("Employee GET ID= "+emp.getId());
					System.out.println("Employee Get Details:: "+emp+"\n");
				}
			}catch(Exception e){
			    e.printStackTrace();
			} 
			//load Example
			try{
				Employee emp1 = (Employee) session.load(Employee.class, new Long(100));
				System.out.println("Employee load called");
				System.out.println("Employee LOAD ID= "+emp1.getId());
				System.out.println("Employee load Details:: "+emp1+"\n");
			}catch(Exception e){
			    e.printStackTrace();
			}
				         
	        //Close resources
	        tx.commit();
	        sessionFactory.close();
	  }
	
}