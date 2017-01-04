package concurrency.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 运行多个任务并处理所有结果
 */
public class InvokeAll {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Task task = new Task("Task-" + i);
            taskList.add(task);
        }

        List<Future<Result>> resultList = null;
        try {
            resultList = executor.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();

        System.out.printf("Core: Printing the results\n");
        for (int i = 0; i < resultList.size(); i++) {
            Future<Result> future = resultList.get(i);
            try {
                Result result = future.get();
                System.out.printf("%s: %s\n", result.getName(), result.getValue());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Task implements Callable<Result> {


        private String name;


        public Task(String name) {
            this.name = name;
        }


        @Override
        public Result call() throws Exception {
            System.out.printf("%s: Staring\n", this.name);

            try {
                Long duration = (long) (Math.random() * 10);
                System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int value = 0;
            for (int i = 0; i < 5; i++) {
                value += (int) (Math.random() * 100);

            }

            Result result = new Result();
            result.setName(this.name);
            result.setValue(value);
            System.out.printf("%s: Ends\n", this.name);

            return result;
        }

    }


    public static class Result {
        private String name;
        private int value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }

}
