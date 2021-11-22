package tonipl.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Calendar;
import java.util.Date;

import tonipl.exceptions.CustomException;

/**
 * Utilitiy for managing dates.
 */
public class DateUtils {

	private static final String DD_MM_YYYY = "dd/MM/yyyy";
	private static final String DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd-HH:mm:ss.SSS";

	private DateUtils() {
    }



	/**
	 * Gets the default date format.
	 *
	 * @return the default date format
	 */
	public static DateFormat getDefaultDateFormat() {
		return new SimpleDateFormat(DEFAULT_DATE_FORMAT);
	}

	/**
	 * Transforms the date to String.
	 *
	 * @param date the date
	 * @return the String
	 */
	public static String transformDateToString(final Date date) {
		String formattedDate = null;
		try {
			if (It.isNotNull(date)) {
				formattedDate = new SimpleDateFormat(DD_MM_YYYY_HH_MM_SS).format(date);
			}
		} catch (final DateTimeException exception) {
			throw new CustomException(exception);
		}
		return formattedDate;
	}

	/**
	 * Formats the date to String without time.
	 *
	 * @param date the date
	 * @return the String
	 */
	public static String transformDateToStringWithoutTime(final Date date) {
		String formattedDate = null;
		try {
			if (It.isNotNull(date)) {
				formattedDate = new SimpleDateFormat(DD_MM_YYYY).format(date);
			}
		} catch (final DateTimeException exception) {
			throw new CustomException(exception);
		}
		return formattedDate;
	}

	/**
	 * Adds days to a date.
	 *
	 * @param date              the date
	 * @param numberOfDaysToAdd the number of days to add
	 * @return the date with added days
	 */
	public static Date addDays(final Date date, final int numberOfDaysToAdd) {
		return org.apache.commons.lang3.time.DateUtils.addDays(date, numberOfDaysToAdd);
	}

	/**
	 * Gets the date without time.
	 *
	 * @param date the date
	 * @return the date without time
	 */
	public static Date getDateWithoutTime(final Date date) {
		Date result = null;
		if (It.isNotNull(date)) {
			final Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);

			result = calendar.getTime();
		}
		return result;
	}
}
