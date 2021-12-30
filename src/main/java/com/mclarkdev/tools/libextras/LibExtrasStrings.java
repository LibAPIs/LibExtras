
package com.mclarkdev.tools.libextras;

import java.security.MessageDigest;

public class LibExtrasStrings {

	public static String generateChecksum(byte[] in) {

		try {

			MessageDigest md = MessageDigest.getInstance("MD5");
			return bytesToHex(md.digest(in));
		} catch (Exception e) {

			return null;
		}
	}

	/**
	 * Pad a number with leading zeros such that the entire number is equal to the
	 * given character count.
	 * 
	 * @param num
	 * @return
	 */
	public static String leadingZeros(int num, int charCount) {

		if (num < 0 || charCount < 0) {

			throw new IllegalArgumentException("supports positive numbers only");
		}

		String numString = Integer.toString(num);
		for (int x = 1; x < charCount; x += 1) {

			if (num < Math.pow(10, x)) {

				numString = "0" + numString;
			}
		}

		return numString;
	}

	/**
	 * Convert a byte array to a hexadecimal string.
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToHex(byte[] bytes) {

		if (bytes == null) {

			throw new IllegalArgumentException("supplied value cannot be null");
		}

		char[] hexArray = "0123456789ABCDEF".toCharArray();

		char[] hexChars = new char[bytes.length * 2];

		for (int j = 0; j < bytes.length; j++) {

			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

	/**
	 * Convert a hexadecimal string to a byte array.
	 * 
	 * @param s
	 * @return
	 */
	public static byte[] hexToBytes(String s) {

		if (s == null) {

			throw new IllegalArgumentException("input cannot be null");
		}

		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {

			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	/**
	 * Reverse a string.
	 * 
	 * @param string
	 * @return
	 */
	public static String reverseString(String string) {

		return reverseString(string, 1);
	}

	/**
	 * Reverse a string with a given group count of characters.
	 * 
	 * @param string
	 * @param groupCount
	 * @return
	 */
	public static String reverseString(String string, int groupCount) {

		if (string == null) {

			throw new IllegalArgumentException("Input can not be null.");
		}

		if (groupCount <= 0) {

			throw new IllegalArgumentException("Group count must be a positive integer.");
		}

		if (string.length() % groupCount != 0) {

			throw new IllegalArgumentException("Invalid group count for specified string.");
		}

		StringBuilder builder = new StringBuilder();
		for (int x = string.length(); x > 0; x -= groupCount) {

			builder.append(string.substring(x - groupCount, x));
		}

		return builder.toString();
	}

	/**
	 * Returns true if the provided string is Base64 encoded.
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isBase64(String s) {

		String pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
		return s.matches(pattern);
	}
}
