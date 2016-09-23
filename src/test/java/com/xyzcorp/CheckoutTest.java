package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CheckoutTest 
{
	@Test
	@Category(value = UnitTest.class)
	public void testPenaltyWithTheSameDate()
	{
		Checkout checkout = new Checkout("Anastasia Shpurik", "East of Eden", LocalDate.of(2016, 6, 1));
		assertThat(checkout.getCalculatedPenaltyT(5, LocalDate.of(2016, 6, 1))).isEqualTo(0);
	}
	
	@Test
	@Category(value = UnitTest.class)
	public void testPenaltyWithTheSameDateNextMonth()
	{
		Checkout checkout = new Checkout("Anastasia Shpurik", "East of Eden", LocalDate.of(2016, 6, 1));
		assertThat(checkout.getCalculatedPenaltyT(5, LocalDate.of(2016, 7, 1))).isEqualTo(0);
	}
	
	@Test
	@Category(value = UnitTest.class)
	public void testPenaltyWithTheSameDateNextMonthPlusOneDay()
	{
		Checkout checkout = new Checkout("Anastasia Shpurik", "East of Eden", LocalDate.of(2016, 6, 1));
		assertThat(checkout.getCalculatedPenaltyT(5, LocalDate.of(2016, 7, 2))).isEqualTo(5);
	}
	
	@Test
	@Category(value = UnitTest.class)
	public void testPenaltyWithTheSameDateTwoMonthPlusOneDay()
	{
		Checkout checkout = new Checkout("Anastasia Shpurik", "East of Eden", LocalDate.of(2016, 6, 1));
		assertThat(checkout.getCalculatedPenaltyT(5, LocalDate.of(2016, 8, 2))).isEqualTo(10);
	}
	
	@Test
	@Category(value = UnitTest.class)
	public void testPenaltyWithTheCheckoutDateisJanuary31AndReturnDateIsFebruary29()
	{
		Checkout checkout = new Checkout("Anastasia Shpurik", "East of Eden", LocalDate.of(2016, 1, 31));
		assertThat(checkout.getCalculatedPenaltyT(5, LocalDate.of(2016, 2, 29))).isEqualTo(0);
	}
	
	@Test
	@Category(value = UnitTest.class)
	public void testPenaltyWithTheCheckoutDateisJanuary31AndReturnDateIsMarch1()
	{
		Checkout checkout = new Checkout("Anastasia Shpurik", "East of Eden", LocalDate.of(2016, 1, 31));
		assertThat(checkout.getCalculatedPenaltyT(5, LocalDate.of(2016, 3, 1))).isEqualTo(0);
	}
}
