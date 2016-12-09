package org.walnuts.study.concurrency.chapter2.core;

import org.walnuts.study.concurrency.chapter2.recipe6.PricesInfo;
import org.walnuts.study.concurrency.chapter2.recipe6.Reader;
import org.walnuts.study.concurrency.chapter2.recipe6.Writer;

/**
 * 使用读/写锁来同步数据访问
 */
public class Chapter2Recipe6 {


    public static void main(String[] args) {

        PricesInfo pricesInfo = new PricesInfo();

        Reader readers[] = new Reader[5];
        Thread threadsReader[] = new Thread[5];
        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(pricesInfo);
            threadsReader[i] = new Thread(readers[i]);
        }


        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);
        for (int i = 0; i < 5; i++) {
            threadsReader[i].start();
        }
        threadWriter.start();

    }

}
