/**
 * 
 */
package com.parking.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * @author arvind verma
 *
 */
@Repository
public class ParkingRepository {

	int memberId=0;
	Map<Integer,Integer> map=new HashMap<>();
	public void storePriceInfo(int price)
	{
		map.put(++memberId, price);
	}
	public Integer getIndividualPrice(int id) {
		// TODO Auto-generated method stub
		return map.get(id);
	}
		
	
}
