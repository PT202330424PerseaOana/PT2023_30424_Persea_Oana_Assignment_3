package model;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */

/**
 * Represents an order in the system.
 */
public class Order {
    private int id;
    private int client_id;
    private int product_id;
    private int quantity;

    /**
     * Default constructor.
     */

    public Order() {
    }

    /**
     * Constructor with all parameters.
     *
     * @param id        the ID of the order
     * @param client_id  the ID of the client associated with the order
     * @param product_id the ID of the product associated with the order
     * @param quantity  the quantity of the product in the order
     */
    public Order(int id, int client_id, int product_id, int quantity) {
        super();
        this.id = id;
        this.client_id = client_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    /**
     * Constructor without ID parameter.
     *
     * @param client_id  the ID of the client associated with the order
     * @param product_id the ID of the product associated with the order
     * @param quantity  the quantity of the product in the order
     */
    public Order(int client_id, int product_id, int quantity) {
        super();
        this.client_id = client_id;
        this.product_id = product_id;
        this.quantity = quantity;

    }

    /**
     * Retrieves the ID of the order.
     *
     * @return the ID of the order
     */

    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the order.
     *
     * @param id the ID to set for the order
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the ID of the client associated with the order.
     *
     * @return the ID of the client
     */

    public int getClientId() {
        return client_id;
    }

    /**
     * Sets the ID of the client associated with the order.
     *
     * @param client_id the ID of the client to set
     */

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    /**
     * Retrieves the ID of the product associated with the order.
     *
     * @return the ID of the product
     */

    public int getProduct_id() {
        return product_id;
    }

    /**
     * Sets the ID of the product associated with the order.
     *
     * @param product_id the ID of the product to set
     */

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    /**
     * Retrieves the quantity of the product in the order.
     *
     * @return the quantity of the product
     */

    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in the order.
     *
     * @param quantity the quantity to set for the product
     */

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns a string representation of the order.
     *
     * @return a string representation of the order
     */
    @Override
    public String toString() {
        return "Order [id=" + id + ", client_id=" + client_id + ", product_id=" + product_id + ", quantity=" + quantity
                + "]";
    }

}
