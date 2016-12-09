package org.walnuts.study.concurrency.chapter5.recipe02.task;

import org.walnuts.study.concurrency.chapter5.recipe02.util.Product;

import java.util.List;
import java.util.concurrent.RecursiveAction;


public class Task extends RecursiveAction {


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
