package concurrency.executors;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 执行者周期性地运行一个任务
 *
 * 很重要的一点需要考虑的是两次执行之间的（间隔）期间，是这两个执行开始之间的一段时间。如果你有一个花5秒执行的周期性任务，而你给一段3秒时间，同一时刻，你将会有两个任务在执行。
 */
public class ScheduleAtFixedRate {


	public static void main(String[] args) {
		
		ScheduledExecutorService executor=Executors.newScheduledThreadPool(1);
		System.out.printf("Main: Starting at: %s\n",new Date());

		Task task=new Task("Task");
		ScheduledFuture<?> result=executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
		
		for (int i=0; i<10; i++){
			System.out.printf("Main: Delay: %d\n",result.getDelay(TimeUnit.MILLISECONDS)); //返回直到任务的下次执行时间
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		executor.shutdown();
		System.out.printf("Main: No more tasks at: %s\n",new Date());

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: Finished at: %s\n",new Date());
		
	}

	public static class Task implements Runnable {

		private String name;

		public Task(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			System.out.printf("%s: Executed at: %s\n", name, new Date());
		}

	}

}
