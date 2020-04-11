/**
 * 
 */
package com.glaucus.domain;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author arvind verma
 *
 */
@NodeEntity
public class Person {

	private Long id;
	@NotEmpty(message = "Full Name must not be empty")
	private String fullName;
	
	private String lastname;
	
	@NotEmpty(message = "Email must not be empty")
	@Email(message = "email should be a valid email")	
	private String email;
	
	@NotNull(message = "Phone Number must not be empty")
	@Digits(message = "Phone Number must be digits", fraction = 0, integer = 9)
	@Positive(message = "Digits must be positive")
	private Long phoneNumber;
	
	private ZonedDateTime creationTime;
	private ZonedDateTime lastModified;
	
	@Relationship(type="lastname",direction=Relationship.TYPE)
	private List<Person> personList=new ArrayList<>();
		
	public List<Person> getPersons() {
		return personList;
	}	
	
	public void setPersons(Person person) {
		personList.add(person);
	}

	public Person() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public ZonedDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(ZonedDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public ZonedDateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(ZonedDateTime lastModified) {
		this.lastModified = lastModified;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	

}
