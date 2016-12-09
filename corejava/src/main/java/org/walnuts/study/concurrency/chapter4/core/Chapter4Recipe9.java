package org.walnuts.study.concurrency.chapter4.core;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.walnuts.study.concurrency.chapter4.recipe9.Task;

/**
 * 执行者取消任务
 */
public class Chapter4Recipe9 {


	public static void main(String[] args) {
		
		ThreadPoolExecutor executor=(ThreadPoolExecutor)Executors.newCachedThreadPool();
		
		Task task=new Task();
		
		System.out.printf("Main: Executing the Task\n");

		Future<String> result=executor.submit(task);
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: Cancelling the Task\n");
		result.cancel(true);//取消一个任务
		System.out.printf("Main: Cancelled: %s\n",result.isCancelled());
		System.out.printf("Main: Done: %s\n",result.isDone());
		
		executor.shutdown();
		System.out.printf("Main: The executor has finished\n");
	}

}
