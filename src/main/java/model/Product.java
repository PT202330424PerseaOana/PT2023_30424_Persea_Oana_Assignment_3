package model;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */

/**
 * Represents a product in the system.
 */
public class Product {
    private int id;
    private String name;
    private int price;
    private int stock;

    /**
     * Default constructor.
     */
    public Product() {
    }

    /**
     * Constructor with all parameters.
     *
     * @param id    the ID of the product
     * @param name  the name of the product
     * @param price the price of the product
     * @param stock the stock quantity of the product
     */
    public Product(int id, String name, int price, int stock) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    /**
     * Constructor without ID parameter.
     *
     * @param name  the name of the product
     * @param price the price of the product
     * @param stock the stock quantity of the product
     */

    public Product(String name, int price, int stock) {
        super();
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    /**
     * Retrieves the ID of the product.
     *
     * @return the ID of the product
     */

    public int getId() {
        return id;
    }
    /**
     * Sets the ID of the product.
     *
     * @param id the ID to set for the product
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the product.
     *
     * @return the name of the product
     */

    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name the name to set for the product
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the price of the product.
     *
     * @return the price of the product
     */

    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price the price to set for the product
     */

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Retrieves the stock quantity of the product.
     *
     * @return the stock quantity of the product
     */

    public int getStock() {
        return stock;
    }

    /**
     * Sets the stock quantity of the product.
     *
     * @param stock the stock quantity to set for the product
     */

    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Returns a string representation of the product.
     *
     * @return a string representation of the product
     */


    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
    }

}
