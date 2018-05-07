package org.cjh.javabasic.syn.notify;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * 通过实现简单的生产者-消费者模式,来展示wait/notify的应用
 *
 */
public class SynchronizedTest {

	private static final Object lock = new Object();
	private static final int MAX_SIZE = 10;
	private static final List<String> buffer = new ArrayList<String>();
	
	private static final int PRODUCE_MAX_TIME = 1000;
	private static final int CONSUME_MAX_TIME = 2000;
	
	private static class Producer implements Runnable {

		private String name;
		public Producer(String name) {
			this.name = name;
		}
		
		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				doProduce();
			}
		}

		private void doProduce() {
			synchronized (lock) {
				while (buffer.size() >= MAX_SIZE) {
					try {
						System.out.println(name + " wait");
						lock.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						break;
					}
				}
				
				if (Thread.currentThread().isInterrupted()) {
					System.out.println(name + " was interrupted");
					lock.notifyAll();
					return;
				}
				
				Random rd = new Random();
				int delay = rd.nextInt(PRODUCE_MAX_TIME);
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					// ignore
				}
				buffer.add(Calendar.getInstance().toString());
				System.out.println(name + " produces");
				lock.notifyAll();
			}
		}
	}
	
	private static class Consumer implements Runnable {
		private String name;
		public Consumer(String name) {
			this.name = name;
		}
		
		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				doConsume();
			}
		}

		private void doConsume() {
			synchronized (lock) {
				while (buffer.isEmpty()) {
					try {
						System.out.println(name + " wait");
						lock.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						break;
					}
				}
				
				if (!Thread.currentThread().isInterrupted()) {
					System.out.println(name + " was interrupted");
					lock.notifyAll();
					return;
				}
				Random rd = new Random();
				int delay = rd.nextInt(CONSUME_MAX_TIME);
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					// ignore
				}
				buffer.remove(buffer.size() - 1);
				System.out.println(name + " consumes");
				lock.notifyAll();
			}
		}
	}
	
	//TODO 只能保证一个生产者.多个生产者程序会出问题
	public static void main(String[] args) {
		Producer producer1 = new Producer("P001");
		new Thread(producer1).start();
//		Producer producer2 = new Producer("P002");
//		new Thread(producer2).start();
		int nConsumer = 10;
		for (int i = 0; i < nConsumer; i++) {
			new Thread(new Consumer("C" + i)).start();
		}
	}
	
}
