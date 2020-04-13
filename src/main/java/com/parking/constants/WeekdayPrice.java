/**
 * 
 */
package com.parking.constants;

/**
 * @author arvind verma
 *
 */
public enum WeekdayPrice {
	SEVEN(7), TEN(10), FIFTEEN(15),TWENTYTWO(22),THIRTY(30);

    private final long hour;

    private WeekdayPrice(long hour) {
        this.hour = hour;
    }

    public static WeekdayPrice getPrice(long hour) {
    	WeekdayPrice found = SEVEN;
        for (WeekdayPrice w : values())
            if (w.hour <= hour)
                found = w;

        return found;
    }
    
}
