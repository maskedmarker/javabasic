package org.cjh.javabasic.classloader;

public class ClassLoaderHirarchyTest {

	public static void main(String[] args) {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		System.out.println(cl);
		if (cl != null) {
			ClassLoader ancestor = null;
			do {
				ancestor = cl.getParent();
				System.out.println(ancestor);
				cl = ancestor;
			} while (ancestor != null);
		} else {
			System.out.println("the class loader of main class is null");
		}
	}
}
