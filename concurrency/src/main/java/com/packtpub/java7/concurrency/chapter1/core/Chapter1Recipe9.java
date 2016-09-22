package com.packtpub.java7.concurrency.chapter1.core;

import com.packtpub.java7.concurrency.chapter1.recipe9.handler.ExceptionHandler;
import com.packtpub.java7.concurrency.chapter1.recipe9.task.Task;

/**
 *
 * 处理线程的不受控制异常
 *
 */
public class Chapter1Recipe9 {

	/**
	 * Main method of the example. Initialize a Thread to process the
	 * uncaught exceptions and starts a Task object that always throws an
	 * exception 
	 * @param args
	 */
	public static void main(String[] args) {
		Task task=new Task();
		Thread thread=new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Thread has finished\n");

	}

}
