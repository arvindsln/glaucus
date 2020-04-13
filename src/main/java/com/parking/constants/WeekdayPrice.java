/**
 * 
 */
package com.parking.constants;

/**
 * @author arvind verma
 *
 */
public enum WeekdayPrice {
	SEVEN(2), TEN(5), FIFTEEN(10),TWENTYTWO(15),THIRTY(24);

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
    
    public static void main(String args[])
	{
		System.out.println(getPrice(3));
	}
}


