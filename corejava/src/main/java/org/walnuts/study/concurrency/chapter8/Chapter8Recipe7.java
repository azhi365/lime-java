package org.walnuts.study.concurrency.chapter8;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用 FindBugs 分析并发代码
 */
public class Chapter8Recipe7 {

	public static void main(String[] args) {

		ReentrantLock lock=new ReentrantLock();
		
		/*
		 * Executes the threads. There is a problem with this
		 * block of code. It uses the run() method instead of
		 * the start() method.
		 */
		for (int i=0; i<10; i++) {
			Task task=new Task(lock);
			Thread thread=new Thread(task);
			thread.run();
		}

	}

	public static class Task implements Runnable {


		private ReentrantLock lock;


		public Task(ReentrantLock lock) {
			this.lock = lock;
		}

		@Override
		public void run() {
			lock.lock();

			try {
				TimeUnit.SECONDS.sleep(1);

				lock.unlock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}


}
