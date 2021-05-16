package tonipl.utils;

/**
 * Utility for common text uses.
 *
 */
public class StringUtils {

	private StringUtils() {
	}

	/**
	 * Returns null if a string is both null or empty. Otherwise, it returns the
	 * value.
	 *
	 * @param string the string
	 * @return null or value, never an empty
	 */
	public static String getNullOrValue(final String string) {
		String result = null;
		if (It.hasText(string)) {
			result = string;
		}
		return result;
	}
}
