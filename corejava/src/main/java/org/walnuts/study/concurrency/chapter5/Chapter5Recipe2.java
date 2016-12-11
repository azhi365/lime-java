package org.walnuts.study.concurrency.chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个Fork/Join池
 */
public class Chapter5Recipe2 {

    public static void main(String[] args) {

        ProductListGenerator generator = new ProductListGenerator();

        List<Product> products = generator.generate(10000);

        Task task = new Task(products, 0, products.size(), 0.20);

        ForkJoinPool pool = new ForkJoinPool();//
        pool.execute(task);

        do {
            System.out.printf("Main: Thread Count: %d\n", pool.getActiveThreadCount());//当前执行任务的线程的数量
            System.out.printf("Main: Thread Steal: %d\n", pool.getStealCount());//worker 线程已经从另一个线程偷取到的时间数
            System.out.printf("Main: Paralelism: %d\n", pool.getParallelism());//池的并行的级别
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());

        pool.shutdown();

        if (task.isCompletedNormally()) {
            System.out.printf("Main: The process has completed normally.\n");
        }

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getPrice() != 12) {
                System.out.printf("Product %s: %f\n", product.getName(), product.getPrice());
            }
        }

        System.out.println("Main: End of the program.\n");

    }

    public static class Task extends RecursiveAction {


        private static final long serialVersionUID = 1L;


        private List<Product> products;

        private int first;
        private int last;

        /**
         * 存储产品价格的增长
         */
        private double increment;

        public Task(List<Product> products, int first, int last, double increment) {
            this.products = products;
            this.first = first;
            this.last = last;
            this.increment = increment;
        }


        @Override
        protected void compute() {
            if (last - first < 10) {
                updatePrices();
            } else {
                int middle = (last + first) / 2;
                //System.out.printf("Task: Pending tasks: %s\n", getQueuedTaskCount());//返回已经提交给池已经开始他们的执行的任务数。
                Task t1 = new Task(products, first, middle + 1, increment);
                Task t2 = new Task(products, middle + 1, last, increment);
                invokeAll(t1, t2);//启动t1,t2
            }
        }

        private void updatePrices() {
            for (int i = first; i < last; i++) {
                Product product = products.get(i);
                product.setPrice(product.getPrice() * (1 + increment));
            }
        }

    }

    public static class ProductListGenerator {

        public List<Product> generate(int size) {
            List<Product> products = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Product product = new Product();
                product.setName("Product " + i);
                product.setPrice(10);
                products.add(product);
            }

            return products;
        }

    }

    public static class Product {

        private String name;
        private double price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }


}
