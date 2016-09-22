package com.packtpub.java7.concurrency.chapter1.recipe7;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Class that simulates an initialization operation. It sleeps during four seconds
 *
 */
public class DataSourcesLoader implements Runnable {

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
