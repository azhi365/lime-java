package com.packtpub.java7.concurrency.chapter4.core;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.packtpub.java7.concurrency.chapter4.recipe10.ExecutableTask;
import com.packtpub.java7.concurrency.chapter4.recipe10.ResultTask;

/**
 * 执行者控制一个结束任务
 *
 */
public class Chapter4Recipe10 {


	public static void main(String[] args) {
		ExecutorService executor= Executors.newCachedThreadPool();
		ResultTask resultTasks[]=new ResultTask[5];
		for (int i=0; i<5; i++) {
			ExecutableTask executableTask=new ExecutableTask("Task "+i);
			resultTasks[i]=new ResultTask(executableTask);
			executor.submit(resultTasks[i]);
		}
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}


		for (int i=0; i<resultTasks.length; i++) {
			resultTasks[i].cancel(true);
		}
		
		for (int i=0; i<resultTasks.length; i++) {
			try {
				if (!resultTasks[i].isCancelled()){
					System.out.printf("%s\n",resultTasks[i].get());
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} 
		}
		executor.shutdown();

	}

}