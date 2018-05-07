package org.cjh.javabasic.codepoint;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class CodePointTest {

	/**
	 * 由于java采用的是Unicode编码字符集,所以在String.codePointAt()返回的是Unicode代码点
	 *
	 */
	@Test
	public void unicodeCodePoint() {
		String str = "汉";
		int codePoint = str.codePointAt(0);
		System.out.println("code point of " + str + ":" + codePoint);
	}

	@Test
	public void codeUnitPair() {
		boolean bmpCharacter = true;
		int codePoint = bmpCharacter ? 0x4E25 : 0x1D706; // 1D706-->d835 df06
		char[] codeUnits = Character.toChars(codePoint);
		StringBuilder codeUnitSb = new StringBuilder();
		for (char i : codeUnits) {
			codeUnitSb = codeUnitSb.append(" ").append(Integer.toHexString((0xFFFF & i)));
		}
		String codeUnitStr = codeUnitSb.toString().substring(1);
		System.out.println("代码点[" + codePoint + "]对应的文字是:" + (new String(codeUnits)));
		
		if (Character.isBmpCodePoint(codePoint)) {
			System.out.println("code point[" + codePoint + "] 是基本代码点,只有一个代码单元code unit:" + codeUnitStr);
		} else {
			System.out.println("code point[" + codePoint + "] 是补充代码点,有多个代码单元code unit:" + codeUnitStr);
		}
	}
	
	/**
	 * code point在不同的编码下,有不同的表达形式.
	 * GBK 采用双字节表示，总体编码范围为 8140-FEFE，首字节在 81-FE 之间，尾字节在 40-FE 之间，剔除 xx7F 一条线。
	 * 
	 * 
	 * String.getBytes(String)返回的是在特定编码下code point的表达形式
	 */
	@Test
	public void representCodePoint() throws UnsupportedEncodingException {
		String charSetName = "utf-8";
//		String charSetName = "gbk";
		String str = "\u4E25";
		int codePoint = str.codePointAt(0);
		System.out.println("code point of " + str + ":" + codePoint);
		// Encodes this String into a sequence of bytes using the named charset
		byte[] ba = str.getBytes(charSetName);
		for (byte b : ba) {
			System.out.println(Integer.toHexString((0xFF & b)));
		}
	}
}
