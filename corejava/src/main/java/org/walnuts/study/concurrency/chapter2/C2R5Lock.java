package org.walnuts.study.concurrency.chapter2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock同步代码块
 *
 */
public class C2R5Lock {

	public static void main (String args[]){
		
		PrintQueue printQueue=new PrintQueue();
		
		Thread thread[]=new Thread[10];
		for (int i=0; i<10; i++){
			thread[i]=new Thread(new Job(printQueue),"Thread "+i);
		}
		
		for (int i=0; i<10; i++){
			thread[i].start();
		}
	}

	/**
	 * This class simulates a job that send a document to print.
	 */
	public static class Job implements Runnable {


		private PrintQueue printQueue;


		public Job(PrintQueue printQueue) {
			this.printQueue = printQueue;
		}

		@Override
		public void run() {
			System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
			printQueue.printJob(new Object());
			System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
		}
	}

	/**
	 * This class simulates a print queue
	 */
	public static class PrintQueue {

		/**
		 * Lock to control the access to the queue.
		 */
		private final Lock lock = new ReentrantLock();

		/**
		 * Method that prints a document
		 *
		 * @param document document to print
		 */
		public void printJob(Object document) {
			lock.lock();
			try {
				Long duration = (long) (Math.random() * 10000);
				System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), (duration / 1000));
				Thread.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}


}
