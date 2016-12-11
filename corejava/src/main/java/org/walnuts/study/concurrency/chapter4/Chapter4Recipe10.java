package org.walnuts.study.concurrency.chapter4;

import java.util.concurrent.*;

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

	public static class ExecutableTask implements Callable<String> {


		private String name;


		public ExecutableTask(String name) {
			this.name = name;
		}

		@Override
		public String call() throws Exception {
			try {
				Long duration = (long) (Math.random() * 10);
				System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
				TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
			}
			return "Hello, world. I'm " + name;
		}

		public String getName() {
			return name;
		}
	}


	public static class ResultTask extends FutureTask<String> {
		private String name;

		public ResultTask(Callable<String> callable) {
			super(callable);
			this.name = ((ExecutableTask) callable).getName();
		}

		@Override
		protected void done() {//这个方法在任务的结果设置和它的状态变成isDone状态之后被调用，不管任务是否已经被取消或正常完成
			if (isCancelled()) {
				System.out.printf("%s: Has been cancelled\n", name);
			} else {
				System.out.printf("%s: Has finished\n", name);
			}
		}

	}


}
