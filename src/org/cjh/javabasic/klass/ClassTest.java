package org.cjh.javabasic.klass;

import org.junit.Test;

public class ClassTest {
	
	/**
	 * The primitive Java types (boolean, byte, char, short, int, long, float, and double), 
	 * and the keyword void are also represented as Class objects. 
	 * 
	 * 
	 */
	@Test
	public void primitiveType() {
		System.out.println(boolean.class);
		System.out.println(byte.class);
		System.out.println(char.class);
		System.out.println(short.class);
		System.out.println(int.class);
		System.out.println(long.class);
		System.out.println(float.class);
		System.out.println(double.class);
		System.out.println(void.class);
		
	}
	
	@Test
	public void arrayType() {
		System.out.println(Object[].class);
	}
	

}
