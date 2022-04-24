package com.mclarkdev.tools.libextras;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LibExtrasStreams {

	public static String readFile(File f) throws IOException {

		try (FileInputStream fis = new FileInputStream(f)) {

			int read = 0;
			String out = "";
			byte[] buff = new byte[256];
			while ((read = fis.read(buff)) > 0) {
				out += new String(buff, 0, read);
			}

			return out;
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
