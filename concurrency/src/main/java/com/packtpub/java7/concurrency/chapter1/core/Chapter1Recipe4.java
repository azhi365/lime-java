package com.packtpub.java7.concurrency.chapter1.core;

import java.util.concurrent.TimeUnit;

import com.packtpub.java7.concurrency.chapter1.recipe4.PrimeGenerator;

/**
 *
 * 线程的中断
 *
 * isInterrupted()和interrupted() 方法有着很重要的区别。
 * 第一个不会改变interrupted属性值，但是第二个会设置成false。
 * interrupted() 方法是一个静态方法，建议使用isInterrupted()方法。
 *
 *  Main class of the sample. Launch the PrimeGenerator, waits
 *  five seconds and interrupts the Thread
 */
public class Chapter1Recipe4 {

	/**
	 * Main method of the sample. Launch the PrimeGenerator, waits
	 * five seconds and interrupts the Thread
	 * @param args
	 */
	public static void main(String[] args) {

		// Launch the prime numbers generator
		Thread thread=new PrimeGenerator();
		thread.start();
		
		// Wait 5 seconds
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Interrupt the prime number generator
		thread.interrupt();
	}

}
