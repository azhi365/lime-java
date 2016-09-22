package com.packtpub.java7.concurrency.chapter2.core;

import com.packtpub.java7.concurrency.chapter2.recipe5.Job;
import com.packtpub.java7.concurrency.chapter2.recipe5.PrintQueue;

/**
 * 使用Lock同步代码块
 *
 */
public class Chapter2Recipe5 {

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
