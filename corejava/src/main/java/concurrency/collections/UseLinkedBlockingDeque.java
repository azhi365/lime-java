package concurrency.collections;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 使用阻塞线程安全的列表
 * 阻塞列表有添加和删除元素的方法，如果由于列表已满或为空而导致这些操作不能立即进行，它们将阻塞调用的线程，直到这些操作可以进行。
 * Java包含实现阻塞列表的LinkedBlockingDeque类
 */
public class UseLinkedBlockingDeque {


    public static void main(String[] args) throws Exception {

        LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(3);

        Client client = new Client(list);
        Thread thread = new Thread(client);
        thread.start();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                String request = list.take();//阻塞
                System.out.printf("Main: Request: %s at %s. Size: %d\n", request, new Date(), list.size());
            }
            TimeUnit.MILLISECONDS.sleep(300);
        }

        System.out.printf("Main: End of the program.\n");

    }

    public static class Client implements Runnable{

        private LinkedBlockingDeque<String> requestList;

        public Client (LinkedBlockingDeque<String> requestList) {
            this.requestList=requestList;
        }

        @Override
        public void run() {
            for (int i=0; i<3; i++) {
                for (int j=0; j<5; j++) {
                    StringBuilder request=new StringBuilder();
                    request.append(i);
                    request.append(":");
                    request.append(j);
                    try {
                        requestList.put(request.toString());//阻塞
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("Client: %s at %s.\n",request,new Date());
                }
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("Client: End.\n");
        }


    }

}
