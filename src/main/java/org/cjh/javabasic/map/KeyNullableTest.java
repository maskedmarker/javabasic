package org.cjh.javabasic.map;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.junit.Test;

public class KeyNullableTest {

	@Test
	public void map() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put(null, "myValue");
		System.out.println(map.get(null));
	}
	
	@Test
	public void dictionary() {
		Dictionary<Object, Object> dict = new Hashtable<Object, Object>();
		dict.put(null, "myValue"); //NullPointerException
		System.out.println(dict.get(null));
	}
}
