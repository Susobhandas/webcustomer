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

@Transactional
	public List<Customer> getCustomers() {
		
	Session session=sessionfactory.getCurrentSession();
	
	Query<Customer> query=session.createQuery("from Customer",Customer.class);
	
		return query.getResultList();
	}

}
