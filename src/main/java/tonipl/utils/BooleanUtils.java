package tonipl.utils;

/**
 * Utility for getting values by default when they are null.
 */
public class BooleanUtils {

	private BooleanUtils() {
	}

    /**
	 * Gets the default Boolean value if value is null. Otherwhise gets the value.
	 *
	 * @param value            the value
	 * @param booleanByDefault the Boolean by default
	 * @return the Boolean value or the Boolean by default
	 */
	public static Boolean getValueOrDefaultValueIfNullValue(final Boolean value, final Boolean booleanByDefault) {
		Boolean result = booleanByDefault;
		if (It.isNotNull(value)) {
            result = value;
        }
        return result;
    }
}
