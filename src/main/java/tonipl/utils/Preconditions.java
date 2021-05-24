package tonipl.utils;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import tonipl.exceptions.CustomException;

/**
 * Class to perform standard validations.
 */
public class Preconditions {

	/**
	 * Constructor to avoid instantiation of the class.
	 */
	private Preconditions() {
	}

	/**
	 * Checks an object is not null. If it is then throws a custom exception.
	 *
	 * @param object       the object
	 * @param errorMessage the error message
	 */
	public static void checkIsNotNull(final Object object, final String errorMessage) {
		if (object == null) {
			throw new CustomException(errorMessage);
		}
	}

	/**
	 * Check an object is not null. If it is then throws a custom exception.
	 *
	 * @param object       the object
	 * @param errorMessage the error message
	 * @param params       the params
	 */
	public static void checkIsNotNull(final Object object, final String errorMessage, final String... params) {
		if (object == null) {
			throw new CustomException(errorMessage, params);
		}
	}

	/**
	 * Check if not present. If it is then throws a custom exception.
	 *
	 * @param <T>          the generic type
	 * @param optional     the optional
	 * @param errorMessage the error message
	 * @return the t
	 */
	public static <T> T checkIfNotPresent(final Optional<T> optional, final String errorMessage) {
		checkIsNotNull(optional, errorMessage);

		if (optional.isPresent()) {
			throw new CustomException(errorMessage);
		}
		return null;
	}

	/**
	 * Check if not present. If it is then throws a custom exception.
	 *
	 * @param <T>          the generic type
	 * @param optional     the optional
	 * @param errorMessage the error message
	 * @param params       the params
	 * @return the t
	 */
	public static <T> T checkIfNotPresent(final Optional<T> optional, final String errorMessage,
			final String... params) {

		checkIsNotNull(optional, errorMessage, params);

		if (optional.isPresent()) {
			throw new CustomException(errorMessage, params);
		}
		return null;
	}

	/**
	 * Check if present. If not then throws a custom exception.
	 *
	 * @param <T>          the generic type
	 * @param optional     the optional
	 * @param errorMessage the error message
	 * @return the t
	 */
	public static <T> T checkIfPresent(final Optional<T> optional, final String errorMessage) {
		checkIsNotNull(optional, errorMessage);

		if (!optional.isPresent()) {
			throw new CustomException(errorMessage);
		}
		return optional.get();
	}

	/**
	 * Check if present. If not then throws a custom exception.
	 *
	 * @param <T>          the generic type
	 * @param optional     the optional
	 * @param errorMessage the error message
	 * @param params       the params
	 * @return the t
	 */
	public static <T> T checkIfPresent(final Optional<T> optional, final String errorMessage, final String... params) {
		checkIsNotNull(optional, errorMessage, params);

		if (!optional.isPresent()) {
			throw new CustomException(errorMessage, params);
		}
		return optional.get();
	}

	/**
	 * Checks a string is not null or empty. If it is then throws a custom exception.
	 *
	 * @param string       the string
	 * @param errorMessage the error message
	 */
	public static void checkStringIsNotEmpty(final String string, final String errorMessage) {
		if (It.hasNotText(string)) {
			throw new CustomException(errorMessage);
		}
	}

	/**
	 * Checks a string is not empty. If it is then throws a custom exception.
	 *
	 * @param string       the string
	 * @param errorMessage the error message
	 * @param params       the params
	 */
	public static void checkStringIsNotEmpty(final String string, final String errorMessage, final String... params) {
		if (It.hasNotText(string)) {
			throw new CustomException(errorMessage, params);
		}
	}

	/**
	 * Checks a collection is not null or empty. If it is then throws a custom exception.
	 *
	 * @param collection   the collection
	 * @param errorMessage the error message
	 */
	public static void checkCollectionIsNotEmpty(final Collection<?> collection, final String errorMessage) {
		if (It.isEmpty(collection)) {
			throw new CustomException(errorMessage);
		}
	}

	/**
	 * Checks a collection is not empty. If it is then throws a custom exception.
	 *
	 * @param collection   the collection
	 * @param errorMessage the error message
	 * @param params       the params
	 */
	public static void checkCollectionIsNotEmpty(final Collection<?> collection, final String errorMessage,
			final String... params) {
		if (It.isEmpty(collection)) {
			throw new CustomException(errorMessage, params);
		}
	}

	/**
	 * Checks a map is not null or empty. If it is then throws a custom exception.
	 *
	 * @param map          the map
	 * @param errorMessage the error message
	 */
	public static void checkMapIsNotEmpty(final Map<?, ?> map, final String errorMessage) {
		if (It.isEmpty(map)) {
			throw new CustomException(errorMessage);
		}
	}

	/**
	 * Checks a map is not empty. If it is then throws a custom exception.
	 *
	 * @param map          the map
	 * @param errorMessage the error message
	 * @param params       the params
	 */
	public static void checkMapIsNotEmpty(final Map<?, ?> map, final String errorMessage, final String... params) {
		if (It.isEmpty(map)) {
			throw new CustomException(errorMessage, params);
		}
	}
}
