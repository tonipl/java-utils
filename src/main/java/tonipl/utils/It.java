package tonipl.utils;

import java.util.Collection;
import java.util.Map;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * Utility for common boolean uses of objects.
 * 
 * This name of class has been chosen for using natural language in code.
 *
 */
public final class It {

	private It() {
	}

	/**
	 * Check whether the given Object is null.
	 * 
	 * @param object the Object to check
	 * @return whether the given Object is null
	 */
	public static boolean isNull(final Object object) {
		return object == null;
	}

	/**
	 * Check whether the given Object is not null.
	 * 
	 * @param object the Object to check
	 * @return whether the given Object is not null
	 */
	public static boolean isNotNull(final Object object) {
		return !isNull(object);
	}

	/**
	 * Return true if the Collection is null or empty. Otherwise, return false.
	 * 
	 * @param collection the Collection to check
	 * @return whether the given Collection is empty
	 */
	public static boolean isEmpty(final Collection<?> collection) {
		return CollectionUtils.isEmpty(collection);
	}

	/**
	 * Return true if the Collection is not null or not empty. Otherwise, return
	 * false.
	 * 
	 * @param collection the Collection to check
	 * @return whether the given Collection is not empty
	 */
	public static boolean isNotEmpty(final Collection<?> collection) {
		return !isEmpty(collection);
	}

	/**
	 * Return true if the Map is null or empty. Otherwise, return false.
	 * 
	 * @param map the Map to check
	 * @return whether the given Map is empty
	 */
	public static boolean isEmpty(final Map<?, ?> map) {
		return CollectionUtils.isEmpty(map);
	}

	/**
	 * Return true if the Map is not null or not empty. Otherwise, return false.
	 * 
	 * @param map the Map to check
	 * @return whether the given Map is not empty
	 */
	public static boolean isNotEmpty(final Map<?, ?> map) {
		return !isEmpty(map);
	}

	/**
	 * Check whether the given String contains actual text.
	 * 
	 * @param object the String to check (may be null)
	 * @return true if the String is not null, its length is greater than 0 and it
	 *         does not contain whitespace only
	 */
	public static boolean hasText(final String object) {
		return StringUtils.hasText(object);
	}

	/**
	 * Check whether the given String doesn't contain actual text.
	 * 
	 * @param object the String to check
	 * @return true if the String is null, its length is less or equals than 0 or it
	 *         contains whitespace only
	 */
	public static boolean hasNotText(final String object) {
		return !hasText(object);
	}
}
