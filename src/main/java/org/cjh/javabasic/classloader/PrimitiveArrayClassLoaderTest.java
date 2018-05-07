package org.cjh.javabasic.classloader;

public class PrimitiveArrayClassLoaderTest {

	public static void main(String[] args) {
		int[] scores = {98, 99, 100};
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
			System.out.println("the class loader of array of primitives is null");
		}
	}
}
