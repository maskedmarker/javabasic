package org.cjh.javabasic.gc;

public class NoGarbageRetrieve {

	public static void main(String[] args) {
		MyDate date = new MyDate();
		date = null;
	}
}