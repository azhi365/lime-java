package org.walnuts.study.concurrency.Appendix.recipe05.task;

import java.util.concurrent.locks.Lock;

import org.walnuts.study.concurrency.Appendix.recipe05.utils.Operations;

public class Task1 implements Runnable {

	private Lock lock;
	
	public Task1 (Lock lock) {
		this.lock=lock;
	}
	
	@Override
	public void run() {
		lock.lock();
		Operations.readData();
		Operations.processData();
		Operations.writeData();
		lock.unlock();
	}

}
