package tonipl.constants;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import tonipl.utils.It;

public enum CommonErrors {

	ID_NULL("common.error.id.null"),
	LIST_EMPTY("common.error.list.empty");

	private String error;

	private static final ConcurrentHashMap<String, CommonErrors> ERRORS_MAP = new ConcurrentHashMap<>();



	static {
		for (final CommonErrors error : values()) {
			ERRORS_MAP.put(error.error, error);
		}
	}

	/**
	 * Gets the error Enum.
	 * 
	 * @param error the error.
	 * @return the error Enum.
	 */
	public static synchronized Optional<CommonErrors> getErrorEnum(final String error) {
		CommonErrors errorType = null;
		final CommonErrors errorTypeEnum = ERRORS_MAP.get(error);
		if (!It.isNull(errorTypeEnum)) {
			errorType = errorTypeEnum;
		}
		return Optional.ofNullable(errorType);
	}



	private CommonErrors(final String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}
}
