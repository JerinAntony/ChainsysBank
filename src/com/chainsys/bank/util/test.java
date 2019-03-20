package com.chainsys.bank.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
public class test {

	public static void main(String[] args) {

		LocalDate today = LocalDate.now(); // Today's date
		LocalDate birthday = LocalDate.of(1930, Month.JANUARY, 1); // Birth date

		Period p = Period.between(birthday, today);

		// Now access the values as below
		System.out.println(p.getDays());
		System.out.println(p.getMonths());
		System.out.println(p.getYears());

		
	}

}
