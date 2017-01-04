package concurrency.executors;

import java.util.concurrent.*;

/**
 * <pre>
 * 执行者分离任务的启动和结果的处理
 * 提交任务给执行者在一个对象中，而处理结果在另一个对象中
 * </pre>
 */
public class CompletionService {


    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        java.util.concurrent.CompletionService<String> service = new ExecutorCompletionService<>(executor);

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

    public static class ReportProcessor implements Runnable {


        private java.util.concurrent.CompletionService<String> service;

        private boolean end;


        public ReportProcessor(java.util.concurrent.CompletionService<String> service) {
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

    public static class ReportRequest implements Runnable {


        private String name;


        private java.util.concurrent.CompletionService<String> service;


        public ReportRequest(String name, java.util.concurrent.CompletionService<String> service) {
            this.name = name;
            this.service = service;
        }


        @Override
        public void run() {
            ReportGenerator reportGenerator = new ReportGenerator(name, "Report");
            service.submit(reportGenerator);
        }

    }


    public static class ReportGenerator implements Callable<String> {

        private String sender;
        private String title;

        public ReportGenerator(String sender, String title) {
            this.sender = sender;
            this.title = title;
        }

        @Override
        public String call() throws Exception {
            try {
                Long duration = (long) (Math.random() * 10);
                System.out.printf("%s_%s: ReportGenerator: Generating a report during %d seconds\n", this.sender, this.title, duration);
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String ret = sender + ": " + title;
            return ret;
        }
    }

}
