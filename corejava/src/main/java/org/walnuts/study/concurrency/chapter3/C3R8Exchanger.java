package org.walnuts.study.concurrency.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * <pre>
 * Java 并发 API 提供了一种允许2个并发任务间相互交换数据的同步应用。更具体的说，Exchanger 类允许在2个线程间定义同步点，当2个线程到达这个点，他们相互交换数据类型，使用第一个线程的数据类型变成第二个的，然后第二个线程的数据类型变成第一个的。
 *
 * 这个类在遇到类似生产者和消费者问题时，是非常有用的。来一个非常经典的并发问题：你有相同的数据buffer，一个或多个数据生产者，和一个或多个数据消费者。只是Exchange类只能同步2个线程，所以你只能在你的生产者和消费者问题中只有一个生产者和一个消费者时使用这个类。
 *
 * 在这个指南，你将学习如何使用 Exchanger 类来解决只有一个生产者和一个消费者的生产者和消费者问题。
 * </pre>
 */

public class C3R8Exchanger {


	public static void main(String[] args) {
		
		List<String> buffer1=new ArrayList<>();
		List<String> buffer2=new ArrayList<>();
		
		Exchanger<List<String>> exchanger=new Exchanger<>();

		new Thread(new Producer(buffer1,exchanger)).start();
		new Thread(new Consumer(buffer2,exchanger)).start();

	}


	public static class Producer implements Runnable {

		private final Exchanger<List<String>> exchanger;
		private List<String> buffer;


		public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
			this.buffer = buffer;
			this.exchanger = exchanger;
		}

		@Override
		public void run() {
			int cycle = 1;

			for (int i = 0; i < 1; i++) {
				System.out.printf("Producer: Cycle %d\n", cycle);

				for (int j = 0; j < 10; j++) {
					String message = "Event " + ((i * 10) + j);
					System.out.printf("Producer: %s\n", message);
					buffer.add(message);
				}

				try {
					buffer = exchanger.exchange(buffer);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.printf("Producer: %d\n", buffer.size());

				cycle++;
			}

		}


	}

	public static class Consumer implements Runnable {

		private final Exchanger<List<String>> exchanger;
		private List<String> buffer;


		public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
			this.buffer = buffer;
			this.exchanger = exchanger;
		}


		@Override
		public void run() {
			int cycle = 1;

			for (int i = 0; i < 1; i++) {
				System.out.printf("Consumer: Cycle %d\n", cycle);

				try {
					buffer = exchanger.exchange(buffer);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.printf("Consumer: %d\n", buffer.size());

				for (int j = 0; j < 10; j++) {
					String message = buffer.get(0);
					System.out.printf("Consumer: %s\n", message);
					buffer.remove(0);
				}

				cycle++;
			}

		}

	}

}
