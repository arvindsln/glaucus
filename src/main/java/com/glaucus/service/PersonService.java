/**
 * 
 */
package com.glaucus.service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glaucus.dao.PersonRepository;
import com.glaucus.domain.Person;

/**
 * @author arvind verma
 *
 */
@Service
public class PersonService {

	@Autowired
	PersonRepository personRepo;

	/**
	 * @param person
	 */
	@Transactional
	public void savePerson(Person person) {

		person.setCreationTime(ZonedDateTime.now());
		personRepo.save(person);

		// Create connection between nodes based on last name.
		createConnection(person);
	}

	/**
	 * @param person
	 */
	private void createConnection(Person person) {
		// create connection
		String fullName = person.getFullName();
		if (fullName != null) {
			String[] nameArr = person.getFullName().split(" ");
			if (nameArr.length > 1) {
				String lastname = nameArr[nameArr.length - 1];
				person.setLastname(lastname);
				person.setPersons(person);
				List<Person> personsWithMatchingLastName = getMatchingPersonsByLastName(lastname);
				personRepo.saveAll(personsWithMatchingLastName);
			}
		}
	}

	/**
	 * @param person
	 */
	@Transactional
	public void updatePerson(Person person) {

		person.setCreationTime(ZonedDateTime.now());
		personRepo.save(person);
	}

	/**
	 * @param id
	 */
	@Transactional
	public void deletePerson(long id) {
		personRepo.deleteById(id);
	}

	public List<Person> getMatchingPersonsByLastName(String lastname) {
		// TODO Auto-generated method stub
		return personRepo.findByLastname(lastname);
	}

	public Optional<Person> getPersonById(long id) {
		// TODO Auto-generated method stub
		return personRepo.findById(id);
	}

	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return (List<Person>) personRepo.getAllPersons();
	}

}
