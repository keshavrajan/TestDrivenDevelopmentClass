package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LineParserTest {
	@Test
	@Category(value=UnitTest.class)
	public void testAPerfectLine()
	{
		LineParser lineParser = new LineParser("~");
		Checkout checkout = lineParser.parse("Hao Guan~Ender's Game~2012-02-12");
		assertThat(checkout.getName()).isEqualTo("Hao Guan");
		assertThat(checkout.getTitle()).isEqualTo("Ender's Game");
		assertThat(checkout.getDate()).isEqualTo(LocalDate.of(2012, 2, 11));
	}

	@Test
	@Category(value=UnitTest.class)
	public void testAPerfectLineWithDifferentDate()
	{
		LineParser lineParser = new LineParser("~");
		Checkout checkout = lineParser.parse("Keshav Rajan~Hamlet~2016-09-01");
		assertThat(checkout.getName()).isEqualTo("Keshav Rajan");
		assertThat(checkout.getTitle()).isEqualTo("Hamlet");
		assertThat(checkout.getDate()).isEqualTo(LocalDate.of(2016, 9, 1));
	}
	
	@Test
	@Category(value=UnitTest.class)
	public void testAPerfectLineWithDifferentDateAndDelimiter()
	{
		LineParser lineParser = new LineParser("@");
		Checkout checkout = lineParser.parse("Keshav Rajan@Hamlet@2016-09-01");
		assertThat(checkout.getName()).isEqualTo("Keshav Rajan");
		assertThat(checkout.getTitle()).isEqualTo("Hamlet");
		assertThat(checkout.getDate()).isEqualTo(LocalDate.of(2016, 9, 1));
	}
	
}
