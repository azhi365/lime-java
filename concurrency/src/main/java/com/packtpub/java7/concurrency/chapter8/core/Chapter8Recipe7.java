package com.packtpub.java7.concurrency.chapter8.core;

import java.util.concurrent.locks.ReentrantLock;

import com.packtpub.java7.concurrency.chapter8.recipe07.Task;

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

}
