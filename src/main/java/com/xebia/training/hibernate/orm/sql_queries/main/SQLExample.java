package com.xebia.training.hibernate.orm.sql_queries.main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xebia.training.hibernate.orm.sql_queries.model.Employee;
import com.xebia.training.hibernate.orm.sql_queries.util.HibernateUtil;
 
 
public class SQLExample {
 
    public static void main(String[] args) {
         
        //Prep work
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
         
        //Get All Employees
        Transaction tx = session.beginTransaction();
         
        // getting employee
        Query query = session.createSQLQuery(
        		"select * from EMPLOYEE e where e.emp_id = :id")
        		.addEntity(Employee.class)
        		.setParameter("id", 1L);
        for (Object object : query.list()) {
			System.out.println(((Employee)object).getName());
		}
        
        System.out.println("::::::::::::::::::::::::::::::::::::::");
        
        //Update Employee
        query = session.createSQLQuery("update EMPLOYEE set emp_name= :name where emp_id= :id");
        query.setParameter("name", "UTYM Kumar1111");
        query.setLong("id", 5);
        int result = query.executeUpdate();
        System.out.println("Employee Update Status="+result);
        
        System.out.println("::::::::::::::::::::::::::::::::::::::");
 
        //Delete Employee, we need to take care of foreign key constraints too
        query = session.createSQLQuery("delete from ADDRESS where emp_id= :id");
        query.setLong("id", 32);
        result = query.executeUpdate();
        System.out.println("Address Delete Status="+result);
        
        System.out.println("::::::::::::::::::::::::::::::::::::::");
        
        //create Employee
        query = session.createSQLQuery("INSERT INTO EMPLOYEE (emp_name, emp_salary) VALUES (:name, :salary)");
        query.setParameter("name", "UTYM Kumar1444");
        query.setParameter("salary", 80000);
        result = query.executeUpdate();
        System.out.println("Employee Update Status="+result);
        
        System.out.println("::::::::::::::::::::::::::::::::::::::");

        //rolling back to save the test data
        tx.commit();
         
        //closing hibernate resources
        sessionFactory.close();
    }
 
}