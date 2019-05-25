package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;


@Controller
@RequestMapping("Customer")
public class CustomerController {
	@Autowired
	//private CustomerDao thedao;
	
	private CustomerService customerService;
	
	@RequestMapping("/Customerdetails")
	public String showCustomer(Model themodle) {
		
		List<Customer> thecustomerlist=customerService.getCustomers();
		
		themodle.addAttribute("customerlist",thecustomerlist);
		
		return "showcustomer";
		
	}
	
	
	@RequestMapping("/AddCustomer")
	public String showAddCustomer(Model themodle) {
		
		Customer thecustomer=new Customer();
		themodle.addAttribute("customer",thecustomer);
		
		return "showAddCustomer";
		
	}
	
	
	@PostMapping("/SaveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer thecustomer ) {
		
		customerService.saveNewCustomer(thecustomer);
		
		return "redirect:/Customer/Customerdetails";
		
		
		
	}
	
	
	@RequestMapping("/DeleteCustomer")
	public String DeleteCustomer(@RequestParam("customerid") int id) {
		
		Customer thecustomer =customerService.getCustomerById(id);
		
		customerService.DeleteExistingCustomer(thecustomer);
		
		System.out.println("in controller "+thecustomer.getId());
		
		return "redirect:/Customer/Customerdetails";
		
		
		
	}
	
	
	@GetMapping("/UpdateCustomerForm")
	public String UpdateCustomerForm(@RequestParam("customerid") int theid ,Model themodle ) {
		
			
			Customer thecustomer=customerService.getCustomerById(theid);
			themodle.addAttribute("customer",thecustomer);
		
		
		return "updatecustomer";
		

		
		
	}
	
	@PostMapping("/UpdateCustomer")
	public String updateCustomer(@ModelAttribute("customer") Customer thecustomer ) {
		
		customerService.UpdateExistingCustomer(thecustomer);
		
		return "redirect:/Customer/Customerdetails";
		
		
		
	}
	
	@RequestMapping("/SearchCustomer")
	public String searchCustomer(@RequestParam("search") String thekey ,Model themodle ) {
		
			
			//Customer thecustomer=customerService.getCustomerById(theid);
			//themodle.addAttribute("customer",thecustomer);
		
		
			
			
			//@RequestMapping("/Customerdetails")
			//public String showCustomer(Model themodle) {
				
				List<Customer> thecustomerlist=customerService.getCustomerSearch(thekey.toUpperCase());
				
				themodle.addAttribute("customerlist",thecustomerlist);
				
		return "showcustomer";
	
	}
}
