/**
 * 
 */
package com.glaucus.dao;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.glaucus.domain.Person;

/**
 * @author arvind verma
 *
 */
@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long>{
		
	List<Person> findByLastname(String lastName);  
	
	@Query("MATCH (n) RETURN n")
	List<Person> getAllPersons();
}
