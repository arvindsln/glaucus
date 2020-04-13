/**
 * 
 */
package com.parking.constants;
import java.util.Arrays;
/**
 * @author arvind verma
 *
 */

public enum WeekdayPrice {

 SEVEN(0,2), TEN(3,5), FIFTEEN(6,10),TWENTYTWO(11,15),THIRTY(16,24);

    private final long min;
    private final long max;

    private WeekdayPrice(long min, long max) {
        this.min = min;
        this.max = max;
    }

    public String getRangeAccount() {
        return String.format("%d,%d", min, max);
    }

    public static WeekdayPrice getPrice(long val) {
        return Arrays.stream(values())
                     .filter(r -> val >= r.min && val <= r.max)
                     .findFirst()
                     .orElse(null);
    }

 }

