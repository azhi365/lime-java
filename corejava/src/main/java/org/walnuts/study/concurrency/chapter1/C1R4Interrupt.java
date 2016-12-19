package org.walnuts.study.concurrency.chapter1;

import java.util.concurrent.TimeUnit;

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
public class C1R4Interrupt {

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


	/**
	 * This class generates prime numbers until is interrumped
	 */
	public static class PrimeGenerator extends Thread {

		/**
		 * Central method of the class
		 */
		@Override
		public void run() {
			long number = 1L;

			// This bucle never ends... until is interrupted
			while (true) {
				if (isPrime(number)) {
					System.out.printf("Number %d is Prime\n", number);
				}

				if (isInterrupted()) {
					System.out.printf("The Prime Generator has been Interrupted\n");
					return;
				}
				number++;
			}
		}

		/**
		 * Method that calculate if a number is prime or not
		 *
		 * @param number : The number
		 * @return A boolean value. True if the number is prime, false if not.
		 */
		private boolean isPrime(long number) {
			if (number <= 2) {
				return true;
			}
			for (long i = 2; i < number; i++) {
				if ((number % i) == 0) {
					return false;
				}
			}
			return true;
		}

	}

}
