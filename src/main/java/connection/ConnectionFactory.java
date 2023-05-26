package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 * @Source: http://theopentutorials.com/tutorials/java/jdbc/jdbc-mysql-create-database-example/
 */

/**
 * The ConnectionFactory class provides methods for creating and managing database connections.
 */
public class ConnectionFactory {

	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String DBURL = "jdbc:postgresql://localhost:5432/schooldb";
	private static final String USER = "postgres";
	private static final String PASS = "premianta";

	private static ConnectionFactory singleInstance = new ConnectionFactory();

	/**
	 * Constructs a new ConnectionFactory instance.
	 */
	public ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a new database connection.
	 *
	 * @return The created Connection object.
	 */
	public Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBURL, USER, PASS);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Returns a database connection.
	 *
	 * @return The Connection object.
	 */
	public static Connection getConnection() {
		return singleInstance.createConnection();
	}

	/**
	 * Closes a database connection.
	 *
	 * @param connection The Connection object to close.
	 */
	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
			}
		}
	}
	/**
	 * Closes a database statement.
	 *
	 * @param statement The Statement object to close.
	 */

	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
			}
		}
	}
	/**
	 * Closes a database result set.
	 *
	 * @param resultSet The ResultSet object to close.
	 */

	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
			}
		}
	}
}
