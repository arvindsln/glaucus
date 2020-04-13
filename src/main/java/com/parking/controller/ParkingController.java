/**
 * 
 */
package com.parking.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.parking.exception.ResourceNotFoundException;
import com.parking.service.ParkingService;

/**
 * @author arvind verma
 *
 */
@RestController
public class ParkingController {

	@Autowired
	ParkingService parkingService;

	// creating a get mapping that retrieves all the parking prices detail from the database
	@GetMapping("/parking-service/parking/prices/{id}")
	private ResponseEntity<Integer> getIndividualPrice(@PathVariable("id") int id) {
		Integer parkingPrice = parkingService.getIndividualPrice(id);
		if (parkingPrice == null) {
			throw new ResourceNotFoundException("No parking/prices record found");
		}

		return new ResponseEntity<Integer>(parkingPrice, HttpStatus.OK);
	}

	// creating a get mapping that retrieves the detail of a specific parking price
	@GetMapping("/parking-service/parking/prices/{entryTime}/{exitTime}")
	private ResponseEntity<Integer> getPerson(@PathVariable("entryTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime entryTime,@PathVariable("exitTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime exitTime) {
		Integer parkingPrice = parkingService.getTotalAmount(entryTime,exitTime);

		if (parkingPrice==null) {
			throw new ResourceNotFoundException("Invalid Amount");
		}

		return new ResponseEntity<Integer>(parkingPrice, HttpStatus.OK);
	}
}
