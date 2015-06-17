package com.xebia.training.hibernate.orm.named_queries.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xebia.training.hibernate.orm.named_queries.model.Employee;
import com.xebia.training.hibernate.orm.named_queries.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class HibernateNamedQueryExample {

	public static void main(String[] args) throws InterruptedException {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();

			Query query = session.getNamedQuery("findEmployeeByName").setString("name", "sourabh");
			List<Employee> results = query.list();
			System.out.println("No of Results: " + results.size());
			for (Employee employee : results) {
				printData(employee);
			}
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			//Example get employee from XML
			query = session.getNamedQuery("HQL_GET_ALL_EMPLOYEE");
			results = query.list();
			for (Employee employee : results) {
				printData(employee);
			}
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			//Example get employee from XML
			query = session.getNamedQuery("HQL_GET_EMPLOYEE_BY_ID").setInteger("id", 1);
			results = query.list();
			for (Employee employee : results) {
				printData(employee);
			}
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			//Example get employee from XML
			query = session.getNamedQuery("HQL_GET_EMPLOYEE_BY_SALARY").setDouble("salary", 1000);
			results = query.list();
			for (Employee employee : results) {
				printData(employee);
			}
	        
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.flush();
			session.close();
			sessionFactory.close();
		}
	}

	private static void printData(Employee emp) {
		System.out.println("Name=" + emp.getName() + ", Zipcode="
				+ emp.getAddress().getZipcode());
	}

}