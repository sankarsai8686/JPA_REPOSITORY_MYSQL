package com.sankar.tech.controller;

import java.util.List;
import java.util.Properties;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sankar.tech.entity.Person;
import com.sankar.tech.service.PeopleManagementService;

@RestController
public class PeopleManagementController {
	
	@Autowired
	private PeopleManagementService peopleManagementService;
	
	
	@PostMapping("/person")
	public Person savePerson(@RequestBody Person person) {
		return peopleManagementService.savePerson(person);
	}
	
	@PostMapping("/persons")
	public Iterable<Person> savePersons(@RequestBody List<Person> person) {
		return peopleManagementService.savePersons(person);
	}
	
	@GetMapping("/person")
	public Iterable<Person> getPersons()
	{
		return peopleManagementService.getAllPersons();
	}
	

	@GetMapping("/person/findById/{id}")
	public ResponseEntity<Person> findById(@PathVariable(name = "id") Integer id)
	{
		 return new ResponseEntity<Person>(peopleManagementService.findById(id),HttpStatus.OK);
	}
	
	@GetMapping("/person/findByFirstName/{firstName}")
	public List<Person> findByFirstName(@PathVariable(name = "firstName") String firstName)
	{
		return peopleManagementService.findByFirstName(firstName);
	}
	
	@PutMapping("/person/updatePerson/{id}")
	public Person updatePerson(@PathVariable(name = "id") Integer id,@RequestBody Person person )
	{
		System.out.println("==updatePerson== : "+person.getCreationDate());
		return peopleManagementService.updatePerson(id,person);
	}
	
	@GetMapping("/person/findByFirstName/startingLetter/{str}")
	public List<Person> findByFirstNameStartingLetter(@PathVariable(name = "str") String startingLetter)
	{
		return peopleManagementService.findByFistNameStartsWith(startingLetter);
	}
	
	@GetMapping("/person/findByLastName/{lastName}/{page}/{size}/{direction}/{properties}")
	public List<Person> findByLastName(
			@PathVariable(name = "lastName") String lastName,
			@PathVariable(name = "page") Integer page,
			@PathVariable(name = "size") Integer size,
			@PathVariable(name = "direction") String direction,
			@PathVariable(name = "properties") String properties
			
			)
	{
		Direction directionRef = null;
		if("ASC".equals(direction))
			directionRef = Direction.ASC;
		else
			directionRef = Direction.DESC;
		
		Pageable firstPageWithTwoElements = PageRequest.of(page, size, directionRef, properties);
		
		//PageRequest.of(page, size);
		//PageRequest.of(page, size, directionRef, properties);
		//PageRequest.of(page, size, sort)
		
		return peopleManagementService.findByLastName(lastName, firstPageWithTwoElements);
	}
	
	
}
