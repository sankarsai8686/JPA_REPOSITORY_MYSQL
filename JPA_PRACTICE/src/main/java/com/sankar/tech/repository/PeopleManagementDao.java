package com.sankar.tech.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sankar.tech.entity.Person;

@Repository
public interface PeopleManagementDao extends CrudRepository<Person, Integer>{
	
	List<Person> findByfirstName(String firstName);
	
	@Query(value = "select * from Person_table where first_name like :startingLetter% ", nativeQuery = true)
	List<Person> findByFistNameStartsWith(@Param(value = "startingLetter") String startingLetter);

	
	List<Person> findByLastName(String lastName, Pageable pageable);
	
}
