package com.packtpub.java7.concurrency.chapter4.core;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.packtpub.java7.concurrency.chapter4.recipe7.Task;

/**
 * <pre>
 *  执行者延迟运行一个任务
 *   Task 0: Delay of 1 second
 *   Task 1: Delay of 2 seconds
 *   Task 2: Delay of 3 seconds
 *   Task 3: Delay of 4 seconds
 *   Task 4: Delay of 5 seconds
 * </pre>
 *
 */
public class Chapter4Recipe7 {

	public static void main(String[] args) {


		ScheduledExecutorService executor= Executors.newScheduledThreadPool(1);
		
		System.out.printf("Main: Starting at: %s\n",new Date());
		
		for (int i=0; i<5; i++) {
			Task task=new Task("Task "+i);
			executor.schedule(task,i+1 , TimeUnit.SECONDS);
		}
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("Core: Ends at: %s\n",new Date());
	}
}
