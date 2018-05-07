package org.cjh.javabasic.thread.join;


class Worker extends Thread{

	@Override
	public void run() {
		System.out.println("worker is doing job");
		System.out.println("worker done");
	}
}
