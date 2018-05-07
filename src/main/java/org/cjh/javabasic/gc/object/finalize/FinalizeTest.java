package org.cjh.javabasic.gc.object.finalize;

import java.util.Date;

/**
 * Objedt.finalize()方法在对象不被引用时,即被GC回收时会被触发.
 *
 */
public class FinalizeTest {

	private static class MyObject {

		@Override
		protected void finalize() throws Throwable {
			Date now = new Date();
			System.out.println("MyObject object is finalizing at " + now.toString());
		}
	}
	public static void main(String[] args) {
	
		MyObject mo = null;
		for (int i = 0; i < 10000; i++) {
			mo = new MyObject();
		}
		
		System.gc();
		System.out.println("main method exits");
	}
}
