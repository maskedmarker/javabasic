package org.cjh.javabasic.compare;

public class StringTest {

	public static void main(String[] args) {
		//of equal length
		String s1 = "12";
		String s2 = "13";
		int result = s1.compareTo(s2);
		System.out.println(result);
		
		//of non equal length
		s1 = "12";
		s2 = "132";
		result = s1.compareTo(s2);
		System.out.println(result);
		
		s1 = "12";
		s2 = "13";
		result = s1.compareTo(s2);
		System.out.println(result);
	}
}
