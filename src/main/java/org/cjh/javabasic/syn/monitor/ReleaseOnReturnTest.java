package org.cjh.javabasic.syn.monitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 当前线程获取monitor之后,进入方法体,执行完方法后退出方法,同时释放monitor,然后,等待线程有一个获取monitor.以此类推,直到所有等待的线程都执行完.
 *
 */
public class ReleaseOnReturnTest {

	private static volatile int counter = 0;
	private static final int nThread = 20;
	private static CountDownLatch begin = new CountDownLatch(1);
	private static CountDownLatch end = new CountDownLatch(nThread);
	
	private static synchronized void sendMsg(String msg) {
		counter++;
		System.out.println(msg);
	}
	
	
	private static class Worker extends Thread {
		@Override
		public void run() {
			try {
				begin.await();
				sendMsg(getName());
				end.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<Thread>();
		
		for (int i = 0; i < nThread; i++) {
			Thread sender = new Worker();
			sender.setName("sender" + i);
			sender.start();
			threads.add(sender);
		}
		
		begin.countDown();
		try {
			end.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("counter: " + counter);
	}
}
