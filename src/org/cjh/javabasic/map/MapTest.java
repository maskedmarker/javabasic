package org.cjh.javabasic.map;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapTest {

	/**
	 * 非null的key,采用equals对比来取map中的对应值.
	 * 
	 * More formally, if this map contains a mapping 
	 * from a key k to a value v such that (key==null ? k==null : key.equals(k)), 
	 * then this method returns v; otherwise it returns null. (There can be at most one such mapping.) 
	 */
	@Test
	public void get() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put(10000, "my10000");
		System.out.println(map.get(10000));
	}
}
