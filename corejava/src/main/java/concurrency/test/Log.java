package concurrency.test;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

/**
 * 编写有效的日志
 */
public class Log {


    public static void main(String[] args) {

        Logger logger = MyLogger.getLogger("Core");


        logger.entering("Core", "main()", args);


        Thread threads[] = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            logger.log(Level.INFO, "Launching thread: " + i);
            Task task = new Task();
            threads[i] = new Thread(task);
            logger.log(Level.INFO, "Thread created: " + threads[i].getName());
            threads[i].start();
        }

        logger.log(Level.INFO, "Ten Threads created. Waiting for its finalization");


        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
                logger.log(Level.INFO, "Thread has finished its execution", threads[i]);
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, "Exception", e);
            }
        }


        logger.exiting("Main", "main()");
    }

    public static class Task implements Runnable {


        @Override
        public void run() {

            Logger logger = MyLogger.getLogger(this.getClass().getName());

            logger.entering(Thread.currentThread().getName(), "run()");


            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            logger.exiting(Thread.currentThread().getName(), "run()", Thread.currentThread());
        }
    }


    public static class MyFormatter extends Formatter {


        @Override
        public String format(LogRecord record) {

            StringBuilder sb = new StringBuilder();

            sb.append("[" + record.getLevel() + "] - ");
            sb.append(new Date(record.getMillis()) + " : ");
            sb.append(record.getSourceClassName() + "." + record.getSourceMethodName() + " : ");
            sb.append(record.getMessage() + "\n");

            return sb.toString();
        }
    }

    public static class MyLogger {


        private static Handler handler;

        public static Logger getLogger(String name) {

            Logger logger = Logger.getLogger(name);

            logger.setLevel(Level.ALL);
            try {

                if (handler == null) {
                    handler = new FileHandler("recipe9.log");
                    Formatter format = new MyFormatter();
                    handler.setFormatter(format);
                }

                if (logger.getHandlers().length == 0) {
                    logger.addHandler(handler);
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return logger;
        }

    }


}
