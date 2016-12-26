package com.hibernate.demo.proxyobjects;

import javax.persistence.Embeddable;

@Embeddable
public class College {
	private String name;
	
	public College() {
	}
	
	public College(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
