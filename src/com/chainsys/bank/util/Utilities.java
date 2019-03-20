package com.chainsys.bank.util;

import java.util.Random;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;

public class Utilities {

	/**
	 * Method to generate security code for two way Authentication
	 * 
	 * @return
	 */
	public static String securityCodeGenerator() {
		Random random = new Random();
		String securitycode = String.valueOf(random.nextInt(900000) + 100000);
		return securitycode;

	}

	/**
	 * Method to generate Users Account No
	 * 
	 * @return long
	 */
	public static long getAccountno() {
		long accountno = (long) (Math.random() * ((50000000 - 10000) + 1)) + 1000000000;
		return accountno;
	}

	/**
	 * Method to Send Mail
	 * 
	 * @param toemail
	 * @param msg
	 * @param subject
	 * @throws Exception
	 */
	public static void sendSimpleMail(String toemail, String msg, String subject)
			throws Exception {
		Email email = new HtmlEmail();
		email.setSmtpPort(587);

		email.setAuthenticator(new DefaultAuthenticator(
				"jerintonny25@gmail.com", "johnbosco"));
		email.setDebug(true);
		email.setHostName("smtp.gmail.com");
		email.setFrom("jerintonny25@gmail.com");
		email.setSubject(subject);
		email.setMsg(msg);
		email.addTo(toemail);
		email.setTLS(true);
		email.send();
		System.out.println("Mail sent!");
	}

	/**
	 * Method to generate password for login once register
	 * 
	 * @return
	 */
	public static String passwordGenerator() {
		int length = 10;
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%&*-?)";
		String values = Capital_chars + Small_chars + numbers + symbols;
		Random random = new Random();
		StringBuilder sd = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sd.append(values.charAt(random.nextInt(values.length())));
		}
		return sd.toString();
	}
}
