package com.xyzcorp;

import static java.time.temporal.ChronoUnit.MONTHS;
import static java.time.temporal.ChronoUnit.DAYS;


import java.time.LocalDate;

public class Checkout {

	private String name;
	private String title;
	private LocalDate date;
	
	public Checkout(String name, String title, LocalDate date) {
		this.name = name;
		this.title = title;
		this.date = date;
	}

	public String getName() {
		return this.name;
	}

	public String getTitle() {
		return this.title;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public int getCalculatedPenaltyT(int penaltyRate, LocalDate returnDate) {
		if(returnDate.getDayOfMonth() == 1)
			returnDate = returnDate.minusDays(1);
		
		return (int) DAYS.between(this.date, returnDate) / 30 * penaltyRate;		
	}

}
