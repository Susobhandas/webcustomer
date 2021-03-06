package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Customer")
public class Customer {

	public Customer() {
	
	}

	
	@Id
	@SequenceGenerator(name="cust_seq" , sequenceName="cust_seq", allocationSize=10)
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="cust_seq")
	private int id;
	@NotNull(message="Field Required")
	@Size(min=1,message="Please Enter First name")
	@Column(name="first_name")
	private String firstname;
	
	@NotNull(message="Field Required")
	@Size(min=1,message="Please Enter Last name")
	@Column(name="last_name")
	private String lastname;
	
	@NotNull(message="Field Required")
	@Size(min=1,message="Please Enter Email")
	@Column(name="email")
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + "]";
	}
	
	
	
}
