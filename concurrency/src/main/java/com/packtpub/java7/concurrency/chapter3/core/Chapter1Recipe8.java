package com.packtpub.java7.concurrency.chapter3.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

import com.packtpub.java7.concurrency.chapter3.recipe8.Consumer;
import com.packtpub.java7.concurrency.chapter3.recipe8.Producer;

/**
 * <pre>
 * Java 并发 API 提供了一种允许2个并发任务间相互交换数据的同步应用。更具体的说，Exchanger 类允许在2个线程间定义同步点，当2个线程到达这个点，他们相互交换数据类型，使用第一个线程的数据类型变成第二个的，然后第二个线程的数据类型变成第一个的。
 *
 * 这个类在遇到类似生产者和消费者问题时，是非常有用的。来一个非常经典的并发问题：你有相同的数据buffer，一个或多个数据生产者，和一个或多个数据消费者。只是Exchange类只能同步2个线程，所以你只能在你的生产者和消费者问题中只有一个生产者和一个消费者时使用这个类。
 *
 * 在这个指南，你将学习如何使用 Exchanger 类来解决只有一个生产者和一个消费者的生产者和消费者问题。
 * </pre>
 */

public class Chapter1Recipe8 {


	public static void main(String[] args) {
		
		List<String> buffer1=new ArrayList<>();
		List<String> buffer2=new ArrayList<>();
		
		Exchanger<List<String>> exchanger=new Exchanger<>();

		new Thread(new Producer(buffer1,exchanger)).start();
		new Thread(new Consumer(buffer2,exchanger)).start();

	}

}
