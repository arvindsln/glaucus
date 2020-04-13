package com.parking.constants;

public enum Num {

	FIVE("FIVE",5), SEVEN("SEVEN",7),EIGHT("EIGHT",8),TEN("TEN",10), TWELVE("TWELVE",12),FIFTEEN("FIFTEEN",15),EIGHTEEN("EIGHTEEN",18),TWENTYTWO("TWENTYTWO",22),TWENTYFIVE("TWENTYFIVE",25),THIRTY("THIRTY",30);
	
	private String key;
	private int value;
	
	private Num(String key,int value)
	{
		this.key = key;
		this.value = value;
	}
	
	public static int getValue(String str)
	{
		int val=0;
		for (Num w : values())
		{
			if(w.key.equalsIgnoreCase(str))
			{
				val=w.value;
			}
		}
		return val;
	}

	
	
}
