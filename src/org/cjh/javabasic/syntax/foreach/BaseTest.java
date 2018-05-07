package org.cjh.javabasic.syntax.foreach;

public class BaseTest {

	public static void main(String[] args) {
//		nullable();
		empty();
	}

	private static void nullable() {
		String[] strs = null;
		for (String string : strs) { //会报null pointer异常
			System.out.println(string);
		}
	}
	
	private static void empty() {
		String[] strs = new String[0];
//		System.out.println(strs.length);
		for (String string : strs) { //不会报null pointer异常
			System.out.println(string);
		}
	}
}
