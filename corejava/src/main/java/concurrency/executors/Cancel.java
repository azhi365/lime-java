package concurrency.executors;

import java.util.concurrent.*;

/**
 * 执行者取消任务
 */
public class Cancel {


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

	public static class Task implements Callable<String> {

		@Override
		public String call() throws Exception {
			while (true) {
				System.out.printf("Task: Test\n");
				Thread.sleep(100);
			}
		}
	}

}
