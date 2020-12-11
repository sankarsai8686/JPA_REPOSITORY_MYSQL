package com.sankar.tech.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.sankar.tech.entity.Person;

public interface PeopleManagementService {
	
	Person savePerson(Person person);
	
	Iterable<Person> savePersons(List<Person> person);

	Iterable<Person> getAllPersons();

	Person findById(Integer id);
	
	List<Person> findByFirstName(String firstName);

	Person updatePerson(Integer id, Person person);
	
	List<Person> findByFistNameStartsWith(String startingLetter);
	
	public List<Person> findByLastName(String lastname,Pageable pageable);

}
