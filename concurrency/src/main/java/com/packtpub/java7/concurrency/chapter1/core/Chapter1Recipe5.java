package com.packtpub.java7.concurrency.chapter1.core;

import java.util.concurrent.TimeUnit;

import com.packtpub.java7.concurrency.chapter1.recipe5.FileSearch;

/**
 * 操作线程的中断机制
 *
 *
 */
public class Chapter1Recipe5 {

	/**
	 * Main method of the core. Search for the autoexect.bat file
	 * on the Windows root folder and its subfolders during ten seconds
	 * and then, interrupts the Thread
	 * @param args
	 */
	public static void main(String[] args) {
		// Creates the Runnable object and the Thread to run it
		FileSearch searcher=new FileSearch("C:\\","autoexec.bat");
		Thread thread=new Thread(searcher);

		thread.start();

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread.interrupt();
	}

}
