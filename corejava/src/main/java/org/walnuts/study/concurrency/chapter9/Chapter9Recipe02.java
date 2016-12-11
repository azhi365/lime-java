package org.walnuts.study.concurrency.chapter9;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Main class of the example. Creates an object with the statistics of the
 * building and executes two threads that simulates two sensors in the building
 *
 */
public class Chapter9Recipe02 {

	/**
	 * Main method of the example
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Create a new object for the statistics
		BuildStats stats=new BuildStats();

		// Create a Sensor1 object and a Thread to run it
		Sensor1 sensor1=new Sensor1(stats);
		Thread thread1=new Thread(sensor1,"Sensor 1");

		// Create a Sensor 2 object and a Thread to run it
		Sensor2 sensor2=new Sensor2(stats);
		Thread thread2=new Thread(sensor2,"Sensor 2");
		
		// Get the actual time
		Date date1=new Date();
		
		//Starts the threads
		thread1.start();
		thread2.start();
		
		try {
			// Wait for the finalization of the threads
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//Get the actual time and print the execution time
		Date date2=new Date();
		stats.printStats();
		System.out.println("Execution Time: "+((date2.getTime()-date1.getTime())/1000));

	}


	/**
	 *
	 * This class simulates a control class that stores the statistics of
	 * access to a building, controlling the number of people inside the building
	 *
	 */
	public static class BuildStats {

		/**
		 * Number of people inside the building
		 */
		private long numPeople;

		/**
		 * Method that simulates when people come in into the building
		 */
		public /*synchronized*/ void comeIn(){
			System.out.printf("%s: A person enters.\n",Thread.currentThread().getName());
			synchronized(this) {
				numPeople++;
			}
			generateCard();
		}

		/**
		 * Method that simulates when people leave the building
		 */
		public /*synchronized*/ void goOut(){
			System.out.printf("%s: A person leaves.\n",Thread.currentThread().getName());
			synchronized(this) {
				numPeople--;
			}
			generateReport();
		}

		/**
		 * Method that simulates the generation of a card when people come in into the building
		 */
		private void generateCard(){
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


		/**
		 * Method that simulates the generation of a report when people leaves the building
		 */
		private void generateReport(){
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/**
		 * Method that print the number of people inside the building
		 */
		public void printStats(){
			System.out.printf("%d persons in the building.\n",numPeople);
		}

	}

	/**
	 * This class simulates a sensor in the building
	 */
	public static class Sensor1 implements Runnable {

		/**
		 * Object with the statistics of the building
		 */
		private BuildStats stats;

		/**
		 * Constructor of the class
		 * @param stats object with the statistics of the building
		 */
		public Sensor1(BuildStats stats){
			this.stats=stats;
		}

		/**
		 * Core method of the Runnable. Simulates inputs and outputs in the building
		 */
		@Override
		public void run() {
			stats.comeIn();
			stats.comeIn();
			stats.comeIn();
			stats.goOut();
			stats.comeIn();
		}

	}

	/**
	 * This class simulates a sensor in the building
	 */
	public static class Sensor2 implements Runnable {

		/**
		 * Object with the statistics of the building
		 */
		private BuildStats stats;

		/**
		 * Constructor of the class
		 * @param stats object with the statistics of the building
		 */
		public Sensor2(BuildStats stats){
			this.stats=stats;
		}

		/**
		 * Core method of the Runnable. Simulates inputs and outputs in the building
		 */
		@Override
		public void run() {
			stats.comeIn();
			stats.comeIn();
			stats.goOut();
			stats.goOut();
			stats.goOut();
		}

	}

}
