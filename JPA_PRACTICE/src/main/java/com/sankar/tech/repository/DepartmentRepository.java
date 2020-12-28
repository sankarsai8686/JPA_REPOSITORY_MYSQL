package com.sankar.tech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sankar.tech.dto.DeptEmpDto;
import com.sankar.tech.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	//DeptEmpDto(d.name, e.name, e.email, e.address)
	
	/*@Query(value = "select e.name as empName, e.email as empEmail, e.address as empAddress, "
			+ "d.name from employee e join department d where d.name=:name",nativeQuery = true)*/
	@Query(value = "select "
			+ "new com.sankar.tech.dto.DeptEmpDto(d.name, e.name, e.email, e.address)"
			+ "from employee e , department d ",nativeQuery = true)
	//+ "from employee e INNER JOIN department d where d.name=:name",nativeQuery = true)
	public List<DeptEmpDto> findByDepartmentName(@Param(value="name")  String name);

}
//https://roytuts.com/spring-boot-data-jpa-left-right-inner-and-cross-join-examples/