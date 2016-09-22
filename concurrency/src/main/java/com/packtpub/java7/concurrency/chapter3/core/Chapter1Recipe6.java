package com.packtpub.java7.concurrency.chapter3.core;

import com.packtpub.java7.concurrency.chapter3.recipe6.FileSearch;

import java.util.concurrent.Phaser;

/**
 * <pre>
 * Java 并发 API 提供的一个非常复杂且强大的功能是，能够使用Phaser类运行阶段性的并发任务。当某些并发任务是分成多个步骤来执行时，那么此机制是非常有用的。Phaser类提供的机制是在每个步骤的结尾同步线程，所以除非全部线程完成第一个步骤，否则线程不能开始进行第二步。
 * 相对于其他同步应用，我们必须初始化Phaser类与这次同步操作有关的任务数，我们可以通过增加或者减少来不断的改变这个数。
 *
 * 在这个指南，你将学习如果使用Phaser类来同步3个并发任务。这3个任务会在3个不同的文件夹和它们的子文件夹中搜索扩展名是.log并在24小时内修改过的文件。这个任务被分成3个步骤：
 * 1. 在指定的文件夹和子文件夹中获得文件扩展名为.log的文件列表。
 * 2. 过滤第一步的列表中修改超过24小时的文件。
 * 3. 在操控台打印结果。
 * 在步骤1和步骤2的结尾我们要检查列表是否为空。如果为空，那么线程直接结束运行并从phaser类中淘汰。
 * </pre>
 */
public class Chapter1Recipe6 {


    public static void main(String[] args) {

        Phaser phaser = new Phaser(3);

        FileSearch system = new FileSearch("C:\\Windows", "log", phaser);
        FileSearch apps = new FileSearch("C:\\Program Files", "log", phaser);
        FileSearch documents = new FileSearch("C:\\Documents And Settings", "log", phaser);

        Thread systemThread = new Thread(system, "System");
        systemThread.start();

        Thread appsThread = new Thread(apps, "Apps");
        appsThread.start();

        Thread documentsThread = new Thread(documents, "Documents");
        documentsThread.start();
        try {
            systemThread.join();
            appsThread.join();
            documentsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Terminated: %s\n", phaser.isTerminated());
    }

}
