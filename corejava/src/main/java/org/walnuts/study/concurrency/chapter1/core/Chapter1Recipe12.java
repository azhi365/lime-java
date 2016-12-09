package org.walnuts.study.concurrency.chapter1.core;

import org.walnuts.study.concurrency.chapter1.recipe12.group.MyThreadGroup;
import org.walnuts.study.concurrency.chapter1.recipe12.task.Task;

/**
 * 处理线程组内的不受控制异常
 *
 */
public class Chapter1Recipe12 {

	public static void main(String[] args) {

		MyThreadGroup threadGroup=new MyThreadGroup("MyThreadGroup");
		Task task=new Task();
		for (int i=0; i<2; i++){
			Thread t=new Thread(threadGroup,task);
			t.start();
		}
	}

}
