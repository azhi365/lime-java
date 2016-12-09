package org.walnuts.study.concurrency.chapter1.core;

import java.util.Date;

import org.walnuts.study.concurrency.chapter1.recipe7.DataSourcesLoader;
import org.walnuts.study.concurrency.chapter1.recipe7.NetworkConnectionsLoader;

/**
 * 等待线程的终结
 */
public class Chapter1Recipe7 {

	/**
	 * Main method of the class. Create and star two initialization tasks
	 * and wait for their finish
	 * @param args
	 */
	public static void main(String[] args) {

		DataSourcesLoader dsLoader = new DataSourcesLoader();
		Thread thread1 = new Thread(dsLoader,"DataSourceThread");
		thread1.start();

		NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
		Thread thread2 = new Thread(ncLoader,"NetworkConnectionLoader");
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("Main: Configuration has been loaded: %s\n",new Date());
	}
}
