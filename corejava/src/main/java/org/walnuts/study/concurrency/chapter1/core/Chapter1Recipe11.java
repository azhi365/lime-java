package org.walnuts.study.concurrency.chapter1.core;

import java.util.concurrent.TimeUnit;

import org.walnuts.study.concurrency.chapter1.recipe11.Result;
import org.walnuts.study.concurrency.chapter1.recipe11.SearchTask;

/**
 * 线程组
 */
public class Chapter1Recipe11 {

	public static void main(String[] args) {

		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		Result result=new Result();

		SearchTask searchTask=new SearchTask(result);
		for (int i=0; i<5; i++) {
			Thread thread=new Thread(threadGroup, searchTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.printf("Number of Threads: %d\n",threadGroup.activeCount());
		System.out.printf("Information about the Thread Group\n");
		threadGroup.list();

		Thread[] threads=new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for (int i=0; i<threadGroup.activeCount(); i++) {
			System.out.printf("Thread %s: %s\n",threads[i].getName(),threads[i].getState());
		}

		waitFinish(threadGroup);

		threadGroup.interrupt();
	}

	/**
	 * Method that waits for the finalization of one of the ten Thread objects
	 * assigned to the ThreadGroup
	 * @param threadGroup
	 */
	private static void waitFinish(ThreadGroup threadGroup) {
		while (threadGroup.activeCount()>9) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
