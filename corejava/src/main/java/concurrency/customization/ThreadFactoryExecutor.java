package concurrency.customization;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 在一个Executor对象中使用自定义的ThreadFactory
 */
public class ThreadFactoryExecutor {


    public static void main(String[] args) throws Exception {


        MyThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");
        ExecutorService executor = Executors.newCachedThreadPool(threadFactory);
        MyTask task = new MyTask();

        executor.submit(task);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);

        System.out.printf("Main: End of the program.\n");


    }


    public static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static class MyThread extends Thread {

        private Date creationDate;
        private Date startDate;
        private Date finishDate;

        public MyThread(Runnable target, String name) {
            super(target, name);
            setCreationDate();
        }

        @Override
        public void run() {
            setStartDate();
            super.run();
            setFinishDate();
            System.out.printf("Thread: %s\n", toString());
        }

        public void setCreationDate() {
            creationDate = new Date();
        }


        public void setStartDate() {
            startDate = new Date();
        }

        public void setFinishDate() {
            finishDate = new Date();
        }


        public long getExecutionTime() {
            long ret;
            ret = finishDate.getTime() - startDate.getTime();
            return ret;
        }


        public String toString() {
            StringBuffer buffer = new StringBuffer();
            buffer.append(getName());
            buffer.append(": ");
            buffer.append(" Creation Date: ");
            buffer.append(creationDate);
            buffer.append(" : Running time: ");
            buffer.append(getExecutionTime());
            buffer.append(" Milliseconds.");
            return buffer.toString();
        }
    }

    public static class MyThreadFactory implements ThreadFactory {

        private int counter;
        private String prefix;

        public MyThreadFactory(String prefix) {
            this.prefix = prefix;
            counter = 1;
        }

        @Override
        public Thread newThread(Runnable r) {
            MyThread myThread = new MyThread(r, prefix + "-" + counter);
            counter++;
            return myThread;
        }
    }


}
