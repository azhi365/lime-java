package org.walnuts.study.concurrency.chapter10.Appendix;

import java.util.Date;
import java.util.concurrent.*;

public class AppendixRecipe08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[]=new int[100000];
		Task task=new Task(array);
		ThreadPoolExecutor executor=(ThreadPoolExecutor)Executors.newCachedThreadPool();
		
		Date start,end;
		start=new Date();
		executor.execute(task);
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		end=new Date();
		System.out.printf("Main: Executor: %d\n",(end.getTime()-start.getTime()));
		
		TaskFJ taskFJ=new TaskFJ(array,1,100000);
		ForkJoinPool pool=new ForkJoinPool();
		start=new Date();
		pool.execute(taskFJ);
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		end=new Date();
		System.out.printf("Core: Fork/Join: %d\n",(end.getTime()-start.getTime()));
		
	}

	public static class Task implements Runnable {

		private int array[];

		public Task(int array[]) {
			this.array=array;
		}

		@Override
		public void run() {
			for (int i=0; i<array.length; i++ ){
				array[i]++;
				try {
					TimeUnit.MILLISECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}


	public static class TaskFJ extends RecursiveAction {


		private static final long serialVersionUID = 1L;
		private int array[];
		private int start, end;

		public TaskFJ(int array[], int start, int end) {
			this.array=array;
			this.start=start;
			this.end=end;
		}

		@Override
		protected void compute() {
			if (end-start>1000) {
				int mid=(start+end)/2;
				TaskFJ task1=new TaskFJ(array,start,mid);
				TaskFJ task2=new TaskFJ(array,mid,end);
				task1.fork();
				task2.fork();
				task1.join();
				task2.join();
			} else {
				for (int i=start; i<end; i++) {
					array[i]++;
					try {
						TimeUnit.MILLISECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}
