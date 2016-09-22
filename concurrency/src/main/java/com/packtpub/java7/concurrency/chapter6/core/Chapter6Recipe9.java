package com.packtpub.java7.concurrency.chapter6.core;

import java.util.concurrent.atomic.AtomicIntegerArray;

import com.packtpub.java7.concurrency.chapter6.recipe09.Decrementer;
import com.packtpub.java7.concurrency.chapter6.recipe09.Incrementer;

/**
 *
 * 使用原子 arrays
 *
 * <pre>
 *     当你实现一个多个线程共享一个或者多个对象的并发应用时，你就要使用像锁或者同步关键词（例如synchronized）来对他们的属性的访问进行保护，来避免并发造成的数据不一致的错误。
 *     但是这些机制会有以下一些缺点：
 *     死锁(dead lock)
 *     即使只有一个线程在访问共享对象，它也要执行必要的获取锁和释放锁的代码。
 *
 *     CAS(compare-and-swap)操作为并发操作对象的提供更好的性能，CAS操作通过以下3个步骤来实现对变量值得修改：
 *     获取当前内存中的变量的值
 *     用一个新的临时变量(temporal variable)保存改变后的新值
 *     如果当前内存中的值等于变量的旧值，则将新值赋值到当前变量；否则不进行任何操作
 *
 *     对于这个机制，你不需要使用任何同步机制，这样你就避免了 deadlocks，也获得了更好的性能。这种机制能保证多个并发线程对一个共享变量操作做到最终一致。
 *
 * </pre>
 *
 *
 */
public class Chapter6Recipe9 {


	public static void main(String[] args) {

		final int THREADS=100;


		AtomicIntegerArray vector=new AtomicIntegerArray(1000);

		Incrementer incrementer=new Incrementer(vector);
		Decrementer decrementer=new Decrementer(vector);
		

		Thread threadIncrementer[]=new Thread[THREADS];
		Thread threadDecrementer[]=new Thread[THREADS];
		for (int i=0; i<THREADS; i++) {
			threadIncrementer[i]=new Thread(incrementer);
			threadDecrementer[i]=new Thread(decrementer);
			
			threadIncrementer[i].start();
			threadDecrementer[i].start();
		}
		
		for (int i=0; i<THREADS; i++) {
			try {
				threadIncrementer[i].join();
				threadDecrementer[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for (int i=0; i<vector.length(); i++) {
			if (vector.get(i)!=0) {
				System.out.println("Vector["+i+"] : "+vector.get(i));
			}
		}
		
		System.out.println("Main: End of the example");
	}

}
