package org.cjh.javabasic.format.uuid;

import java.util.UUID;

public class UUIDTest {

	public static void main(String[] args) {
		UUID uid = UUID.randomUUID();
		System.out.println(uid.toString());
		System.out.println(uid.toString().replace("-", ""));
		System.out.println(uid.toString().replace("-", "").hashCode());
		
	}
}
