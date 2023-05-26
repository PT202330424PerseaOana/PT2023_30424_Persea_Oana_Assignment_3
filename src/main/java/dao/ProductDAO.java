package dao;
import model.Product;

/**
 * Data Access Object (DAO) for performing CRUD operations on the Product table in the database.
 * Extends the AbstractDAO class.
 */
public class ProductDAO extends AbstractDAO<Product> {

    // uses basic CRUD methods from superclass


    /**
     * Updates the name of a product with the specified ID.
     *
     * @param id   the ID of the product to update
     * @param name the new name for the product
     */
    public void updateName(int id, String name) {

        Product product = new Product();
        product.setName(name);
        Product product2 = findById(id);
        product.setPrice(product2.getPrice());
        product.setStock(product2.getStock());
        product.setId(product2.getId());

        update(product, id);
    }


    /**
     * Updates the price of a product with the specified ID.
     *
     * @param id    the ID of the product to update
     * @param price the new price for the product
     */
    public void updatePrice(int id, int price) {


        Product product = new Product();
        product.setPrice(price);
        Product product2 = findById(id);
        product.setName(product2.getName());
        product.setStock(product2.getStock());
        product.setId(product2.getId());
        update(product, id);
    }

    /**
     * Updates the stock quantity of a product with the specified ID.
     *
     * @param id    the ID of the product to update
     * @param stock the new stock quantity for the product
     */

    public void updateStock(int id, int stock) {

        Product product = new Product();
        product.setStock(stock);
        Product product2 = findById(id);
        product.setPrice(product2.getPrice());
        product.setName(product2.getName());
        product.setId(product2.getId());
        update(product, id);
    }

    /**
     * Deletes products from the database with the specified name.
     *
     * @param name the name of the products to delete
     */
    public void deleteByName(String name) {
        deleteByField("name", name);
    }
    /**
     * Deletes products from the database with the specified price.
     *
     * @param price the price of the products to delete
     */
    public void deleteByPrice(int price) {
        deleteByField("price", price);
    }
    /**
     * Deletes products from the database with the specified stock quantity.
     *
     * @param stock the stock quantity of the products to delete
     */
    public void deleteByStock(int stock) {
        deleteByField("stock", stock);
    }
    /**
     * Deletes a product from the database with the specified ID.
     *
     * @param id the ID of the product to delete
     * @return 1 if the product was deleted successfully, 0 otherwise
     */
    public int deleteByID(int id){
        int rowsAffected=0;
        rowsAffected=deleteByField("id", id);
        if(rowsAffected>0) {
            return 1;
        }
        return 0;
    }

    /**
     * Finds a product in the database with the specified name.
     *
     * @param name the name of the product to find
     * @return the found product object, or null if not found
     */

    public Product findByName(String name) {
        Product product=findByField("name", name);
        return product;
    }

    /**
     * Inserts a new product into the database with the specified details.
     *
     * @param name  the name of the product
     * @param stock the stock quantity of the product
     * @param price the price of the product
     * @return the inserted product object
     */

    public Product insert(String name, int stock, int price) {
        Product product=new Product();
        product.setName(name);
        System.out.println("name" + product.getName());
        product.setStock(stock);
        System.out.println("stock" + product.getStock());
        product.setPrice(price);
        System.out.println("price" + product.getPrice());
        insert(product);
        return product;
    }


// TODO: create only student specific queries
}
