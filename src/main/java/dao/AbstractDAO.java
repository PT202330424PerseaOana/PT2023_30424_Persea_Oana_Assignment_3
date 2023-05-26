package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 * @Source http://www.java-blog.com/mapping-javaobjects-database-reflection-generics
 */

/**
 * This class serves as an abstract Data Access Object (DAO) for performing CRUD operations on a database table.
 * It provides generic methods for inserting, updating, deleting, and querying objects of a specific type.
 *
 * @param <T> The type of object that this DAO handles.
 */
public class AbstractDAO<T> {
	protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

	private final Class<T> type;

	/**
	 * Constructs a new AbstractDAO object.
	 */

	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}

	/**
	 * Creates a SELECT query for retrieving objects based on a field value.
	 *
	 * @param field The name of the field to filter on.
	 * @return The SELECT query as a String.
	 */
	private String createSelectQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + " =?");
		return sb.toString();
	}

	/**
	 * Creates an INSERT query for inserting objects into the database table.
	 *
	 * @return The INSERT query as a String.
	 */
	public String createInsertQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT ");
		sb.append(" INTO ");
		sb.append(type.getSimpleName());
		sb.append(" (");
		Field[] fields = type.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			sb.append(fields[i].getName());
			if (i < fields.length - 1) {
				sb.append(", ");
			}
		}
		sb.append(") ");
		sb.append(" VALUES ");
		sb.append("(");
		for(int i=0; i<type.getDeclaredFields().length-1; i++) {
			sb.append("?,");
		}
		sb.append("?);");
		String ceva=sb.toString();
		return sb.toString();
	}

	/**
	 * Creates an INSERT query specifically for inserting objects into the "order" table,
	 * as "order" is a reserved keyword in SQL and needs to be escaped with double quotes.
	 *
	 * @return The INSERT query for the "order" table as a String.
	 */
	public String createInsertQueryForOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT ");
		sb.append(" INTO \"order\" ");
		sb.append(" (");
		Field[] fields = type.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			sb.append(fields[i].getName());
			if (i < fields.length - 1) {
				sb.append(", ");
			}
		}
		sb.append(") ");
		sb.append(" VALUES ");
		sb.append("(");
		for(int i=0; i<type.getDeclaredFields().length-1; i++) {
			sb.append("?,");
		}
		sb.append("?);");
		String ceva=sb.toString();
//		System.out.println(ceva);
		return sb.toString();
	}

	/**
	 * Creates an UPDATE query for updating an object in the database.
	 *
	 * @param t The object to be updated.
	 * @return The UPDATE query as a String.
	 */
	private String createUpdateQuery(T t) {
		StringBuilder sb=new StringBuilder();
		sb.append("UPDATE ");
		sb.append(type.getSimpleName());
		sb.append(" SET ");
		Field[] fields = type.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			if (field.getName().equalsIgnoreCase("id")) { // Exclude the ID field from the update query
				continue;
			}
			sb.append(field.getName()).append(" = ?");
			if (i < fields.length - 1) {
				sb.append(", ");
			}
		}

		sb.append(" WHERE id = ?");
		return sb.toString();
	}

	/**
	 * Creates a DELETE query for deleting objects based on a field value.
	 *
	 * @param fieldName The name of the field to filter on.
	 * @return The DELETE query as a String.
	 */

	private String createDeleteQuery(String fieldName) {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE ");
		sb.append(fieldName);
		sb.append(" =?");
		return sb.toString();
	}

	/**
	 * Retrieves the ID field of the object's class.
	 *
	 * @return The ID field as a Field object.
	 * @throws IllegalArgumentException If no ID field is found in the class.
	 */
	private Field getIdField() {
		Field[] fields = type.getDeclaredFields();

		for (Field field : fields) {
			if (field.getName().equalsIgnoreCase("id")) {
				return field;
			}
		}

		throw new IllegalArgumentException("No ID field found in the class " + type.getName());
	}

	/**
	 * Sets the parameters of a prepared statement for an UPDATE query.
	 *
	 * @param statement The PreparedStatement object.
	 * @param t         The object containing the updated values.
	 * @throws SQLException If an SQL error occurs.
	 */
	private void setUpdateParameters(PreparedStatement statement, T t) throws SQLException {
		Field[] fields = type.getDeclaredFields();
		int parameterIndex = 1;
		for (Field field : fields) {
			if (!field.getName().equalsIgnoreCase("id")) {
				field.setAccessible(true);
				try {
					Object value = field.get(t);
					statement.setObject(parameterIndex, value);
					parameterIndex++;
				} catch (IllegalAccessException e) {
					LOGGER.log(Level.WARNING, "Error setting update parameters: " + e.getMessage());
				}
			}
		}
		Field idField;
		try {
			idField = type.getDeclaredField("id");
			idField.setAccessible(true);
			Object idValue = idField.get(t);
			statement.setObject(parameterIndex, idValue);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			LOGGER.log(Level.WARNING, "Error setting ID parameter for update: " + e.getMessage());
		}
	}

	/**
	 * Sets the parameters of a prepared statement for an INSERT query.
	 *
	 * @param statement The PreparedStatement object.
	 * @param t         The object to be inserted.
	 * @param nextId    The next available ID for the object.
	 * @throws SQLException If an SQL error occurs.
	 */

	private void setInsertParameters(PreparedStatement statement, T t, int nextId) throws SQLException {
		Field[] fields = type.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			field.setAccessible(true);
			try {
				if (field.getName().equalsIgnoreCase("id")) { // Check if it's the ID field
					statement.setInt(i + 1, nextId); // Set the next ID value
				} else {
					Object value = field.get(t);
					statement.setObject(i + 1, value);
				}
			} catch (IllegalAccessException e) {
				LOGGER.log(Level.WARNING, "Error setting insert parameters: " + e.getMessage());
			}
		}
	}

	/**
	 * Calculates the next available ID for inserting a new object into the database table.
	 *
	 * @param connection The database connection.
	 * @return The next available ID as an integer.
	 * @throws SQLException If an SQL error occurs.
	 */
	private int calculateNextId(Connection connection) throws SQLException {
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT MAX(id) FROM ");
		sb.append(type.getSimpleName());
		String query=sb.toString();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int nextId = 1; // Default next ID if no records exist

		try {
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int maxId = resultSet.getInt(1);
				nextId = maxId + 1;
			}
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
		}

		return nextId;
	}
	/**
	 * Calculates the next available ID for the order table in the database.
	 *
	 * @param connection the database connection
	 * @return the next available ID for the order table
	 * @throws SQLException if a database access error occurs
	 */

	private int calculateNextIdOrder(Connection connection) throws SQLException {
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT MAX(id) FROM \"order\"");
		String query=sb.toString();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int nextId = 1;

		try {
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int maxId = resultSet.getInt(1);
				nextId = maxId + 1;
			}
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
		}

		return nextId;
	}

	/**
	 * Inserts an object into the corresponding table in the database.
	 *
	 * @param t the object to insert
	 * @return the inserted object
	 */

	public T insert(T t) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createInsertQuery();
		System.out.println(query);

		try {
			connection = ConnectionFactory.getConnection();

			int nextId = calculateNextId(connection);
			System.out.println(nextId);

			statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			setInsertParameters(statement, t, nextId); // Pass the nextId to the setInsertParameters method
			System.out.println(statement.toString());
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				int id = resultSet.getInt(1);
				System.out.println(id);
				calculateNextId(connection);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}

		return t;
	}

	/**
	 * Inserts an order object into the order table in the database.
	 *
	 * @param t the order object to insert
	 * @return the inserted order object
	 */
	public T insertOrder(T t) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createInsertQueryForOrder();
		System.out.println(query);

		try {
			connection = ConnectionFactory.getConnection();
			int nextId = calculateNextIdOrder(connection);
			System.out.println(nextId);

			statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			setInsertParameters(statement, t, nextId);
			System.out.println(statement.toString());
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				int id = resultSet.getInt(1);
				System.out.println(id);
				calculateNextIdOrder(connection);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}

		return t;
	}

	/**
	 * Retrieves all objects from the corresponding table in the database.
	 *
	 * @return a list of all objects from the table
	 */

	public List<T> findAll() {
		// TODO:
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		String query=sb.toString();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();

			return createObjects(resultSet);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	/**
	 * Retrieves an object from the corresponding table in the database based on the ID.
	 *
	 * @param id the ID of the object to retrieve
	 * @return the object with the specified ID
	 */
	public T findById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectQuery("id");
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	/**
	 * Retrieves an object from the corresponding table in the database based on a field value.
	 *
	 * @param fieldName the name of the field to search by
	 * @param value     the value to match in the specified field
	 * @return the object that matches the field and value
	 */

	public T findByField(String fieldName, Object value) {
		List<T> resultList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query=createSelectQuery(fieldName);


		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, value);
			resultSet = statement.executeQuery();
			return createObjects(resultSet).get(0);

			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
			} finally {
				ConnectionFactory.close(resultSet);
				ConnectionFactory.close(statement);
				ConnectionFactory.close(connection);
			}
			return null;
	}

	/**
	 * Creates objects from the result set obtained from a database query.
	 *
	 * @param resultSet the result set containing the queried data
	 * @return a list of created objects
	 */

	private List<T> createObjects(ResultSet resultSet) {
		List<T> list = new ArrayList<T>();
		Constructor[] ctors = type.getDeclaredConstructors();
		Constructor ctor = null;
		for (int i = 0; i < ctors.length; i++) {
			ctor = ctors[i];
			if (ctor.getGenericParameterTypes().length == 0)
				break;
		}
		try {
			while (resultSet.next()) {
				ctor.setAccessible(true);
				T instance = (T)ctor.newInstance();
				for (Field field : type.getDeclaredFields()) {
					String fieldName = field.getName();
					Object value = resultSet.getObject(fieldName);
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance, value);
				}
				list.add(instance);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Updates an object in the corresponding table in the database.
	 *
	 * @param updatedObject the updated object
	 * @param id            the ID of the object to update
	 */
	public void update(T updatedObject, int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createUpdateQuery(updatedObject);

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			setUpdateParameters(statement, updatedObject);
			statement.setInt(updatedObject.getClass().getDeclaredFields().length, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}

	}

	/**
	 * Deletes rows from the corresponding table in the database based on a field value.
	 *
	 * @param fieldName the name of the field to search by
	 * @param value     the value to match in the specified field
	 * @return the number of rows affected by the deletion
	 */

	public int deleteByField(String fieldName, Object value) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query=createDeleteQuery(fieldName);
		int rowsAffected;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, value);
			rowsAffected=statement.executeUpdate();
			return rowsAffected;
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Error deleting rows from table: " + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return 0;
	}





}
