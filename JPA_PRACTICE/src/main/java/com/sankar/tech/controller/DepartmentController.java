package com.sankar.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sankar.tech.dto.DeptEmpDto;
import com.sankar.tech.entity.Department;
import com.sankar.tech.entity.Employee;
import com.sankar.tech.repository.DepartmentRepository;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	@PostMapping("/department")
	public Department saveEmployee(@RequestBody Department department)
	{
		return departmentRepository.save(department);
	}
	
	@GetMapping("/department")
	public List<Department> getAllDepartments()
	{
		return departmentRepository.findAll();
	}
	
	@GetMapping("/department/{deptName}")
	public List<DeptEmpDto> findByDepartmentName(@PathVariable(name = "deptName") String deptName)
	{
		return departmentRepository.findByDepartmentName(deptName);
	}
	

}
