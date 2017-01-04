package concurrency.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 执行者执行返回结果的任务:
 * 调用Future对象的get()方法，并且这个对象控制的任务未完成，这个方法会阻塞直到任务完成
 */
public class UseFuture {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        List<Future<Integer>> resultList = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            Integer number = new Integer(random.nextInt(10));
            FactorialCalculator calculator = new FactorialCalculator(number);
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }

        do {
            System.out.printf("Main: Number of Completed Tasks: %d\n", executor.getCompletedTaskCount());
            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> result = resultList.get(i);
                System.out.printf("Main: Task %d: %s\n", i, result.isDone());
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (executor.getCompletedTaskCount() < resultList.size());


        System.out.printf("Main: Results\n");
        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            Integer number = null;
            try {
                number = result.get(); //阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("Core: Task %d: %d\n", i, number);
        }

        executor.shutdown();

    }

    public static class FactorialCalculator implements Callable<Integer> {


        private Integer number;


        public FactorialCalculator(Integer number) {
            this.number = number;
        }


        @Override
        public Integer call() throws Exception {
            int num, result;

            num = number.intValue();
            result = 1;

            if ((num == 0) || (num == 1)) {
                result = 1;
            } else {
                for (int i = 2; i <= number; i++) {
                    result *= i;
                    Thread.sleep(20);
                }
            }
            System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);
            return result;
        }
    }

}
