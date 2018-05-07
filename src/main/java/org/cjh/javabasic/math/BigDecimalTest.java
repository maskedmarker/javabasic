package org.cjh.javabasic.math;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.Test;

public class BigDecimalTest {

	public static void main(String[] args) {
		BigDecimal d = new BigDecimal(3);
		BigDecimal result = BigDecimal.ONE.divide(d, 8, BigDecimal.ROUND_HALF_UP);
		System.out.println(result);
		DecimalFormat df =new DecimalFormat("#####.00000000"); 
		String formattedString = df.format(result.doubleValue());
		System.out.println(formattedString);
	}
	
	/**
	 * BigDecimal描述的值为精确值， 结果值为无限循环小数，BigDecimal无法精确描述，会报错。
	 * 
	 * throws ArithmeticException if the exact quotient does not have a terminating decimal expansion
	 */
	@Test
	public void infiniteDivide() {
		BigDecimal d = new BigDecimal(3);
		BigDecimal result = BigDecimal.ONE.divide(d);
		System.out.println(result.toString());
	}
	
	/**
	 * 除法容易产生结果为无线循环小数，乘法是否可以制造出无线循环小数呢？
	 * 不会的，因为乘数都是有限精确值，结果必然是有限值。
	 */
	@Test
	public void infiniteMultiple() {
		double a = 4887233385.5;
		double b = 0.85;

		System.out.println("result1-->" + a * b); // result1-->4.1541483776749997E9

		BigDecimal a1 = new BigDecimal(a);
		BigDecimal b1 = new BigDecimal(b);

		System.out.println("result2-->" + a1.multiply(b1));// result2-->4154148377.674999891481619无限不循环
	}
	
	@Test
	public void infinite2() {
		BigDecimal d = new BigDecimal(3);
		BigDecimal result = BigDecimal.ONE.divide(d, 8, BigDecimal.ROUND_HALF_UP);
		System.out.println(result.toString());
	}
	
	@Test
	public void unaccurate() {
		BigDecimal a = BigDecimal.ONE;
		BigDecimal b = new BigDecimal(10);
		BigDecimal result = a.divide(b, 8, BigDecimal.ROUND_HALF_UP);
		System.out.println(result);
		System.out.println(1.0/10.0);
	}
	
	@Test
	public void formate() {
		BigDecimal a = new BigDecimal("0.1");
		a.setScale(8, BigDecimal.ROUND_HALF_UP);
		System.out.println(a.toString());
	}
	
	
}
