package org.cjh.javabasic.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class KeyOrderTest {

	/**
	 * HashMap并不会保证在iterate key值的顺序与put的顺序一致(详见jdk的javadoc)
	 */
	@Test
	public void hashMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		
		Set<String> keys = map.keySet();
		System.out.println("HashMap并不会保证取key值的顺序与put的顺序一致");
		for (String key : keys) {
			System.out.println(key);
		}
	}
	
	/**
	 * LinkedHashMap保证在iterate key值的顺序与put的顺序一致(详见jdk的javadoc)
	 */
	@Test
	public void linkedHashMap() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		
		Set<String> keys = map.keySet();
		System.out.println("LinkedHashMap保证取key值的顺序与put的顺序一致");
		for (String key : keys) {
			System.out.println(key);
		}
	}
}
