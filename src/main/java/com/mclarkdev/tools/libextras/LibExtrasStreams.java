package com.mclarkdev.tools.libextras;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LibExtrasStreams {

	public static String readFile(File f) throws IOException {

		BufferedReader r = new BufferedReader(new FileReader(f));

		String a = "";
		String l = "";
		while ((l = r.readLine()) != null) {
			a += l;
		}
		r.close();
		return a;
	}
}
