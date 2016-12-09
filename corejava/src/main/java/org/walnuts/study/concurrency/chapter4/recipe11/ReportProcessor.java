package org.walnuts.study.concurrency.chapter4.recipe11;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class ReportProcessor implements Runnable {


    private CompletionService<String> service;

    private boolean end;


    public ReportProcessor(CompletionService<String> service) {
        this.service = service;
        end = false;
    }

    @Override
    public void run() {
        while (!end) {
            try {
                //获取CompletionService执行的下个已完成任务的Future对象
                Future<String> result = service.poll(20, TimeUnit.SECONDS);//service.take() take是阻塞方法
                if (result != null) {
                    String report = result.get();
                    System.out.printf("ReportReceiver: Report Recived: %s\n", report);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("ReportSender: End\n");
    }

    public void setEnd(boolean end) {
        this.end = end;
    }


}
