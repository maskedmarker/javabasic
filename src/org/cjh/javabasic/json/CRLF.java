package org.cjh.javabasic.json;

import java.io.InputStream;

public class CRLF {

	public static void main(String[] args) throws Exception {
		
		byte[] bs = getBytesFromClasspath("str.txt");
		System.out.println(new String(bs));
	}

	private static byte[] getBytesFromClasspath(String path) throws Exception {
		InputStream is = CRLF.class.getResourceAsStream(path);
		long size = is.available();
		return null;
	}
}
