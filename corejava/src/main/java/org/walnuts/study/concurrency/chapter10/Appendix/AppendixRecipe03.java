package org.walnuts.study.concurrency.chapter10.Appendix;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AppendixRecipe03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TaskAtomic atomicTask=new TaskAtomic();

		TaskLock lockTask=new TaskLock();
		
		int numberThreads=50;
		Thread threads[]=new Thread[numberThreads];
		Date begin,end;
		
		begin=new Date();
		for (int i=0; i<numberThreads; i++) {
			threads[i]=new Thread(lockTask);
			threads[i].start();
		}

		for (int i=0; i<numberThreads; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		end=new Date();
		
		System.out.printf("Main: Lock results: %d\n",(end.getTime()-begin.getTime()));

		begin=new Date();
		for (int i=0; i<numberThreads; i++) {
			threads[i]=new Thread(atomicTask);
			threads[i].start();
		}

		for (int i=0; i<numberThreads; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		end=new Date();
		
		System.out.printf("Main: Atomic results: %d\n",(end.getTime()-begin.getTime()));
	}

	public static class TaskAtomic implements Runnable {

		private AtomicInteger number;

		public TaskAtomic () {
			this.number=new AtomicInteger();
		}

		@Override
		public void run() {
			for (int i=0; i<1000000; i++) {
				number.set(i);
			}
		}

	}


	public static class TaskLock implements Runnable {

		private Lock lock;
		private int number;

		public TaskLock() {
			this.lock=new ReentrantLock();
		}

		@Override
		public void run() {
			for (int i=0; i<1000000; i++) {
				lock.lock();
				number=i;
				lock.unlock();
			}

		}


	}

}
