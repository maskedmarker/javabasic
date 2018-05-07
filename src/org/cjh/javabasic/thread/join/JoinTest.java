package org.cjh.javabasic.thread.join;



public class JoinTest {

	public static void main(String[] args) {
		Thread worker = new Worker();
		Thread manager = new Manager(worker);
		manager.start();
		
		Thread.State state = manager.getState();
		while (!Thread.State.WAITING.equals(state)) {
			System.out.println("main wait");
		}
		worker.start();
		
		System.out.println("main done");
	}
}
