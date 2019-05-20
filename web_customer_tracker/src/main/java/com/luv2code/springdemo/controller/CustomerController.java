package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;


@Controller
@RequestMapping("Customer")
public class CustomerController {
	@Autowired
	private CustomerDao thedao;
	
	
	
	@RequestMapping("/Customerdetails")
	public String showCustomer(Model themodle) {
		
		List<Customer> thecustomerlist=thedao.getCustomers();
		
		themodle.addAttribute("customerlist",thecustomerlist);
		
		return "showcustomer";
		
	}
	
}
