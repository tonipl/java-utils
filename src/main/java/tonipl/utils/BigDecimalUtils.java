package tonipl.utils;

import java.math.BigDecimal;

/**
 * Utility for getting values by default when they are null.
 */
public class BigDecimalUtils {

	private BigDecimalUtils() {
	}

    /**
	 * Gets the default BigDecimal value if value is null. Otherwhise gets the
	 * value.
	 *
	 * @param value               the value
	 * @param bigDecimalByDefault the BigDecimal by default
	 * @return the BigDecimal value or the BigDecimal by default
	 */
	public static BigDecimal getValueOrDefaultValueIfNullValue(final BigDecimal value,
			final BigDecimal bigDecimalByDefault) {

		BigDecimal result = bigDecimalByDefault;
		if (It.isNotNull(value)) {
            result = value;
        }
        return result;
    }
}
