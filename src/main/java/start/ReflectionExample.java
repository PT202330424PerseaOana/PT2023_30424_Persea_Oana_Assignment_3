package start;

import java.lang.reflect.Field;

/**
 * The ReflectionExample class demonstrates reflection in Java.
 */

public class ReflectionExample {

	/**
	 * Retrieves the properties of an object using reflection and prints them.
	 *
	 * @param object the object whose properties need to be retrieved
	 */

	public static void retrieveProperties(Object object) {

		for (Field field : object.getClass().getDeclaredFields()) {
			field.setAccessible(true); 
			Object value;
			try {
				value = field.get(object);
				System.out.println(field.getName() + "=" + value);

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}
	}
}



