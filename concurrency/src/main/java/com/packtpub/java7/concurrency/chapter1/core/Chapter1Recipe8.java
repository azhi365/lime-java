package com.packtpub.java7.concurrency.chapter1.core;

import java.util.ArrayDeque;
import java.util.Deque;

import com.packtpub.java7.concurrency.chapter1.recipe8.event.Event;
import com.packtpub.java7.concurrency.chapter1.recipe8.task.CleanerTask;
import com.packtpub.java7.concurrency.chapter1.recipe8.task.WriterTask;

/**
 * 守护线程的创建和运行
 */
public class Chapter1Recipe8 {

	public static void main(String[] args) {
		
		Deque<Event> deque=new ArrayDeque<Event>();
		
		WriterTask writer=new WriterTask(deque);
		for (int i=0; i<3; i++){
			Thread thread=new Thread(writer);
			thread.start();
		}
		
		CleanerTask cleaner=new CleanerTask(deque);
		cleaner.start();

	}

}
