package com.packtpub.java7.concurrency.chapter1.core;

import com.packtpub.java7.concurrency.chapter1.recipe13.factory.MyThreadFactory;
import com.packtpub.java7.concurrency.chapter1.recipe13.task.Task;

/**
 * 用线程工厂创建线程
 *
 */
public class Chapter1Recipe13 {

	public static void main(String[] args) {
		MyThreadFactory factory=new MyThreadFactory("MyThreadFactory");
		Task task=new Task();
		Thread thread;
		
		System.out.printf("Starting the Threads\n");
		for (int i=0; i<10; i++){
			thread=factory.newThread(task);
			thread.start();
		}
		System.out.printf("Factory stats:\n");
		System.out.printf("%s\n",factory.getStats());
		
	}

}
