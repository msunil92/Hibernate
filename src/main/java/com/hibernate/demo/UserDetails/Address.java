package com.hibernate.demo.UserDetails;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String street;
	private String state;
	private String pincode;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public Address(String street, String state, String pincode) {
		this.state = state;
		this.street = street;
		this.pincode = pincode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	
}
