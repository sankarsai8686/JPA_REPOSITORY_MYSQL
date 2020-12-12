package com.sankar.tech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class MyEntity2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="myentity2_seq")
	@SequenceGenerator(name = "myentity2_seq",sequenceName = "myentity2_seq_table")
	private int id;
	
	@Column(length = 100)
	private String name;
	
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MyEntity2(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public MyEntity2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
