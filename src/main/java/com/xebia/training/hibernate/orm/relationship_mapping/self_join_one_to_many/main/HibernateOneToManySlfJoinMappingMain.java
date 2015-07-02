package com.xebia.training.hibernate.orm.relationship_mapping.self_join_one_to_many.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xebia.training.hibernate.orm.relationship_mapping.self_join_one_to_many.model.Employee;
import com.xebia.training.hibernate.orm.relationship_mapping.self_join_one_to_many.util.HibernateUtil;

public class HibernateOneToManySlfJoinMappingMain {

	public static void main(String[] args) {
		
		//Initialize Sessions
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
	    Employee manager1 = new Employee("Chuck", "Norris");
	         
        Employee employee1 = new Employee("Sergey", "Brin");
        Employee employee2 = new Employee("Larry", "Page");
 
        employee1.setManager(manager1);
        employee2.setManager(manager1);
         
        session.save(employee1);
        session.save(employee2);
		
		//Release resources
		transaction.commit();
		sessionFactory.close();
	}
}
