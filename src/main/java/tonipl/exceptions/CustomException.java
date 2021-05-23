package tonipl.exceptions;

/**
 * Class to be used for custom exceptions.
 *
 */
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = -7539823261901984533L;

	private String[] params;

	/**
	 * Constructor for a new custom exception.
	 */
    public CustomException() {
        super();
        params = null;
    }

	/**
	 * Constructor for a new custom exception with a cause.
	 *
	 * @param cause the cause
	 */
    public CustomException(final Throwable cause) {
        super(cause);
        params = null;
    }

	/**
	 * Constructor for a new custom exception with a message a cause.
	 *
	 * @param message the message
	 * @param cause   the cause
	 */
	public CustomException(final String message, final Throwable cause) {
        super(message, cause);
        params = null;
    }

	/**
	 * Constructor for a new custom exception with a message.
	 *
	 * @param message the message
	 */
	public CustomException(final String message) {
        super(message);
        params = null;
    }

	/**
	 * Constructor for a new custom exception with a message and params.
	 *
	 * @param message the message
	 * @param params  the params
	 */
	public CustomException(final String message, final String... params) {
        super(message);
        this.params = params;
    }

	/**
	 * Constructor for a new custom exception with a cause, a message and params.
	 *
	 * @param cause   the cause
	 * @param message the message
	 * @param params  the params
	 */
	public CustomException(final Throwable cause, final String message, final String... params) {
        super(message, cause);
        this.params = params;
    }

	/**
	 * Gets the params.
	 *
	 * @return the params
	 */
	public String[] getParams() {
		return params;
	}

	/**
	 * Sets the params.
	 *
	 * @param params the params
	 */
	public void setParams(final String[] params) {
		this.params = params;
	}
}
