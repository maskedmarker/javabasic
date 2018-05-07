package org.cjh.javabasic.props;

import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class SystemPropsTest {

	@Test
	public void fileSeparator() {
		String key = "file.separator";
		String val = System.getProperty(key);
		System.out.println(val);
	}
	
	@Test
	public void pathSeparator() {
		String key = "path.separator";
		String val = System.getProperty(key);
		System.out.println(val);
	}
	
	@Test
	public void sysProps() {
		Properties props = System.getProperties();
		Set<Entry<Object, Object>> entries = props.entrySet();
		for (Map.Entry<Object, Object> entry : entries) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
	
	@Test
	public void envVariables() {
		Map<String, String> envsMap = System.getenv();
		Set<Entry<String, String>> entries = envsMap.entrySet();
		for (Map.Entry<String, String> entry : entries) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
}
