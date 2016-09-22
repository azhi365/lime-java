package com.packtpub.java7.concurrency.chapter2.core;

import com.packtpub.java7.concurrency.chapter2.recipe4.Consumer;
import com.packtpub.java7.concurrency.chapter2.recipe4.EventStorage;
import com.packtpub.java7.concurrency.chapter2.recipe4.Producer;

/**
 * 在同步代码中使用条件 生产者-消费者
 */
public class Chapter2Recipe4 {


	public static void main(String[] args) {
		
		EventStorage storage=new EventStorage();
		
		Producer producer=new Producer(storage);
		Thread thread1=new Thread(producer);

		Consumer consumer=new Consumer(storage);
		Thread thread2=new Thread(consumer);
		
		thread2.start();
		thread1.start();
	}

}
