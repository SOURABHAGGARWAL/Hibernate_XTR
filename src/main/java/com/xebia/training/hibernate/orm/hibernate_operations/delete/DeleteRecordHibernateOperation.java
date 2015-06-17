package com.xebia.training.hibernate.orm.hibernate_operations.delete;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xebia.training.hibernate.orm.hibernate_operations.model.Employee;
import com.xebia.training.hibernate.orm.hibernate_operations.util.HibernateUtil;

public class DeleteRecordHibernateOperation {
	
	public static void main(String args[]) {
		
		SessionFactory sessionFactory = null;
		
		Session session = null;
		
		Transaction transaction = null;
		
		try{
			// getting session factory
			sessionFactory = HibernateUtil.getSessionFactory();
			
			// getting the current operation
			session = sessionFactory.getCurrentSession();
			
			// Transaction is necessary for the save, update operation
			transaction = session.beginTransaction();
			
			// getting employee to be deleted
			Employee employee = (Employee) session.load(Employee.class, 2l);
			
			// hibernate delete operation
			session.delete(employee);
			
			//int i= 1/0;
			// transaction commit is necessary to save changes
			transaction.commit();
		}catch(Exception e){
			//transaction.rollback();
		}finally{
			//session.close();
			sessionFactory.close();
		}
	}

}
