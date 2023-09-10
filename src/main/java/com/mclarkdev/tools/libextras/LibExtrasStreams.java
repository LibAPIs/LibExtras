package com.mclarkdev.tools.libextras;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * LibExtras // LibExtrasStreams
 * 
 * A collection of tools for working with Streams.
 */
public class LibExtrasStreams {

	/**
	 * Read a complete InputSteam for its contents.
	 * 
	 * @param in the input stream
	 * @return the data read
	 * @throws IOException failure opening stream
	 */
	public static String readStream(InputStream in) throws IOException {

		int read = 0;
		String out = "";
		byte[] buff = new byte[256];
		while ((read = in.read(buff)) > 0) {
			out += new String(buff, 0, read);
		}
		in.close();

		return out;
	}

	/**
	 * Read a complete File for its contents.
	 * 
	 * @param f the input file
	 * @return the data read
	 * @throws IOException failure opening file
	 */
	public static String readFile(File f) throws IOException {

		try (FileInputStream fis = new FileInputStream(f)) {

			return readStream(fis);
		} catch (IOException e) {
			throw e;
		}
	}

	/**
	 * Write the given contents to a file.
	 * 
	 * @param f the output file
	 * @param b the data to write
	 * @throws IOException failure writing file
	 */
	public static void writeFile(File f, byte[] b) throws IOException {

		try (FileOutputStream s = new FileOutputStream(f)) {
			s.write(b);
			s.flush();
		} catch (IOException e) {
			throw e;
		}
	}
}
