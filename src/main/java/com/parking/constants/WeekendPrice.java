/**
 * 
 */
package com.parking.constants;

/**
 * @author arvind verma
 *
 */
public enum WeekendPrice {
	FIVE(2), EIGHT(5), TWELVE(10),EIGHTEEN(15),TWENTYFIVE(24);

    private final long hour;

    private WeekendPrice(long hour) {
        this.hour = hour;
    }

    public static WeekendPrice getPrice(long hour) {
    	WeekendPrice found = FIVE;
        for (WeekendPrice w : values())
            if (w.hour <= hour)
                found = w;

        return found;
    }  
}
