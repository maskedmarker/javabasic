package org.cjh.javabasic.mac;

import java.net.InetAddress;
import java.net.NetworkInterface;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

public class MacTest {

	@Test
	public void getMac() throws Exception {
		InetAddress ia = InetAddress.getLocalHost();  
		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();  
		String macStr = DatatypeConverter.printHexBinary(mac);
		System.out.println(macStr);
	}
}
