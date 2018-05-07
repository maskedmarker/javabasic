package org.cjh.javabasic.thread.join;



class Manager extends Thread{
	
	private Thread worker;
	
	public Manager(Thread worker) {
		this.worker = worker;
	}
	
	@Override
	public void run() {
		try {
			worker.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}
		System.out.println(getClass() + "done");
	}
}
