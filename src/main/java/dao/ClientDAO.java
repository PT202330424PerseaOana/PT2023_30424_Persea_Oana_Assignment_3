package dao;
import model.Client;

/**
 * Data Access Object (DAO) for performing CRUD operations on the Client table in the database.
 * Extends the AbstractDAO class.
 */
public class ClientDAO extends AbstractDAO<Client> {

	// uses basic CRUD methods from superclass
   /**
    * Updates the name of a client with the specified ID.
    *
    * @param id   the ID of the client to update
    * @param name the new name for the client
    */

   public void updateName(int id, String name){

      Client client=new Client();
      client.setName(name);
      Client client2=findById(id);
      client.setEmail(client2.getEmail());
      client.setAddress(client2.getAddress());
      client.setAge(client2.getAge());
      client.setId(client2.getId());
      update(client,id);
   }

   /**
    * Updates the address of a client with the specified ID.
    *
    * @param id      the ID of the client to update
    * @param address the new address for the client
    */
   public void updateAddress(int id, String address){

      Client client=new Client();
      client.setAddress(address);

      Client client2=findById(id);
      client.setEmail(client2.getEmail());
      client.setName(client2.getName());
      client.setAge(client2.getAge());
      client.setId(client2.getId());

      update(client,id);
   }

   /**
    * Updates the email of a client with the specified ID.
    *
    * @param id    the ID of the client to update
    * @param email the new email for the client
    */
   public void updateEmail(int id, String email){

      Client client=new Client();
      client.setEmail(email);
      Client client2=findById(id);
      client.setAddress(client2.getAddress());
      client.setAge(client2.getAge());
      client.setId(client2.getId());
      client.setName(client2.getName());


      update(client,id);
   }

   /**
    * Updates the age of a client with the specified ID.
    *
    * @param id  the ID of the client to update
    * @param age the new age for the client
    */

   public void updateAge(int id, int age){

      Client client=new Client();
      client.setAge(age);
      Client client2=findById(id);
      client.setEmail(client2.getEmail());
      client.setAddress(client2.getAddress());
      client.setName(client2.getName());
      client.setId(client2.getId());

      update(client,id);
   }

   /**
    * Deletes a client from the database based on the name.
    *
    * @param name the name of the client to delete
    */

   public void deleteByName(String name) {
      deleteByField("name", name);
   }

   /**
    * Deletes a client from the database based on the address.
    *
    * @param address the address of the client to delete
    */
   public void deleteByAddress(String address) {
      deleteByField("address", address);
   }

   /**
    * Deletes a client from the database based on the email.
    *
    * @param email the email of the client to delete
    */
   public void deleteByEmail(String email) {
      deleteByField("email", email);
   }

   /**
    * Deletes a client from the database based on the age.
    *
    * @param age the age of the client to delete
    */
   public void deleteByAge(int age) {
      deleteByField("age", age);
   }

   /**
    * Deletes a client from the database based on the ID.
    *
    * @param id the ID of the client to delete
    * @return the number of rows affected by the deletion (1 if successful, 0 otherwise)
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
    * Finds a client in the database based on the name.
    *
    * @param name the name of the client to find
    * @return the client object that matches the name, or null if not found
    */
   public Client findByName(String name) {
      Client client=findByField(name, name);
      return client;
   }

   /**
    * Inserts a new client into the database with the specified details.
    *
    * @param name    the name of the client
    * @param email   the email of the client
    * @param age     the age of the client
    * @param address the address of the client
    * @return the inserted client object
    */
   public Client insert(String name, String email, int age, String address) {
      Client client=new Client();
      client.setName(name);
      client.setAge(age);
      client.setEmail(email);
      client.setAddress(address);
      insert(client);
      return client;
   }


// TODO: create only student specific queries
}
