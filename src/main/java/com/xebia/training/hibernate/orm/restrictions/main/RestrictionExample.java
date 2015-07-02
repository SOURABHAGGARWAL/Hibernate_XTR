package com.xebia.training.hibernate.orm.restrictions.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.xebia.training.hibernate.orm.restrictions.model.Employee;
import com.xebia.training.hibernate.orm.restrictions.util.HibernateUtil;
 
 
public class RestrictionExample {
 
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
         
        //Prep work
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
         
        //Get All Employees
        Transaction tx = session.beginTransaction();

        Criteria criteriaEq = session.createCriteria(Employee.class).add(Restrictions.eq("name", "suggen"));
        List<Employee> resultsEq = criteriaEq.list();
        for (Employee employee : resultsEq) {
        	 System.out.println(employee.getName() + " ::::::::::::::: " +employee.getSalary());
		}
        
        Criteria criteriaLt = session.createCriteria(Employee.class).add(Restrictions.lt("salary", 10000));
        List<Employee> resultsLt = criteriaLt.list();
        for (Employee employee : resultsLt) {
        	 System.out.println(employee.getName() + " ::::::::::::::: " +employee.getSalary());
		}
        
        Criteria criteriaPagination = session.createCriteria(Employee.class);
	        criteriaPagination.setMaxResults(10);
	        criteriaPagination.setFirstResult(20);
        List<Employee> resultsPagination = criteriaPagination.list();
        for (Employee employee : resultsPagination) {
        	 System.out.println(employee.getName() + " ::::::::::::::: " +employee.getSalary());
		}
        
        //rolling back to save the test data
        tx.rollback();
         
        //closing hibernate resources
        sessionFactory.close();
    }
 
}