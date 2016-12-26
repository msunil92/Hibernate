package com.hibernate.demo.proxyobjects;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity @Table(name="STUDENT")
public class Student {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="STUDENT_NAME")
	private String name;
	@Embedded @ElementCollection @JoinTable(name="COLLEGE_DETAIL",joinColumns=@JoinColumn(name="STUDENT_ID"))
	@GenericGenerator(strategy="hilo", name="hilo-gen")
	@CollectionId(columns = { @Column(name="COLLEGE_ID") }, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<College> listOfColleges = new ArrayList();
	
	public Student (){
		
	}
	
	public Student(String name, Collection<College> listOfColleges) {
		this.listOfColleges = listOfColleges;
		this.name = name;
	}

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

	public Collection<College> getListOfColleges() {
		return listOfColleges;
	}

	public void setListOfColleges(Collection<College> listOfColleges) {
		this.listOfColleges = listOfColleges;
	}
	
	
}
