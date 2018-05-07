package org.cjh.javabasic.filepath;

import java.io.File;
import java.io.IOException;

public class CreateFileTest {			

	public static void main(String[] args) throws IOException {
		String abstractPathname = "D:/temp/temp/hello.txt";
		File f = new File(abstractPathname);
		if (f.isDirectory()) {
			f.mkdirs();
		} else {//regular file, not directory
			File parent = f.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			f.createNewFile(); //create an empty file with the specified name
		}
		
	}
}
