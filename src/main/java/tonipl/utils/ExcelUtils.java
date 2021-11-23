package tonipl.utils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

/**
 * Excel utils.
 */
public class ExcelUtils {

	public static final String CONTENT_TYPE_XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	public static final String CONTENT_TYPE_XLS = "application/vnd.ms-excel";

	private ExcelUtils() {
	}



	/**
	 * Gets the cell value of a row from column name.
	 * 
	 * Mapper key stores the column name.
	 * Mapper value stores the column number.
	 *
	 * @param row                       the row
	 * @param name                      the name
	 * @param columnNumbersByColumnName the map that stores the column names and
	 *                                  numbers
	 * @return the cell value
	 */
	public static String getCellValueFromColumnName(final Row row, final String name,
			final ConcurrentMap<String, Integer> columnNumbersByColumnName) {

		return getCellValue(row, columnNumbersByColumnName.get(name));
	}

	/**
	 * Gets the cell value of a row from column number.
	 *
	 * @param row    the row
	 * @param column the column number 0-based
	 * @return the cell value as String
	 */
	public static String getCellValue(final Row row, final int column) {
		String result = null;

		if (It.isNotNull(row)) {
			final Cell cell = row.getCell(column);

			if (It.isNotNull(cell)) {
				switch (cell.getCellType()) {
					case STRING:
						result = row.getCell(column).getStringCellValue();
						break;
	
					case NUMERIC:
						result = String.valueOf(row.getCell(column).getNumericCellValue());
						break;
	
					case BOOLEAN:
						result = String.valueOf(row.getCell(column).getBooleanCellValue());
						break;
	
					default:
						return StringUtils.EMPTY;
				}
			}
		}
		return result;
	}



	/**
	 * Checks if a cell is of type String.
	 *
	 * Mapper key stores the column name.
	 * Mapper value stores the column number.
	 *
	 * @param row                       the row
	 * @param name                      the name
	 * @param columnNumbersByColumnName the map that stores the column names and
	 *                                  numbers
	 * @return true if it is a String cell, false otherwise
	 */
	public static boolean isStringCell(final Row row, final String name,
			final ConcurrentMap<String, Integer> columnNumbersByColumnName) {

		return isStringCell(row, columnNumbersByColumnName.get(name));
	}

	/**
	 * Checks if a cell is of type String.
	 *
	 * @param row    the row
	 * @param column the column number 0-based
	 * @return true if it is a String cell, false otherwise
	 */
	public static boolean isStringCell(final Row row, final int column) {
		boolean isNumeric = false;
		if (It.isNotNull(row)) {
			final Cell cell = row.getCell(column);
			isNumeric = It.isNotNull(cell) && CellType.STRING.equals(cell.getCellType());
		}
		return isNumeric;
	}



	/**
	 * Creates a new BigDecimal cell in a row.
	 *
	 * @param row          the row
	 * @param columnNumber the column number
	 * @param value        the value
	 */
	public static void createCell(final Row row, final int columnNumber, final BigDecimal value) {
		if (It.isNotNull(value)) {
			row.createCell(columnNumber).setCellValue(value.doubleValue());
		}
	}

	/**
	 * Creates a new String cell in a row.
	 *
	 * @param row          the row
	 * @param columnNumber the column number
	 * @param value        the value
	 */
	public static void createCell(final Row row, final int columnNumber, final String value) {
		if (It.isNotNull(value)) {
			row.createCell(columnNumber).setCellValue(value);
		}
	}

	/**
	 * Creates a new Boolean cell in a row.
	 *
	 * @param row          the row
	 * @param columnNumber the column number
	 * @param value        the value
	 */
	public static void createCell(final Row row, final int columnNumber, final Boolean value) {
		if (It.isNotNull(value)) {
			row.createCell(columnNumber).setCellValue(value);
		}
	}

	/**
	 * Creates a new Long cell in a row.
	 *
	 * @param row          the row
	 * @param columnNumber the column number
	 * @param value        the value
	 */
	public static void createCell(final Row row, final int columnNumber, final Long value) {
		if (It.isNotNull(value)) {
			row.createCell(columnNumber).setCellValue(value);
		}
	}

	/**
	 * Creates a new Date cell without time in a row.
	 *
	 * @param row          the row
	 * @param columnNumber the column number
	 * @param value        the value
	 */
	public static void createCell(final Row row, final int columnNumber, final Date value) {
		if (It.isNotNull(value)) {
			row.createCell(columnNumber).setCellValue(DateUtils.transformDateToStringWithoutTime(value));
		}
	}
}
