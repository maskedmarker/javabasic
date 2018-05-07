package org.cjh.javabasic.syntax.bitoperator;

import org.junit.Test;

/**
 * 左移时最右补0,右移有有符和无符之分,注意这个最主要的区分点
 * 
 *
 */
public class BitOperatorTest {

	/**
	 * 左移时最右补0
	 */
	@Test
	public void leftShift() {
		int val = 0b1001111;
		int newVal = val << 3;
		System.out.println(Integer.toBinaryString(newVal)); //0b1001111_000
	}
	
	/**
	 * 右移时最左补符号位的值
	 */
	@Test
	public void rightShift() {
		int val = (byte)0b10101_010; //-86
		int newVal = val >> 3;
		System.out.println(Integer.toBinaryString(val));
		System.out.println(Integer.toBinaryString(newVal));
	}
	
	/**
	 * 右移时最左补0
	 */
	@Test
	public void rightShiftWithoutFlag() {
		int val = (byte)0b10101_010; //-86
		int newVal = val >>> 3;
		System.out.println(Integer.toBinaryString(val));
		System.out.println(Integer.toBinaryString(newVal));
	}
}
