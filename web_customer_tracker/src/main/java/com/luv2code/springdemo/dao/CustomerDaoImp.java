package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImp implements CustomerDao {

@Autowired	
private SessionFactory sessionfactory;

//@Transactional
	public List<Customer> getCustomers() {
		
	Session session=sessionfactory.getCurrentSession();
	
	Query<Customer> query=session.createQuery("from Customer order by lastname",Customer.class);
	
		return query.getResultList();
	}

	public void saveCustomer(Customer thecustomer) {
		Session session=sessionfactory.getCurrentSession();
		
		session.save(thecustomer);
		
	}

	public void UpdateCustomer(Customer thecustomer) {
		Session session=sessionfactory.getCurrentSession();
		session.saveOrUpdate(thecustomer);
		
	}

	public void deleteCustomer(Customer thecustomer) {
		Session session=sessionfactory.getCurrentSession();
		
		System.out.println("customer --> id --> "+thecustomer.getId());
		
		session.remove(thecustomer);
		
	}

	public Customer getCustomer(int theid) {
		
		
Session session=sessionfactory.getCurrentSession();

Customer thecustomer=session.get(Customer.class,theid);
		
		System.out.println("customer --> id --> "+thecustomer.getId());
		
		return thecustomer;
	}

	public List<Customer> getCustomerSearch(String thekey) {


		Session session=sessionfactory.getCurrentSession();
		
		Query<Customer> query=null;
		try {
			query=session.createQuery("from Customer s where s.lastname like :searchField OR s.firstname like :searchField OR s.email like :searchField OR s.id like :searchField");
		
		 query.setParameter("searchField", "%" + thekey + "%");
		 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		List<Customer> customer=query.getResultList();
		return customer;
	}

}
