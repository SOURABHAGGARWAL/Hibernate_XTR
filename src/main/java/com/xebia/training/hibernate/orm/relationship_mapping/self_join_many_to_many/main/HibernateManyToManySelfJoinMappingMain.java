package com.xebia.training.hibernate.orm.relationship_mapping.self_join_many_to_many.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xebia.training.hibernate.orm.relationship_mapping.self_join_many_to_many.model.Employee;
import com.xebia.training.hibernate.orm.relationship_mapping.self_join_many_to_many.util.HibernateUtil;

public class HibernateManyToManySelfJoinMappingMain {

	public static void main(String[] args) {
		
		//Initialize Sessions
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
        Employee employee1 = new Employee("Sergey", "Brin");
        Employee employee2 = new Employee("Larry", "Page");
        Employee employee3 = new Employee("Marrisa", "Mayer");
        Employee employee4 = new Employee("Matt", "Cutts");
 
        employee1.getColleagues().add(employee3);
        employee1.getColleagues().add(employee4);
        employee2.getColleagues().add(employee4);
        employee3.getColleagues().add(employee4);
        employee4.getColleagues().add(employee1);
        employee4.getColleagues().add(employee3);
         
 
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.save(employee4);
		
		//Release resources
		transaction.commit();
		sessionFactory.close();
	}
}
