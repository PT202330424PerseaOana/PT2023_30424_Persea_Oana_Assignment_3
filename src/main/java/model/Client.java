package model;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 *
 */

/**
 * Represents a client in the system.
 */
public class Client {
	private int id;
	private String name;
	private String address;
	private String email;
	private int age;

	/**
	 * Default constructor.
	 */

	public Client() {
	}

	/**
	 * Constructor with all parameters.
	 *
	 * @param id      the ID of the client
	 * @param name    the name of the client
	 * @param address the address of the client
	 * @param email   the email of the client
	 * @param age     the age of the client
	 */

	public Client(int id, String name, String address, String email, int age) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.age = age;
	}
	/**
	 * Constructor without ID parameter.
	 *
	 * @param name    the name of the client
	 * @param address the address of the client
	 * @param email   the email of the client
	 * @param age     the age of the client
	 */

	public Client(String name, String address, String email, int age) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.age = age;
	}

	/**
	 * Retrieves the ID of the client.
	 *
	 * @return the ID of the client
	 */

	public int getId() {
		return id;
	}

	/**
	 * Sets the ID of the client.
	 *
	 * @param id the ID to set for the client
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retrieves the name of the client.
	 *
	 * @return the name of the client
	 */

	public String getName() {
		return name;
	}
	/**
	 * Sets the name of the client.
	 *
	 * @param name the name to set for the client
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the address of the client.
	 *
	 * @return the address of the client
	 */

	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address of the client.
	 *
	 * @param address the address to set for the client
	 */

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Retrieves the age of the client.
	 *
	 * @return the age of the client
	 */

	public int getAge() {
		return age;
	}

	/**
	 * Sets the age of the client.
	 *
	 * @param age the age to set for the client
	 */

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Retrieves the email of the client.
	 *
	 * @return the email of the client
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email of the client.
	 *
	 * @param email the email to set for the client
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns a string representation of the client.
	 *
	 * @return a string representation of the client
	 */

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", age=" + age
				+ "]";
	}

}
