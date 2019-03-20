package com.chainsys.bank.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankValidator {

	/**
	 * Method to Validate Pan card number
	 * 
	 * @param pancardno
	 * @return
	 */
	public boolean checkPancard(String pancardno) {
		boolean isValid = false;
		Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
		Matcher matcher = pattern.matcher(pancardno);
		if (matcher.matches()) {
			isValid = true;
		} else {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * Check whether String contains any special character
	 * 
	 * @param input
	 * @return
	 */
	public boolean checkSpecialCharacters(String input) {
		boolean isContains = false;
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches()) {
			isContains = true;
		} else {
			isContains = false;
		}
		return isContains;
	}

	/**
	 * Method to validate phone no
	 * 
	 * @param phoneno
	 * @return
	 */
	public boolean validPhoneNumber(long phoneno) {
		boolean isValid = false;
		// ("(0/91)?[6-9][0-9]{9}")
		Pattern pattern = Pattern.compile("[6-9][0-9]{9}");
		Matcher matcher = pattern.matcher(String.valueOf(phoneno));
		if (matcher.matches()) {
			isValid = true;
		} else {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * Method to validate email from users
	 * 
	 * @param email
	 * @return
	 */
	public static boolean emailValidator(String email) {
		boolean isValidEmail = false;
		String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		Pattern pattern = Pattern
				.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			isValidEmail = true;
		} else {
			isValidEmail = false;
		}
		return isValidEmail;
	}

	/**
	 * Method to check String contains only alphabet
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isonlyAlphabet(String value) {
		return ((!value.equals("")) && (value.isEmpty()) && (value
				.matches("^[a-zA-Z]*$")));
	}

	/**
	 * Method to Allow only numbers
	 * 
	 * @param number
	 * @return
	 */
	public boolean checkOnlyNumbers(long number) {
		boolean isNumber = false;
		String onlynumbers = "[0-9]+";
		Pattern pattern = Pattern.compile(onlynumbers);
		Matcher matcher = pattern.matcher(String.valueOf(number));
		if (matcher.matches()) {
			isNumber = true;
		} else {
			isNumber = false;
		}
		return isNumber;
	}

	public static boolean validateDate(String strDate) {
		boolean isValidDate = false;
		if (strDate.trim().equals("")) {
			isValidDate = true;
		} else {
			SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
			sdfrmt.setLenient(false);
			try {
				Date javaDate = sdfrmt.parse(strDate);
			} catch (ParseException e) {
				isValidDate = false;
			}
		}
		return isValidDate;
	}
}
