package com.sankar.tech.exception;

import java.util.Date;

public class CustomError {
	
	private Date todayDate;
	private String message;
	private String description;
	public CustomError() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomError(Date todayDate, String message, String description) {
		super();
		this.todayDate = todayDate;
		this.message = message;
		this.description = description;
	}
	public Date getTodayDate() {
		return todayDate;
	}
	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
