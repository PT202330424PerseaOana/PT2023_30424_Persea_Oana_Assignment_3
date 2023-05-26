package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.EmailValidator;
import bll.validators.StudentAgeValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;
/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */

/**
 * The business logic layer for handling client operations.
 */
public class ClientBLL {

	private List<Validator<Client>> validators;
	private ClientDAO clienttDAO;
	private EmailValidator emailValidator=new EmailValidator();
	private StudentAgeValidator studentAgeValidator=new StudentAgeValidator();



	/**
	 * Constructs a new instance of the ClientBLL class.
	 * Initializes validators and the data access object.
	 */

	public ClientBLL() {
		validators = new ArrayList<Validator<Client>>();
		validators.add(new EmailValidator());
		validators.add(new StudentAgeValidator());

		clienttDAO = new ClientDAO();
	}

	/**
	 * Finds a client by their ID.
	 *
	 * @param id The ID of the client to find.
	 * @return The found client.
	 * @throws NoSuchElementException if the client with the specified ID is not found.
	 */
	public Client findClientById(int id) {
		Client st = clienttDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The client with id =" + id + " was not found!");
		}
		return st;
	}

	/**
	 * Finds a client by their Address.
	 *
	 * @param address The address of the client to find.
	 * @return The found client.
	 * @throws NoSuchElementException if the client with the specified address is not found.
	 */
	public Client findClientByAddress(String address) {
		Client st = clienttDAO.findByField("address", address);
		if (st == null) {
			throw new NoSuchElementException("The client with address =" + address + " was not found!");
		}
		return st;
	}

	/**
	 * Finds a client by their name.
	 *
	 * @param name The name of the client to find.
	 * @return The found client.
	 * @throws NoSuchElementException if the client with the specified name is not found.
	 */

	public Client findClientByName(String name) {
		Client st=clienttDAO.findByField("name", name);
		if(st==null) {

			throw new NoSuchElementException("The client with name =" + name + " was not found!");

		}
		return st;
	}


	/**
	 * Finds a client by their email.
	 *
	 * @param email The email of the client to find.
	 * @return The found client.
	 * @throws NoSuchElementException if the client with the specified email is not found.
	 */
	public Client findClientByEmail(String email) {

		Client st=clienttDAO.findByField("email", email);
		emailValidator.validate(st);
		if(st==null) {

			throw new NoSuchElementException("The client with email =" + email + " was not found!");

		}
		return st;
	}



	/**
	 * Finds a client by their age.
	 *
	 * @param age The age of the client to find.
	 * @return The found client.
	 * @throws NoSuchElementException if the client with the specified age is not found.
	 */
	public Client findClientByAge(int age) {
		Client st=clienttDAO.findByField("age", age);
		studentAgeValidator.validate(st);
		if(st==null) {

			throw new NoSuchElementException("The client with age =" + age + " was not found!");

		}
		return st;
	}

	/**
	 * Deletes a client by their ID.
	 *
	 * @param id The ID of the client to delete.
	 */
	public void deleteClientByID(int id) {
		Client st=findClientById(id);
		if(st!=null) {
			clienttDAO.deleteByID(id);
		}
	}

	/**
	 * Deletes a client by their name.
	 *
	 * @param name The name of the client to delete.
	 */
	public void deleteClientByName(String name) {
		Client st=findClientByName(name);
		if(st!=null) {
			clienttDAO.deleteByName(name);
		}
	}


	/**
	 * Deletes a client by their email.
	 *
	 * @param email The email of the client to delete.
	 */
	public void deleteClientByEmail(String email) {
		Client st=findClientByEmail(email);
		emailValidator.validate(st);
		if(st!=null) {
			clienttDAO.deleteByEmail(email);
		}
	}

	/**
	 * Deletes a client by their age.
	 *
	 * @param age The age of the client to delete.
	 */

	public void deleteClientByAge(int age) {
		Client st=findClientByAge(age);
		studentAgeValidator.validate(st);
		if(st!=null) {
			clienttDAO.deleteByAge(age);
		}
	}

	/**
	 * Deletes a client by their address.
	 * @param address The address of the client to delete.
	 */

	public void deleteClientByAddress(String address) {
		Client st=findClientByAddress(address);
		if(st!=null) {
			clienttDAO.deleteByAddress(address);
		}
	}

	/**
	 * Updates the name of a client with the specified ID.
	 * @param id   The ID of the client to update.
	 * @param name The new name for the client.
	 * @return The updated client object if found, or null if no client was found with the given ID.
	 */

	public Client updateClientName(int id,String name) {
		Client st = findClientById(id);
		if(st!=null) {
			clienttDAO.updateName(id, name);
		}
		return st;
	}

	/**
	 * Updates the address of a client with the specified ID.
	 * @param id   The ID of the client to update.
	 * @param address The new address for the client.
	 * @return The updated client object if found, or null if no client was found with the given ID.
	 */

	public Client updateClientAddress(int id,String address) {
		Client st = findClientById(id);
		if(st!=null) {
			System.out.println("am gasit");
			clienttDAO.updateAddress(id, address);
		}
		return st;
	}

	/**
	 * Updates the age of a client with the specified ID.
	 * @param id   The ID of the client to update.
	 * @param age The new age for the client.
	 * @return The updated client object if found, or null if no client was found with the given ID.
	 */
	public Client updateClientAge(int id,int age) {
		Client st = findClientById(id);
		studentAgeValidator.validate(st);
		if(st!=null) {
			clienttDAO.updateAge(id, age);
		}
		return st;
	}

	/**
	 * Updates the email of a client with the specified ID.
	 * @param id   The ID of the client to update.
	 * @param email The new email for the client.
	 * @return The updated client object if found, or null if no client was found with the given ID.
	 */
	public Client updateClientEmail(int id,String email) {
		Client st = findClientById(id);
		emailValidator.validate(st);
		if(st!=null) {
			System.out.println("am gasit");
			clienttDAO.updateEmail(id, email);
		}
		return st;
	}

	/**
	 * Inserts a new client with the provided details into the database.
	 * @param email   The email address of the client.
	 * @param address The address of the client.
	 * @param name    The name of the client.
	 * @param age     The age of the client.
	 * @return The newly created client object.
	 * @throws NoSuchElementException if the client couldn't be added to the database.
	 */
	public Client insertNewClient(String email, String address, String name, int age){
		Client st=new Client();
		st.setAddress(address);
		st.setAge(age);
		st.setEmail(email);
		st.setName(name);
		emailValidator.validate(st);
		studentAgeValidator.validate(st);
		Client st1=clienttDAO.insert(name, email, age, address);
		if(st1==null) {
			throw new NoSuchElementException("The client couldn't be added");
		}
	return st;
	}

}
