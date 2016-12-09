package org.walnuts.study.concurrency.chapter2.recipe8.task;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class implements a buffer to stores the simulate file lines between the
 * producer and the consumers
 * 
 */
public class Buffer {

	/**
	 * The buffer
	 */
	private LinkedList<String> buffer;

	/**
	 * Size of the buffer
	 */
	private int maxSize;

	/**
	 * Lock to control the access to the buffer
	 */
	private ReentrantLock lock;

	/**
	 * Conditions to control that the buffer has lines and has empty space
	 */
	private Condition lines;
	private Condition space;

	/**
	 * Attribute to control where are pending lines in the buffer
	 */
	private boolean pendingLines;

	public Buffer(int maxSize) {
		this.maxSize = maxSize;
		buffer = new LinkedList<>();
		lock = new ReentrantLock();
		lines = lock.newCondition();
		space = lock.newCondition();
		pendingLines = true;
	}

	public void insert(String line) {
		lock.lock();
		try {
			while (buffer.size() == maxSize) {
				space.await();
			}
			buffer.offer(line);
			System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread()
					.getName(), buffer.size());
			lines.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public String get() {
		String line=null;
		lock.lock();		
		try {
			while ((buffer.size() == 0) &&(hasPendingLines())) {
				lines.await();
			}
			
			if (hasPendingLines()) {
				line = buffer.poll();
				System.out.printf("%s: Line Readed: %d\n",Thread.currentThread().getName(),buffer.size());
				space.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return line;
	}


	public void setPendingLines(boolean pendingLines) {
		this.pendingLines = pendingLines;
	}


	public boolean hasPendingLines() {
		return pendingLines || buffer.size() > 0;
	}

}
