package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.*;
import dao.ClientDAO;
import dao.ProductDAO;
import model.Client;
import model.Product;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */

/**
 * The business logic layer for handling product operations.
 */

public class ProductBLL {

    private List<Validator<Product>> validators;
    private ProductDAO productDAO;


    /**
     * Constructs a new instance of the ProductBLL class.
     * Initializes validators and the data access object.
     */

    public ProductBLL() {
        validators = new ArrayList<Validator<Product>>();
        validators.add(new PriceValidator());
//        validators.add(new StockValidator());

        productDAO = new ProductDAO();
    }

    /**
     * Finds a product by its ID.
     *
     * @param id The ID of the product to find.
     * @return The found product.
     * @throws NoSuchElementException if the product with the specified ID is not found.
     */

    public Product findProduct(int id) {
        Product st = productDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return st;
    }

    /**
     * Finds a product by its stock.
     *
     * @param stock The stock of the product to find.
     * @return The found product.
     * @throws NoSuchElementException if the product with the specified stock is not found.
     */

    public Product findProductByStock(int stock) {
        Product st = productDAO.findByField("stock", stock);
        if (st == null) {
            throw new NoSuchElementException("The product with stock =" + stock + " was not found!");
        }
        return st;
    }

    /**
     * Finds a product by its price.
     *
     * @param price The price of the product to find.
     * @return The found product.
     * @throws NoSuchElementException if the product with the specified price is not found.
     */

    public Product findProductByPrice(int price) {
        Product st=productDAO.findByField("price", price);
        if(st==null) {

            throw new NoSuchElementException("The client with price =" + price + " was not found!");

        }
        return st;
    }

    /**
     * Finds a product by its name.
     *
     * @param name The name of the product to find.
     * @return The found product.
     * @throws NoSuchElementException if the product with the specified name is not found.
     */

    public Product findProductByName(String name) {
        Product st=productDAO.findByField("name", name);
        if(st==null) {

            throw new NoSuchElementException("The product with name =" + name + " was not found!");

        }
        return st;
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id The id of the product to delete.
     */

    public void deleteProductByID(int id) {
        Product st=findProduct(id);
        if(st!=null) {
            productDAO.deleteByID(id);
        }
    }

    /**
     * Deletes a product by its name.
     *
     * @param name The name of the product to delete.
     */
    public void deleteProductByName(String name) {
        Product st=findProductByName(name);
        if(st!=null) {
            productDAO.deleteByName(name);
        }
    }

    /**
     * Deletes a product by its stock.
     *
     * @param stock The stock of the product to delete.
     */

    public void deleteClientByStock(int stock) {
        Product st=findProductByStock(stock);
        if(st!=null) {
            productDAO.deleteByStock(stock);
        }
    }

    /**
     * Deletes a product by its price.
     *
     * @param price The price of the product to delete.
     */

    public void deleteClientByPrice(int price) {
        Product st=findProductByPrice(price);
        if(st!=null) {
            productDAO.deleteByPrice(price);
        }
    }

    /**
     * Updates the name of a product.
     *
     * @param id   The ID of the product to update.
     * @param name The new name of the product.
     * @return The updated Product object.
     */

    public Product updateProductName(int id,String name) {
        Product st = findProduct(id);
        if(st!=null) {
            productDAO.updateName(id, name);
        }
        return st;
    }

    /**
     * Updates the stock of a product.
     *
     * @param id   The ID of the product to update.
     * @param stock The new stock of the product.
     * @return The updated Product object.
     */
    public Product updateProductStock(int id,int stock) {
        Product st = findProduct(id);
        if(st!=null) {
            productDAO.updateStock(id, stock);
        }
        return st;
    }

    /**
     * Updates the price of a product.
     *
     * @param id   The ID of the product to update.
     * @param price The new price of the product.
     * @return The updated Product object.
     */
    public Product updateProductPrice(int id,int price) {
        Product st = findProduct(id);
        if(st!=null) {
            productDAO.updatePrice(id, price);
        }
        return st;
    }

    /**
     * Inserts a new product with the specified name, stock, and price.
     *
     * @param name  The name of the product.
     * @param stock The stock quantity of the product.
     * @param price The price of the product.
     * @return The inserted Product object.
     * @throws NoSuchElementException If the product couldn't be added.
     */
    public Product insertNewProduct (String name, int stock, int price){

        Product st=productDAO.insert(name, stock, price);
        System.out.println("name" + name);
        System.out.println("stock" + stock);
        System.out.println("price " + price);
        if(st==null) {
            throw new NoSuchElementException("The product couldn't be added");
        }
        return st;
    }

}
