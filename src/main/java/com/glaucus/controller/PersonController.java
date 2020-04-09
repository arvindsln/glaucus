/**
 * 
 */
package com.glaucus.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.glaucus.domain.Person;
import com.glaucus.exception.ResourceNotFoundException;
import com.glaucus.service.PersonService;

/**
 * @author arvind verma
 *
 */
@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	// creating a get mapping that retrieves all the persons detail from the database
	@GetMapping("/person-service/persons/")
	private List<Person> getAllPersons(String lastName) {
		List<Person> persons = personService.getAllPersons();
		if (persons == null || persons.isEmpty()) {
			throw new ResourceNotFoundException("No persons record found");
		}

		return persons;
	}

	// creating a get mapping that retrieves the detail of a specific person
	@GetMapping("/person-service/persons/{personId}")
	private ResponseEntity<Optional<Person>> getPerson(@PathVariable("personId") long id) {
		Optional<Person> person = personService.getPersonById(id);

		if (!person.isPresent()) {
			throw new ResourceNotFoundException("Invalid person id : " + id);
		}

		return new ResponseEntity<Optional<Person>>(person, HttpStatus.OK);
	}

	// creating post mapping that post the person detail in the database
	@PostMapping("/person-service/persons")
	private ResponseEntity<Person> savePerson(@Valid @RequestBody Person person) {
		personService.savePerson(person);
		return new ResponseEntity<Person>(person, HttpStatus.OK);

	}

	// creating put mapping that updates the person detail
	@PutMapping("/person-service/persons")
	private ResponseEntity<Person> updatePerson(@Valid @RequestBody Person person) {
		personService.updatePerson(person);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	// creating a delete mapping that deletes a specified person
	@DeleteMapping("/person-service/persons/{personId}")
	private ResponseEntity<Person> deletePerson(@PathVariable("personId") long id) {
		personService.deletePerson(id);

		 return new ResponseEntity<Person>(HttpStatus.OK);
	}
	
	
}
