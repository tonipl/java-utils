package tonipl.constants;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import tonipl.utils.It;

public enum FileErrors {

	CANNOT_DELETE_FILE("file.error.file.cannot.delete"),
	CONTENT_NULL("file.error.content.null"),
	FILENAME_NULL("file.error.filename.null"),
	PATH_NOT_EXIST("file.error.path.not.exist"),
	PATH_NULL("file.error.path.null"),
	MIMEMESSAGE_FILE_NULL("file.error.mimemessage.null"),
	MULTIPART_FILE_NULL("file.error.multipart.null"),
	RESOURCE("file.error.resource.null"),
	TARGET_CLASS_NULL("file.error.target.class.null");

	private String error;

	private static final ConcurrentHashMap<String, FileErrors> ERRORS_MAP = new ConcurrentHashMap<>();



	static {
		for (final FileErrors error : values()) {
			ERRORS_MAP.put(error.error, error);
		}
	}

	/**
	 * Gets the error Enum.
	 * 
	 * @param error the error.
	 * @return the error Enum.
	 */
	public static synchronized Optional<FileErrors> getErrorEnum(final String error) {
		FileErrors errorType = null;
		final FileErrors errorTypeEnum = ERRORS_MAP.get(error);
		if (!It.isNull(errorTypeEnum)) {
			errorType = errorTypeEnum;
		}
		return Optional.ofNullable(errorType);
	}



	private FileErrors(final String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}
}
