package com.xebia.training.hibernate.orm.relationship_mapping.many_to_many.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xebia.training.hibernate.orm.relationship_mapping.many_to_many.model.Employee;
import com.xebia.training.hibernate.orm.relationship_mapping.many_to_many.model.Meeting;
import com.xebia.training.hibernate.orm.relationship_mapping.many_to_many.util.HibernateUtil;

public class HibernateManyToManyMappingMain {

	public static void main(String[] args) {
		
		//Initialize Sessions
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
        Meeting meeting1 = new Meeting("Quaterly Sales meeting");
        Meeting meeting2 = new Meeting("Weekly Status meeting");
         
        Employee employee1 = new Employee("Sergey", "Brin");
        Employee employee2 = new Employee("Larry", "Page");
 
        employee1.getMeetings().add(meeting1);
        employee1.getMeetings().add(meeting2);
        employee2.getMeetings().add(meeting1);
         
        session.save(employee1);
        session.save(employee2);
		
		//Release resources
		transaction.commit();
		sessionFactory.close();
	}
}
