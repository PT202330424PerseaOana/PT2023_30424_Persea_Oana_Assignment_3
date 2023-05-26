package start;

import java.sql.SQLException;
import java.util.logging.Logger;

import bll.ClientBLL;
import connection.ConnectionFactory;
import presentation.ClientView;
import presentation.Controller;
import presentation.View1;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 *
 */

/**
 * The Start class serves as the entry point for the application.
 */
public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());
	public static ConnectionFactory connectionFactory=new ConnectionFactory();

	public static View1 view1;
	public static ClientView clientView;

	/**
	 * The main method is the entry point of the application.
	 *
	 * @param args the command-line arguments
	 * @throws SQLException if a database error occurs
	 */

	public static void main(String[] args) throws SQLException {

		connectionFactory.createConnection();
		Controller controller=new Controller();

	}

}
