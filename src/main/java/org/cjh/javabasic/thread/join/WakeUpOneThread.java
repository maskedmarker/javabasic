package org.cjh.javabasic.thread.join;

/**
 * Thread.join()导致调用线程等待.join方法体中实际调用了该线程实例的wait方法.
 * 当线程结束时,线程的notifyAll会被VM调用,用来唤醒那些因调用该线程实例的join方法的线程.
 * notifyAll虽然只能让一个线程恢复active,一旦这个线程跳出了同步代码块或者重新wait,都会再次释放monitor,其他的线程依次这样恢复active
 *
 */
public class WakeUpOneThread {

	public static void main(String[] args) {
		final Thread worker = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(10 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("worker complete");
			}
			
		});
		
		Thread managerA = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					worker.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("managerA complete");
			}
			
		});
		Thread managerB = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					worker.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("managerB complete");
			}
			
		});
		
		worker.start();
		managerA.start();
		managerB.start();
		
		System.out.println("main end");
		
		
	}
	
}	
