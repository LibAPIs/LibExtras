package com.mclarkdev.tools.libextras;

import java.io.File;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * LibExtras // LibExtrasOS
 * 
 * A collection of tools for working with the Operating System.
 */
public class LibExtrasOS {

	/**
	 * Returns the system host-name.
	 * 
	 * @return system hostname
	 */
	public static String getHostname() {

		try {

			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {

			return "UnKnown";
		}
	}

	/**
	 * Get the home directory of the user.
	 * 
	 * @return user home directory
	 */
	public static String userHome() {

		return System.getProperty("user.home");
	}

	/**
	 * Returns true if running in a Windows environment.
	 * 
	 * @return running on Windows
	 */
	public static boolean isWindows() {

		String os = System.getProperty("os.name").toLowerCase();
		return os.contains("windows");
	}

	/**
	 * Returns true if running in a MacOS environment.
	 * 
	 * @return running on MacOS
	 */
	public static boolean isMacOS() {

		String os = System.getProperty("os.name").toLowerCase();
		return (os.contains("mac") || os.contains("darwin"));
	}

	/**
	 * Returned true if running on an x64 JVM, false if x86.
	 * 
	 * @return running as x86_64
	 */
	public static boolean isX86_64() {

		return System.getProperty("os.arch").contains("64");
	}

	/**
	 * Writes a PID file to the specified path.
	 * 
	 * @param pidPath path of PID file
	 * @param pidFile name of PID file
	 * @return the PID file
	 */
	public static File writePIDFile(String pidPath, String pidFile) {

		File path = new File(pidPath);
		if (!path.exists()) {

			path.mkdirs();
		}

		File file = new File(pidPath, pidFile);
		if (file.exists()) {

			file.delete();
		}

		try {

			PrintWriter writer = new PrintWriter(file, "UTF-8");
			writer.print(Integer.toString(getPID()));
			writer.close();

			return file;
		} catch (Exception e) {

			return null;
		}
	}

	/**
	 * Gets the current PID.
	 * 
	 * @return current PID
	 */
	public static int getPID() {

		String jvmName = ManagementFactory.getRuntimeMXBean().getName();

		String[] parts = jvmName.split("@");

		try {

			return Integer.parseInt(parts[0]);
		} catch (NumberFormatException e) {

		}

		return -1;
	}

	/**
	 * Returns true if the current environment supports signals.
	 * 
	 * @return signals supported
	 */
	public static boolean supportsSignals() {

		if (isWindows()) {
			return false;
		}

		return true;
	}
}
