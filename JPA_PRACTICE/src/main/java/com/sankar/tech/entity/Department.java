package com.sankar.tech.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator="dep_seq")
	@SequenceGenerator(name="dep_seq" , schema="dep_seq_gen")
	private int id;
	
	private String name;
	
	private String description;
	
	@OneToMany(targetEntity = Employee.class , mappedBy = "id" , 
			fetch = FetchType.LAZY, orphanRemoval = false , cascade = CascadeType.ALL)
	private Set<Employee> employees;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
