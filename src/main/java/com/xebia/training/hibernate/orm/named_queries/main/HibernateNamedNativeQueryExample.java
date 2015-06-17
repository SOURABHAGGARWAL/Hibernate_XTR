package com.xebia.training.hibernate.orm.named_queries.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xebia.training.hibernate.orm.named_queries.model.Address;
import com.xebia.training.hibernate.orm.named_queries.model.Employee;
import com.xebia.training.hibernate.orm.named_queries.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class HibernateNamedNativeQueryExample {

	public static void main(String[] args) throws InterruptedException {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();

			Query query = session.getNamedQuery("findEmployeeByNameNativeSQL").setString("name", "sourabh");
			List<Employee> results = query.list();
			System.out.println("No of Results: " + results.size());
			for (Employee employee : results) {
				printData(employee);
			}
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			//Example get employee from XML
			query = session.getNamedQuery("SQL_GET_ALL_EMPLOYEE");
			List<Object[]> addressObjArray = query.list();
	        for(Object[] row : addressObjArray){
	            for(Object obj : row){
	                System.out.print(obj + "::");
	            }
	            System.out.println("\n");
	        }
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			//Example get employee from XML
			query = session.getNamedQuery("SQL_GET_ALL_EMP_ADDRESS");
			addressObjArray = query.list();
	        for(Object[] row : addressObjArray){
	            Employee e = (Employee) row[0];
	            System.out.println("Employee Info::"+e);
	            Address a = (Address) row[1];
	            System.out.println("Address Info::"+a);
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