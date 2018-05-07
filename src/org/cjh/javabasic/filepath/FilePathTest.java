package org.cjh.javabasic.filepath;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class FilePathTest {

	@Test
	public void userDir() {
		String dir = System.getProperty("user.dir");
		System.out.println(dir);
	}
	
	/**
	 * 相对路径是相对于user.dir
	 * 
	 * eclipse中测试时，user.dir是当前project的目录
	 */
	@Test
	public void relativePath() {
		String dir = System.getProperty("user.dir");
		System.out.println(dir);
		File f = new File("filepath.txt");
		System.out.println(f.exists());
	}
	
	@Test
	public void pathNormalized0() {
		File f = new File("D:\\eclipse\\workspace\\hello\\\\javabasic\\filepath.txt"); //将abstract pathname 标准化
		String normalizedPath = f.getPath();
		System.out.println(normalizedPath);
	}
	
	@Test
	public void pathNormalized1() {
		File f = new File("");
		String normalizedPath = f.getPath();
		System.out.println(normalizedPath);
	}
	
	/**
	 * File.getPath()不可靠,会丢失盘符标识。建议使用File.getCanonicalPath() 
	 */
	@Test
	public void pathNormalized10() {
		File parent = new File("");
		File f = new File(parent, "hello.txt");
		String normalizedPath = f.getPath(); //\hello.txt
		System.out.println(normalizedPath);
		
		System.out.println(f.exists());
	}
	
	@Test
	public void pathNormalized12() throws IOException {
		File parent = new File("");
		File f = new File(parent, "hello.txt");
		String canonicalPath = f.getCanonicalPath();
		System.out.println(canonicalPath); //D:\hello.txt
		
		System.out.println(f.exists());
	}
	
}
