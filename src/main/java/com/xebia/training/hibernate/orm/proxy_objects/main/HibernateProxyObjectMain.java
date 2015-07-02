package com.xebia.training.hibernate.orm.proxy_objects.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xebia.training.hibernate.orm.proxy_objects.model.Department;
import com.xebia.training.hibernate.orm.proxy_objects.model.Employee;
import com.xebia.training.hibernate.orm.proxy_objects.util.HibernateUtil;

public class HibernateProxyObjectMain {

	public static void main(String[] args) {
		
		//Initialize Sessions
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
        Department department = new Department();
        department.setDepartmentName("Sales");
        session.save(department);
         
        Employee emp1 = new Employee("Nina", "Mayers", "111");
        Employee emp2 = new Employee("Tony", "Almeida", "222");
 
        emp1.setDepartment(department);
        emp2.setDepartment(department);
         
        session.save(emp1);
        session.save(emp2);
        
        List<Employee> employees = session.createQuery("from Employee").list();
        	for (Employee employee : employees) {
				System.out.println(employee.getFirstname() + " :::::::::: " + employee.getLastname() + " :::::::::: " + employee.getDepartment().getDepartmentId() + " :::::::::: " + employee.getDepartment().getDepartmentName());
		}
		//Release resources
		transaction.commit();
		sessionFactory.close();
		
	}
}
