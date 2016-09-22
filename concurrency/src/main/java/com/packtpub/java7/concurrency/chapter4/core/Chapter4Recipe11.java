package com.packtpub.java7.concurrency.chapter4.core;

import com.packtpub.java7.concurrency.chapter4.recipe11.ReportProcessor;
import com.packtpub.java7.concurrency.chapter4.recipe11.ReportRequest;

import java.util.concurrent.*;

/**
 * <pre>
 * 执行者分离任务的启动和结果的处理
 * 提交任务给执行者在一个对象中，而处理结果在另一个对象中
 * </pre>
 */
public class Chapter4Recipe11 {


    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        CompletionService<String> service = new ExecutorCompletionService<>(executor);

        ReportRequest faceRequest = new ReportRequest("Face", service);

        ReportRequest onlineRequest = new ReportRequest("Online", service);
        Thread faceThread = new Thread(faceRequest);
        Thread onlineThread = new Thread(onlineRequest);

        ReportProcessor processor = new ReportProcessor(service);
        Thread senderThread = new Thread(processor);

        System.out.printf("Main: Starting the Threads\n");
        faceThread.start();
        onlineThread.start();
        senderThread.start();

        try {
            System.out.printf("Main: Waiting for the report generators.\n");
            faceThread.join();
            onlineThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Shuting down the executor.\n");
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        processor.setEnd(true);
        System.out.printf("Main: Ends\n");

    }

}
