package com.innstack.lime.test.java.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在方法中使用Lock，可以避免使用Synchronized关键字。
 */
public class Locker {

	Lock lock = new ReentrantLock();
	double value = 0d;
	int addtimes = 0;

	/**
	 * 增加value的值，该方法的操作分为2步，而且相互依赖，必须实现在一个事务中
	 * 所以该方法必须同步，以前的做法是在方法声明中使用Synchronized关键字。
	 */
	public void addValue(double v) {
		lock.lock();

		System.out.println("LockTest to addValue: " + v + "   " + System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		this.value += v;
		this.addtimes++;

		lock.unlock();
	}

	public double getValue() {
		return this.value;
	}
}