package org.cjh.javabasic.reflection;

import java.lang.reflect.Method;

public class ReflectionTest {

	
	private static Object invoke(String className, String methodName) throws Exception {
		Class<?> clazz = Class.forName(className);
		Method m = clazz.getMethod(methodName, new Class<?>[]{});
		Object o = clazz.newInstance();
		return m.invoke(o, new Object[]{});
	}
	
	private static Object invoke1(Object instance, String methodName) throws Exception {
		Class<?> clazz = instance.getClass();
		Method m = clazz.getMethod(methodName, new Class<?>[]{});
		return m.invoke(instance, new Object[]{});
	}
	
	
	public static void main(String[] args) throws Exception {
		// 入参都是字符串
		invoke("javabasic.reflection.FooA", "foo");
		// 入参一个对象,一个字符串
		FooA a = new FooA();
		invoke1(a, "foo");
	}
}
