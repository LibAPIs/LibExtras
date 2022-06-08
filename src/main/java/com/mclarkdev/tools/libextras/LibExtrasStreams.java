package com.mclarkdev.tools.libextras;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class LibExtrasStreams {

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

	public static String readFile(File f) throws IOException {

		try (FileInputStream fis = new FileInputStream(f)) {

			return readStream(fis);
		} catch (IOException e) {
			throw e;
		}
	}

	public static void writeFile(File f, byte[] b) throws IOException {

		try (FileOutputStream s = new FileOutputStream(f)) {
			s.write(b);
			s.flush();
		} catch (IOException e) {
			throw e;
		}
	}
}
