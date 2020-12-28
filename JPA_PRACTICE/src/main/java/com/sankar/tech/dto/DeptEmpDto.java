package com.sankar.tech.dto;

public class DeptEmpDto {
	
	private String empDept;
	private String empName;
	private String empEmail;
	private String empAddress;
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public DeptEmpDto(String empDept, String empName, String empEmail, String empAddress) {
		super();
		this.empDept = empDept;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empAddress = empAddress;
	}
	
	
	
	

}
