package concurrency.collections;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 使用非阻塞线程安全的列表
 *
 * 非阻塞列表提供这些操作：如果操作不能立即完成（比如，你想要获取列表的元素而列表却是空的），它将根据这个操作抛出异常或返回null值。
 * Java 7引进实现了非阻塞并发列表的ConcurrentLinkedDeque类
 */
public class UseConcurrentLinkedDeque {

    public static void main(String[] args) throws Exception {

        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();

        Thread threads[] = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            AddTask task = new AddTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.printf("Main: %d AddTask threads have been launched\n", threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }


        System.out.printf("Main: Size of the List: %d\n", list.size());

        for (int i = 0; i < threads.length; i++) {
            PollTask task = new PollTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.printf("Main: %d PollTask threads have been launched\n", threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.printf("Main: Size of the List: %d\n", list.size());
    }

    public static class AddTask implements Runnable {


        private ConcurrentLinkedDeque<String> list;


        public AddTask(ConcurrentLinkedDeque<String> list) {
            this.list = list;
        }


        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 10000; i++) {
                list.add(name + ": Element " + i);
            }
        }

    }

    public static class PollTask implements Runnable {

        private ConcurrentLinkedDeque<String> list;


        public PollTask(ConcurrentLinkedDeque<String> list) {
            this.list = list;
        }


        @Override
        public void run() {
            for (int i = 0; i < 5000; i++) {
                list.pollFirst();
                list.pollLast();
            }
        }


    }

}
