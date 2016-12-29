package mappedBy.Cascade.example;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@ManyToOne
	private Customer lsOfCustomer ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customer getLsOfCustomer() {
		return lsOfCustomer;
	}
	public void setLsOfCustomer(Customer lsOfCustomer) {
		this.lsOfCustomer = lsOfCustomer;
	}
	
	
}
