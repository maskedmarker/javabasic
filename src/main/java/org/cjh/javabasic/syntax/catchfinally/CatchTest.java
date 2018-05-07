package org.cjh.javabasic.syntax.catchfinally;

import java.util.Random;


/**
 * 学习catch-finally执行流程
 *
 */
public class CatchTest {

	public static void main(String[] args) {
//		int result = catchFinally();
//		int result = catchFinally1();
		int result = catchFinally2();
		System.out.println("result: " + result);
	}
	
	
	@SuppressWarnings("finally")
	private static int catchFinally() {
		int result = -1;
		Random rd = new Random();
		int rdNumber = rd.nextInt(10);
		System.out.println("rdNumber:" + rdNumber);
		try {
			result = rdNumber % 2 == 0 ? (rdNumber) : (rdNumber / 0);
			System.out.println("calc complete");
			return result;
		} catch (Exception e) {
			System.out.println("in catch block");
			result = - 100;
			return result;
		} finally {
			System.out.println("in finally block");
			result = -10000;
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	private static int catchFinally1() {
		int result = -1;
		Random rd = new Random();
		int rdNumber = rd.nextInt(2);
		System.out.println("rdNumber:" + rdNumber);
		try {
			result = rdNumber % 2 == 0 ? (rdNumber) : (rdNumber / 0);
			System.out.println("calc complete");
			return result;
		} catch (Exception e) {
			System.out.println("in catch block");
			result = - 100;
			return result;
		} finally {
			System.out.println("in finally block");
			result = -10000;
//			return result;
		}
	}
	
	@SuppressWarnings("finally")
	private static int catchFinally2() {
		int result = -1;
		Random rd = new Random();
		int rdNumber = rd.nextInt(2);
		System.out.println("rdNumber:" + rdNumber);
		try {
			result = rdNumber % 2 == 0 ? (rdNumber) : (rdNumber / 0);
			System.out.println("calc complete");
		} catch (Exception e) {
			System.out.println("in catch block");
			result = - 100;
			throw new ArithmeticException("/0");
		} finally {
			System.out.println("in finally block");
			result = -10000;
//			return result;
		}
		return result;
	}
}
