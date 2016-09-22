package com.packtpub.java7.concurrency.chapter1.core;

import com.packtpub.java7.concurrency.chapter1.recipe10.UnsafeTask;

import java.util.concurrent.TimeUnit;


/**
 * 使用本地线程变量
 */
public class Chapter1Recipe10UnSafe {

	public static void main(String[] args) {
		UnsafeTask task=new UnsafeTask();
		
		for (int i=0; i<3; i++){
			Thread thread=new Thread(task);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
