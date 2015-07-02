package com.xebia.training.hibernate.orm.relationship_mapping.one_to_one.main;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xebia.training.hibernate.orm.relationship_mapping.one_to_one.util.HibernateUtil;
import com.xebia.training.hibernate.orm.relationship_mapping.one_to_one.model.Employee;
import com.xebia.training.hibernate.orm.relationship_mapping.one_to_one.model.EmployeeDetail;

public class HibernateOneToOneMappingMain {

	public static void main(String[] args) {
		
		//Initialize Sessions
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
        EmployeeDetail employeeDetail = new EmployeeDetail("10th Street", "LA", "San Francisco", "U.S.");
        
        Employee employee = new Employee("Nina", "Mayers", new Date(), "114-857-965");
        employee.setEmployeeDetail(employeeDetail);
        employeeDetail.setEmployee(employee);
         
        session.save(employee);
         
        List<Employee> employees = session.createQuery("from Employee").list();
        for (Employee employee1 : employees) {
            System.out.println(employee1.getFirstname() + " , "
                    + employee1.getLastname() + ", "
                    + employee1.getEmployeeDetail().getState());
        }
		
		//Release resources
		transaction.commit();
		sessionFactory.close();
	}
}
