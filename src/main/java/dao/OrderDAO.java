package dao;
import model.Order;
/**
 * Data Access Object (DAO) for performing CRUD operations on the Order table in the database.
 * Extends the AbstractDAO class.

 */
public class OrderDAO extends AbstractDAO<Order> {

    // uses basic CRUD methods from superclass
    /**
     * Inserts a new order into the database with the specified details.
     *
     * @param client_id   the ID of the client associated with the order
     * @param product_id  the ID of the product associated with the order
     * @param quantity    the quantity of the product in the order
     * @return the inserted order object
     */
    public Order insert(int client_id, int product_id, int quantity) {
        Order order=new Order();
        order.setClient_id(client_id);
        order.setProduct_id(product_id);
        order.setQuantity(quantity);
        insertOrder(order);
        return order;
    }


// TODO: create only student specific queries
}
