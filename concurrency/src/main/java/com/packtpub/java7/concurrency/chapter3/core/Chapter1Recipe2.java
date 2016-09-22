package com.packtpub.java7.concurrency.chapter3.core;

import com.packtpub.java7.concurrency.chapter3.recipe2.Job;
import com.packtpub.java7.concurrency.chapter3.recipe2.PrintQueue;

/**
 * 控制并发访问资源 Semaphore
 *
 */
public class Chapter1Recipe2 {

	public static void main (String args[]){
		
		PrintQueue printQueue=new PrintQueue();
		
		Thread thread[]=new Thread[10];
		for (int i=0; i<10; i++){
			thread[i]=new Thread(new Job(printQueue),"Thread "+i);
		}
		
		for (int i=0; i<10; i++){
			thread[i].start();
		}
	}

}
