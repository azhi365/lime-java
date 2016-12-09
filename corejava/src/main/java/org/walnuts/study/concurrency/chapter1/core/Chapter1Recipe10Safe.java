package org.walnuts.study.concurrency.chapter1.core;

import org.walnuts.study.concurrency.chapter1.recipe10.SafeTask;

import java.util.concurrent.TimeUnit;


/**
 * 使用本地线程变量
 */
public class Chapter1Recipe10Safe {

	public static void main(String[] args) {
		SafeTask task=new SafeTask();
		for (int i=0; i<3; i++){
			Thread thread=new Thread(task);
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			thread.start();
		}

	}

}
