/**
 * 
 */
package com.parking.constants;

import java.util.Arrays;


/**
 * @author arvind verma
 *
 */
public enum WeekendPrice {
	FIVE(0,2), EIGHT(3,5), TWELVE(6,10),EIGHTEEN(11,15),TWENTYFIVE(16,24);

	private final long min;
    private final long max;

    private WeekendPrice(long min, long max) {
        this.min = min;
        this.max = max;
    }

    public String getRangeAccount() {
        return String.format("%d,%d", min, max);
    }

    public static WeekendPrice getPrice(long val) {
        return Arrays.stream(values())
                     .filter(r -> val >= r.min && val <= r.max)
                     .findFirst()
                     .orElse(null);
    }
    
  }
