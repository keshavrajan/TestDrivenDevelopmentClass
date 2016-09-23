package com.xyzcorp;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class LineParser 
{
	private String delimiter;

	public LineParser(String delimiter)
	{
		this.delimiter = delimiter;
	}
	
	public Checkout parse(String str)
	{
		if("".equals(str.trim()))
			throw new IllegalArgumentException("Data is an empty string");
		
		String[] items = str.split(this.delimiter);
		
		if(items.length != 3)
			throw new IllegalArgumentException("Data is not in a valid format");
			
		LocalDate parsedDate;
		try
		{
			parsedDate = LocalDate.parse(items[2]);
		}
		catch(DateTimeParseException e)
		{
			throw new IllegalArgumentException("Data is not in a valid format", e);
		}
		
		return new Checkout(items[0], items[1], LocalDate.parse(items[2]));
	}
}
