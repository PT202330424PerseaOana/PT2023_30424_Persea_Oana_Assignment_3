package bll.validators;

import dao.ProductDAO;
import model.Order;
import model.Product;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */

/**
 * A validator implementation for validating the stock of an order.
 */
public class StockValidator implements Validator<Order> {
    private static final int MIN_STOCK = 0;
    private static final int MAX_STOCK = 1000;


    /**
     * Validates the stock of an order.
     *
     * @param t The order object to validate.
     * @throws IllegalArgumentException If there is no such product or if there is not enough stock available for the order.
     */
    public void validate(Order t) {
        int stock=t.getQuantity();
        int prodID=t.getProduct_id();
        ProductDAO productDao=new ProductDAO();
        Product product=new Product();
        product=productDao.findById(prodID);
        if(product.equals(null)) {
            throw new IllegalArgumentException("There is no such product");
        }
        if (stock>product.getStock()) {
            throw new IllegalArgumentException("Not enough stock");
        }

    }

}
