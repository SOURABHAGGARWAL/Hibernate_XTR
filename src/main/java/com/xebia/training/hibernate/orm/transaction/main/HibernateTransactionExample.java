package com.xebia.training.hibernate.orm.transaction.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xebia.training.hibernate.orm.transaction.model.Address;
import com.xebia.training.hibernate.orm.transaction.model.Employee;
import com.xebia.training.hibernate.orm.transaction.util.HibernateUtil;

public class HibernateTransactionExample {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		Session session = null;  
		Transaction tx = null;
		//UserTransaction tx = null;
		
		try {  
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession(); 
		
		// No  need of transaction for get ioperation
		Employee emp = (Employee) session.get(Employee.class, 1L);
		System.out.println(emp.getId() + " ::::::::::: " + emp.getName() + " ::::::::::::::: " + emp.getAddress().getCity());
		
		tx = session.beginTransaction(); 
		//tx = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
		
		// save operation required transaction id any excception occured while single transaction  then whole of the transaction is rollback
		Employee employee = new Employee();
		employee.setName("1234 New Record");
		employee.setSalary(7000);
		Address address = new Address();
		address.setAddressLine1("New Addreess");
		address.setCity("Gurgaon");
		address.setZipcode("234567");
		address.setEmployee(employee);
		employee.setAddress(address);
		
		// hibernate save operation for saving data
		session.save(employee);
		
		
/*		Employee employeeUpdate = new Employee();
		employee.setId(20L);
		employeeUpdate.setName("11 New Record");
		employeeUpdate.setSalary(7000);
		Address addressUpdate = new Address();
		addressUpdate.setAddressLine1("NEw Addreess");
		addressUpdate.setCity("Gurgaon");
		addressUpdate.setZipcode("12103");
		addressUpdate.setEmployee(employeeUpdate);
		employee.setAddress(addressUpdate);
		
		// hibernate save operation for saving data
		session.update(employeeUpdate);*/
		
		tx.commit();  
		
		// second transaction don't belong to first transaction any exception in second don't effect first
/*		tx = session.beginTransaction(); 
		
		Employee employeeUpdate = new Employee();
		employee.setId(20L);
		employeeUpdate.setName("11 New Record");
		employeeUpdate.setSalary(7000);
		Address addressUpdate = new Address();
		addressUpdate.setAddressLine1("NEw Addreess");
		addressUpdate.setCity("Gurgaon");
		addressUpdate.setZipcode("12103");
		addressUpdate.setEmployee(employeeUpdate);
		employee.setAddress(addressUpdate);
		
		// hibernate save operation for saving data
		session.update(employeeUpdate);
		tx.commit();*/
		
		}catch (Exception ex) {  
			ex.printStackTrace();  
			tx.rollback();  
		}  
		finally {
			session.close();
			sessionFactory.close();
		}  
	
	}

}
