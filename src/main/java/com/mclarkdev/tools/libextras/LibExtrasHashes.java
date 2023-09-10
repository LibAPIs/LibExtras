package com.mclarkdev.tools.libextras;

import java.security.MessageDigest;

/**
 * LibExtras // LibExtrasHashes
 * 
 * A collection of tools for generating checksums.
 */
public class LibExtrasHashes {

	/**
	 * Generate an MD5 checksum of the given string.
	 * 
	 * @param in raw data
	 * @return md5 checksum
	 */
	public static String sumMD5(String in) {
		return sumMD5(in.getBytes());
	}

	/**
	 * Generate an MD5 checksum of the given byte array.
	 * 
	 * @param in raw data
	 * @return md5 checksum
	 */
	public static String sumMD5(byte[] in) {

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return LibExtrasStrings.bytesToHex(md.digest(in));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Generate a SHA-256 checksum of the given string..
	 * 
	 * @param in raw data
	 * @return md5 checksum
	 */
	public static String sumSHA256(String in) {
		return sumSHA256(in.getBytes());
	}

	/**
	 * Generate a SHA-256 checksum of the given byte array.
	 * 
	 * @param in raw data
	 * @return md5 checksum
	 */
	public static String sumSHA256(byte[] in) {

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			return LibExtrasStrings.bytesToHex(md.digest(in));
		} catch (Exception e) {
			return null;
		}
	}
}
