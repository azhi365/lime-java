package com.packtpub.java7.concurrency.chapter7.core;

import com.packtpub.java7.concurrency.chapter7.recipe11.ParkingCounter;
import com.packtpub.java7.concurrency.chapter7.recipe11.Sensor1;
import com.packtpub.java7.concurrency.chapter7.recipe11.Sensor2;

/**
 * 实现自定义的原子对象
 */
public class Chapter7Recipe11 {

    public static void main(String[] args) throws Exception {

        ParkingCounter counter = new ParkingCounter(5);

        Sensor1 sensor1 = new Sensor1(counter);
        Sensor2 sensor2 = new Sensor2(counter);

        Thread thread1 = new Thread(sensor1);
        Thread thread2 = new Thread(sensor2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.printf("Main: Number of cars: %d\n", counter.get());
        System.out.printf("Main: End of the program.\n");
    }
}
