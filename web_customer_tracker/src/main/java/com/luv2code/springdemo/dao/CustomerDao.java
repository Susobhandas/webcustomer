package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer thecustomer);

	public void UpdateCustomer(Customer thecustomer);

	public void deleteCustomer(Customer thecustomer);

	public Customer getCustomer(int theid);

	public List<Customer> getCustomerSearch(String thekey);

	
	
}
