package org.walnuts.study.concurrency.chapter9;


import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Main class of the example. Create ten threads to execute ten
 * task objects and write information about the semaphore
 *
 */
public class Chapter9Recipe06 {

	public static void main(String[] args)throws Exception {
		
		/*
		 * Create a semaphore
		 */
		Semaphore semaphore=new Semaphore(3);
		
		/*
		 * Create an array for ten threads 
		 */
		Thread threads[]=new Thread[10];
		
		/*
		 * Create and launch a thread every 200 milliseconds. After each creation,
		 * show information about the semaphore
		 */
		for (int i=0; i<threads.length; i++) {
			Task task=new Task(semaphore);
			threads[i]=new Thread(task);
			threads[i].start();
			
			TimeUnit.MILLISECONDS.sleep(200);
			
			showLog(semaphore);
		}
		
		/*
		 * Write information about the semaphore five times
		 */
		for (int i=0; i<5; i++) {
			showLog(semaphore);
			TimeUnit.SECONDS.sleep(1);
		}
	}

	/**
	 * Method that writes information about a semaphore
	 * @param semaphore Semaphore to write its log information
	 */
	private static void showLog(Semaphore semaphore) {
		System.out.printf("********************\n");
		System.out.printf("Main: Semaphore Log\n");
		System.out.printf("Main: Semaphore: Avalaible Permits: %d\n",semaphore.availablePermits());
		System.out.printf("Main: Semaphore: Queued Threads: %s\n",semaphore.hasQueuedThreads());
		System.out.printf("Main: Semaphore: Queue Length: %d\n",semaphore.getQueueLength());
		System.out.printf("Main: Semaphore: Fairness: %s\n",semaphore.isFair());
		System.out.printf("********************\n");
	}

	/**
	 * Task used to write information about a Semaphore
	 */
	public static class Task implements Runnable {

		/**
		 * Semaphore shared by all the tasks
		 */
		private Semaphore semaphore;

		/**
		 * Constructor of the class. Initializes its attribute
		 *
		 * @param semaphore Semaphore by all the tasks
		 */
		public Task(Semaphore semaphore) {
			this.semaphore = semaphore;
		}

		/**
		 * Main method of the task. Acquire the semaphore, sleep the thread for
		 * two seconds and release the semaphore
		 */
		@Override
		public void run() {
			try {
            /*
             * Acquire the semaphore and write a message in the console
			 */
				semaphore.acquire();
				System.out.printf("%s: Get the semaphore.\n", Thread.currentThread().getName());
			/*
			 * Sleep the thread
			 */
				TimeUnit.SECONDS.sleep(2);
				System.out.println(Thread.currentThread().getName() + ": Release the semaphore.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
			/*
			 * Release the semaphore and write a message
			 */
				semaphore.release();
			}
		}
	}

}
