package org.cjh.javabasic.classloader;

public class ObjectClassLoaderTest {

	public static void main(String[] args) {
		Object score = new Integer(99);
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
			System.out.println("the class loader of Object is null");
		}
	}
}
