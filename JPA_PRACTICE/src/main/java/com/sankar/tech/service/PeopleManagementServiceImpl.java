package com.sankar.tech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.sankar.tech.exception.ResourceNotFoundException;
import com.sankar.tech.entity.Person;
import com.sankar.tech.repository.PeopleManagementDao;

@Service
public class PeopleManagementServiceImpl implements PeopleManagementService {

	@Autowired
	private PeopleManagementDao peopleManagementDao;
	
	
	public Person savePerson(Person person)
	{
		Person result = peopleManagementDao.save(person);
		return result;
	}


	@Override
	public Iterable<Person> savePersons(List<Person> person) {
		Iterable<Person> result = peopleManagementDao.saveAll(person);
		return result;
	}


	@Override
	public Iterable<Person> getAllPersons() {
		return peopleManagementDao.findAll();
	}


	@Override
	public Person findById(Integer id) {
		Optional<Person> findById = peopleManagementDao.findById(id);
		if(findById.isPresent())
		{
			return findById.get();
		}
		throw new ResourceNotFoundException("Resouce Not Found : "+id);
		
	}


	@Override
	public List<Person> findByFirstName(String firstName) {
		
		List<Person> findByfirstName = peopleManagementDao.findByfirstName(firstName);
		if(findByfirstName == null || findByfirstName.isEmpty())
		{
			throw new ResourceNotFoundException("NOT FOUND : "+firstName);
		}
		return findByfirstName;
	}


	@Override
	public Person updatePerson(Integer id, Person person) {
		
		Optional<Person> findById = peopleManagementDao.findById(id);
		if(findById.isPresent())
		{
			Person personRecordsFromDB = findById.get();
			personRecordsFromDB.setId(id);
			personRecordsFromDB.setFirstName(person.getFirstName());
			personRecordsFromDB.setLastName(person.getLastName());
			personRecordsFromDB.setCreationDate(person.getCreationDate());
			return peopleManagementDao.save(personRecordsFromDB);
		}
		else
		{
			throw new ResourceNotFoundException("NOT FOUND TO UPDATE : "+id);
		}
		
		
	}


	@Override
	public List<Person> findByFistNameStartsWith(String startingLetter) {
		
		List<Person> findByFistNameStartsWith = peopleManagementDao.findByFistNameStartsWith(startingLetter);
		if(findByFistNameStartsWith == null || findByFistNameStartsWith.isEmpty())
		{
			throw new ResourceNotFoundException("Not FOUND RECORDS : "+startingLetter);
		}
		else
		{
			return findByFistNameStartsWith;
		}
	}
	
	
	public List<Person> findByLastName(String lastName, Pageable pageable)
	{
		List<Person> findByLastName = peopleManagementDao.findByLastName(lastName, pageable);
		if(findByLastName == null || findByLastName.isEmpty())
		{
			throw new ResourceNotFoundException("Not FOUND RECORDS : "+lastName);
		}
		else
		{
			return findByLastName;
		}
	
	
	
	}
	
	
	
	
	
	
	
	
	
}
