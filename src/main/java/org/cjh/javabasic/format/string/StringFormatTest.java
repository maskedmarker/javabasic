package org.cjh.javabasic.format.string;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

public class StringFormatTest {

	public static void main(String[] args) throws Exception {
		InputStream in = StringFormatTest.class.getResourceAsStream("log.props");
		Properties prop = new Properties();
		prop.load(in);
		String filePath = (String) prop.get("file");
		System.out.println(new File(filePath).exists());
	}
}
