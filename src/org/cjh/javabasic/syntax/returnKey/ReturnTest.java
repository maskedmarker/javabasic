package org.cjh.javabasic.syntax.returnKey;

import org.junit.Test;

/**
 * break是跳出当前循环体,return跳出当前方法体
 *
 */
public class ReturnTest {

	@Test
	public void returnBlock() {
		long start = System.currentTimeMillis();
		long idleSecond = 2;
		long delaySecond = 5;
		
		while (true) {
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println(".");
				if (System.currentTimeMillis() > start + idleSecond * 1000) {
					break;
//					return; //Unreachable code
				}
			}
			if (System.currentTimeMillis() > start + delaySecond * 1000) {
				System.out.println("...");
				return;
			}
		}
	}
}
