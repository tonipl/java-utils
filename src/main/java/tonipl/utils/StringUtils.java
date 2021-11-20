package tonipl.utils;

/**
 * Utility for common text uses.
 *
 */
public class StringUtils {

	private static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

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

	/**
	 * Checks if a string has numbers.
	 * 
	 * @param string the string
	 * @return true if there is some number in the string. Otherwise, false. Also a
	 *         false is returned if the string has not text
	 */
	public static boolean hasNumbers(final String string) {
		if (It.hasText(string)) {
			return org.apache.commons.lang3.StringUtils.containsAny(string, "0123456789");
		}
		return false;
	}

	/**
	 * Checks if the string has accents.
	 * 
	 * @param string the string
	 * @return true if there is some accent in the string. Otherwise, false. Also a
	 *         false is returned if the string has not text
	 */
	public static boolean hasAccents(final String string) {
		if (It.hasText(string)) {
			return org.apache.commons.lang3.StringUtils.containsAny(string, "áàéèíìóòúùÁÀÉÈÍÌÓÒÚÙäëïöÄËÏÖÜâêîôûÂÊÎÔÛ");
		}
		return false;
	}

	/**
	 * Checks if the string has some special character.
	 * 
	 * @param string the string
	 * @return true if there is some special character in the string. Otherwise,
	 *         false. Also a false is returned if the string has not text
	 */
	public static boolean hasSpecialCharacters(final String string) {
		if (It.hasText(string)) {
			CharSequence charSequence = string;
			final int size = charSequence.length();

			for (int i = 0; i < size; i++) {
				if (!Character.isLetterOrDigit(charSequence.charAt(i))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks if an email is valid.
	 *
	 * @param email the email
	 * @return true if valid, otherwise false
	 */
	public static boolean isValidEmail(final String email) {
		boolean isValid = false;
		if (It.hasText(email)) {
			isValid = email.matches(EMAIL_REGEX);
		}
		return isValid;
	}
}
