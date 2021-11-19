package tonipl.utils;

/**
 * Class related to the application operating system.
 */
public class OperatingSystem {

	private static final String OPERATING_SYSTEM = System.getProperty("os.name").toLowerCase();

	private OperatingSystem() {
	}

	/**
	 * Checks if the application is running on a Microsoft Windows server.
	 *
	 * @return true if it is Microsoft Windows, false otherwise
	 */
	public static boolean isWindows() {
		return OPERATING_SYSTEM.indexOf("win") >= 0;

	}

	/**
	 * Checks if the application is running on a Mac server.
	 *
	 * @return true if it is Mac, false otherwise
	 */
	public static boolean isMac() {
		return OPERATING_SYSTEM.indexOf("mac") >= 0;

	}

	/**
	 * Checks if the application is running on a Unix server.
	 *
	 * @return true if it is Unix, false otherwise
	 */
	public static boolean isUnix() {
		return OPERATING_SYSTEM.indexOf("nix") >= 0 || OPERATING_SYSTEM.indexOf("nux") >= 0
				|| OPERATING_SYSTEM.indexOf("aix") >= 0;

	}

	/**
	 * Checks if the application is running on a Solaris server.
	 *
	 * @return true if it is Solaris, false otherwise
	 */
	public static boolean isSolaris() {
		return OPERATING_SYSTEM.indexOf("sunos") >= 0;
	}
}
