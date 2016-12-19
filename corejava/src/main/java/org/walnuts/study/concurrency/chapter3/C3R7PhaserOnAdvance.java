package org.walnuts.study.concurrency.chapter3;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

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
public class C3R7PhaserOnAdvance {


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

	public static class Student implements Runnable {


		private Phaser phaser;

		public Student(Phaser phaser) {
			this.phaser=phaser;
		}

		public void run() {
			System.out.printf("%s: Has arrived to do the exam. %s\n",Thread.currentThread().getName(),new Date());
			phaser.arriveAndAwaitAdvance();
			System.out.printf("%s: Is going to do the first exercise. %s\n",Thread.currentThread().getName(),new Date());
			doExercise1();
			System.out.printf("%s: Has done the first exercise. %s\n",Thread.currentThread().getName(),new Date());
			phaser.arriveAndAwaitAdvance();
			System.out.printf("%s: Is going to do the second exercise. %s\n",Thread.currentThread().getName(),new Date());
			doExercise2();
			System.out.printf("%s: Has done the second exercise. %s\n",Thread.currentThread().getName(),new Date());
			phaser.arriveAndAwaitAdvance();
			System.out.printf("%s: Is going to do the third exercise. %s\n",Thread.currentThread().getName(),new Date());
			doExercise3();
			System.out.printf("%s: Has finished the exam. %s\n",Thread.currentThread().getName(),new Date());
			phaser.arriveAndAwaitAdvance();
		}


		private void doExercise1() {
			try {
				Long duration=(long)(Math.random()*10);
				TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


		private void doExercise2() {
			try {
				Long duration=(long)(Math.random()*10);
				TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		private void doExercise3() {
			try {
				Long duration=(long)(Math.random()*10);
				TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


	}

	public static class MyPhaser extends Phaser {

		@Override
		protected boolean onAdvance(int phase, int registeredParties) {
			switch (phase) {
				case 0:
					return studentsArrived();
				case 1:
					return finishFirstExercise();
				case 2:
					return finishSecondExercise();
				case 3:
					return finishExam();
				default:
					return true;
			}
		}

		private boolean studentsArrived() {
			System.out.printf("Phaser: The exam are going to start. The students are ready.\n");
			System.out.printf("Phaser: We have %d students.\n", getRegisteredParties());
			return false;
		}

		private boolean finishFirstExercise() {
			System.out.printf("Phaser: All the students has finished the first exercise.\n");
			System.out.printf("Phaser: It's turn for the second one.\n");
			return false;
		}

		private boolean finishSecondExercise() {
			System.out.printf("Phaser: All the students has finished the second exercise.\n");
			System.out.printf("Phaser: It's turn for the third one.\n");
			return false;
		}

		private boolean finishExam() {
			System.out.printf("Phaser: All the students has finished the exam.\n");
			System.out.printf("Phaser: Thank you for your time.\n");
			return true;
		}

	}



}
