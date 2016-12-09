package org.walnuts.study.concurrency.chapter1.core;

import java.util.concurrent.TimeUnit;

import org.walnuts.study.concurrency.chapter1.recipe6.FileClock;

/**
 * 线程的睡眠和恢复
 *
 * 当 Thread is是睡眠和中断的时候，那方法会立刻抛出InterruptedException异常并不会一直等到睡眠时间过去。
 *
 */
public class Chapter1Recipe6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread thread=new Thread(new FileClock());
		thread.start();

		try {
			// Waits five seconds
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		// Interrupts the Thread
		thread.interrupt();
	}
}
