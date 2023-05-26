package bll.validators;

import model.Product;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */

/**

 * A validator implementation for validating the price of a product.
 */
public class PriceValidator implements Validator<Product> {
    private static final int MIN_PRICE= 1;
    private static final int MAX_PRICE = 1000;

    /**
    * Validates the price of a product.
    * @param t The product object to validate.
     * @throws IllegalArgumentException if the price is not within the allowed range.
     */
    public void validate(Product t) {

        if (t.getPrice() < MIN_PRICE || t.getPrice() > MAX_PRICE) {
            throw new IllegalArgumentException("The product price limit is not respected!");
        }

    }

}
