package bll.validators;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */

/**
 * The Validator interface defines the contract for validating objects of a specific type.
 *
 * @param <T> The type of object to validate.
 */
public interface Validator<T> {

	/**
	 * Validates the specified object.
	 *
	 * @param t The object to validate.
	 * @throws IllegalArgumentException If the object fails the validation.
	 */
	public void validate(T t);
}
