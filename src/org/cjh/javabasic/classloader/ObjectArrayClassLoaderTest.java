package org.cjh.javabasic.classloader;

public class ObjectArrayClassLoaderTest {
	
	public static void main(String[] args) {
		Object[] scores = {new Integer(98), new Integer(99), new Integer(100)};
		ClassLoader cl = scores.getClass().getClassLoader();
		System.out.println(cl);
		
		if (cl != null) {
			ClassLoader ancestor = null;
			do {
				ancestor = cl.getParent();
				System.out.println(ancestor);
				cl = ancestor;
			} while (ancestor != null);
		} else {
			System.out.println("the class loader of array of Object is null");
		}
	}
}
