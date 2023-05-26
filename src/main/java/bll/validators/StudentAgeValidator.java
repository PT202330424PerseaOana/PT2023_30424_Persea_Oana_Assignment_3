package bll.validators;

import model.Client;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */

/**
 * A validator implementation for validating the age of a client.
 */
public class StudentAgeValidator implements Validator<Client> {
	private static final int MIN_AGE = 7;
	private static final int MAX_AGE = 30;

	/**
	 * Validates the age of a client.
	 *
	 * @param t The client object to validate.
	 * @throws IllegalArgumentException If the age is not within the allowed range or if the age format is not valid.
	 */
	public void validate(Client t) {
		if (!isNotNumber(String.valueOf(t.getAge()))) {
			if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
				throw new IllegalArgumentException("The Client Age limit is not respected!");
			}

		}
		else {
			throw new IllegalArgumentException("The Client Age format is not respected!");
		}
	}
	/**
	 * Checks if a given string is not a valid number.
	 *
	 * @param str The string to check.
	 * @return {@code true} if the string is not a valid number, {@code false} otherwise.
	 */
	public static boolean isNotNumber(String str) {
		try {
			Integer.parseInt(str);
			return false; // Successfully parsed as an integer
		} catch (NumberFormatException e) {
			return true; // Failed to parse as an integer
		}
	}

}
