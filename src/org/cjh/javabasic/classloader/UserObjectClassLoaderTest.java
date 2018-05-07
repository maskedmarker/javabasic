package org.cjh.javabasic.classloader;

public class UserObjectClassLoaderTest {

	public static void main(String[] args) {
		MyObject score = new MyObject();
		ClassLoader cl = score.getClass().getClassLoader();
		System.out.println(cl);
		
		if (cl != null) {
			ClassLoader ancestor = null;
			do {
				ancestor = cl.getParent();
				System.out.println(ancestor);
				cl = ancestor;
			} while (ancestor != null);
		} else {
			System.out.println("the class loader of MyObject is null");
		}
	}
	
	private static class MyObject {
		
	}
}
