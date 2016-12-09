package org.walnuts.study.concurrency.chapter3.core;

import org.walnuts.study.concurrency.chapter3.recipe7.MyPhaser;
import org.walnuts.study.concurrency.chapter3.recipe7.Student;

/**
 * <pre>
 * Phaser 类提供每次phaser改变阶段都会执行的方法。它是 onAdvance() 方法。
 * 它接收2个参数：当前阶段数和注册的参与者数；它返回 Boolean 值，如果phaser继续它的执行，则为 false；否则为真，即phaser结束运行并进入 termination 状态。
 *
 * 如果注册参与者为0，此方法的默认的实现值为真，要不然就是false。如果你扩展Phaser类并覆盖此方法，那么你可以修改它的行为。通常，当你要从一个phase到另一个，来执行一些行动时，你会对这么做感兴趣的。
 *
 * 在这个指南，你将学习如何控制phaser的 phase的改变，通过实现自定义版本的 Phaser类并覆盖 onAdvance() 方法来执行一些每个phase 都会改变的行动。你将要实现一个模拟测验，有些学生要完成他们的练习。全部的学生都必须完成同一个练习才能继续下一个练习。
 * </pre>
 */
public class Chapter1Recipe7 {


	public static void main(String[] args) {
		
		MyPhaser phaser=new MyPhaser();

		Student students[]=new Student[5];
		for (int i=0; i<students.length; i++){
			students[i]=new Student(phaser);
			phaser.register();
		}
		
		Thread threads[]=new Thread[students.length];
		for (int i=0; i<students.length; i++) {
			threads[i]=new Thread(students[i],"Student "+i);
			threads[i].start();
		}
		
		for (int i=0; i<threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("Main: The phaser has finished: %s.\n",phaser.isTerminated());
		
	}

}
