package com.sankar.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sankar.tech.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
