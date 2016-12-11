package org.walnuts.study.concurrency.chapter1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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

	/**
	 * Class that simulates an initialization operation. It sleeps during four seconds
	 *
	 */
	public static class DataSourcesLoader implements Runnable {

		@Override
		public void run() {
			System.out.printf("Begining data sources loading: %s\n",new Date());
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.printf("Data sources loading has finished: %s\n",new Date());
		}
	}

	/**
	 * Class that simulates an initialization operation. It sleeps during six seconds
	 *
	 */
	public static class NetworkConnectionsLoader implements Runnable {

		@Override
		public void run() {
			System.out.printf("Begining network connections loading: %s\n",new Date());

			try {
				TimeUnit.SECONDS.sleep(6);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("Network connections loading has finished: %s\n",new Date());
		}
	}

}
