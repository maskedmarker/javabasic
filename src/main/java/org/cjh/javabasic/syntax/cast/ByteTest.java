package org.cjh.javabasic.syntax.cast;

import org.junit.Test;

public class ByteTest {

	/**
	 * java代码中书写整型常量时,byte/short无法直接书写,必须通过强制类型转换来初始化byte/short变量
	 * 因为书写出来的常量会被当做是int类型或者是long类型
	 * @throws Exception 
	 */
	@Test
	public void byteShort() {
		// 必须通过强制类型转换来为byte/short类型变量初始化
		byte b = (byte) 0b1111_0100; //-12
		System.out.println(b);
		System.out.println(Integer.toBinaryString(b));
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("汉子");
		byte[] bs = "汉子".getBytes("ascii");
		for (byte bb : bs) {
			System.out.print(Integer.toHexString(bb & 0xFF));
		}
	}
}
