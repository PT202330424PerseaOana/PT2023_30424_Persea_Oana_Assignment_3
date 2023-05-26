package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.*;
//import com.sun.org.apache.xpath.internal.operations.Or;
import dao.ClientDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Client;
import model.Order;
import model.Product;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */

/**
 * The business logic layer for handling order operations.
 */
public class OrderBLL {

    private List<Validator<Order>> validators;
    private OrderDAO orderDAO;
    StockValidator stockValidator=new StockValidator();
    PriceValidator priceValidator=new PriceValidator();
    ProductDAO productDAO;

    /**
     * Constructs a new instance of the OrderBLL class.
     * Initializes validators and the data access object.
     */
    public OrderBLL() {
        validators = new ArrayList<Validator<Order>>();


        orderDAO = new OrderDAO();
    }

    /**
     * Inserts a new order into the database.
     *
     * @param client_id   The ID of the client placing the order.
     * @param product_id  The ID of the product being ordered.
     * @param quantity    The quantity of the product being ordered.
     * @return The newly created Order object.
     */

    public Order insertNewOrder (int client_id, int product_id, int quantity){
        productDAO=new ProductDAO();
        Order order=new Order();
        order.setQuantity(quantity);
        order.setClient_id(client_id);
        order.setProduct_id(product_id);
        stockValidator.validate(order);
        Product pr=productDAO.findById(product_id);
        orderDAO.insert(client_id, product_id, quantity);
        productDAO.updateStock(product_id, pr.getStock() - quantity);
        return order;
    }

}
