package org.cjh.javabasic.syntax.string;

import org.junit.Test;

/**
 * 学习String.inter()方法的定义
 *
 */
public class InternTest {

	/**
	 * String.inter() follows that 
	 * for any two strings s and t, s.intern() == t.intern() is true if and only if s.equals(t) is true. 
	 */
	@Test
	public void intern() {
		String literal = "hello world";
		String constantExpression = "hello " + "world";
		String obj = new String("hello world");
		
		System.out.println(literal.intern());
		System.out.println(constantExpression.intern());
		System.out.println(obj.intern());
		
		System.out.println(literal.intern() == constantExpression.intern());
		System.out.println(obj.intern() == constantExpression.intern());
	}
}
