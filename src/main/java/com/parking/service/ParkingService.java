/**
 * 
 */
package com.parking.service;

import java.time.Duration;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.constants.Num;
import com.parking.constants.WeekdayPrice;
import com.parking.constants.WeekendPrice;
import com.parking.dao.ParkingRepository;

/**
 * @author arvind verma
 *
 */
@Service
public class ParkingService {

	@Autowired
	ParkingRepository parkingRepo;
	Logger logger = LoggerFactory.getLogger(ParkingService.class);

	public int getTotalAmount(LocalDateTime entryTime,LocalDateTime exitTime) {
		
	    long hours = getTime(entryTime, exitTime);
	    int price=0;
	    int day=exitTime.getDayOfWeek().getValue();
	    
	    if(day==6 || day==7)
	    {
	    	logger.info("Weekend hours-->"+hours);
		price=Num.getValue(WeekendPrice.getPrice(hours).toString());
	    }
	    else
	    {
	    	logger.info("Weekday hours-->"+hours);
	    	price=Num.getValue(WeekdayPrice.getPrice(hours).toString());
	    	
	    }
		parkingRepo.storePriceInfo(price);
		return price;
	}

	private static long getTime(LocalDateTime entryTime, LocalDateTime exitTime) {
        LocalDateTime today = LocalDateTime.of(exitTime.getYear(),
                exitTime.getMonthValue(), exitTime.getDayOfMonth(), entryTime.getHour(), entryTime.getMinute(), entryTime.getSecond());
        Duration duration = Duration.between(today, exitTime);

        long hours = duration.toHours();
        
        return hours;
}

	public Integer getIndividualPrice(int id) {
		// TODO Auto-generated method stub
		return parkingRepo.getIndividualPrice(id);
	}
}