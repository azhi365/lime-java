package com.packtpub.java7.concurrency.chapter3.core;

import com.packtpub.java7.concurrency.chapter3.recipe5.task.Grouper;
import com.packtpub.java7.concurrency.chapter3.recipe5.task.Searcher;
import com.packtpub.java7.concurrency.chapter3.recipe5.utils.MatrixMock;
import com.packtpub.java7.concurrency.chapter3.recipe5.utils.Results;

import java.util.concurrent.CyclicBarrier;

/**
 * 在同一个点同步任务  CyclicBarrier
 */
public class Chapter1Recipe5 {

    public static void main(String[] args) {

        final int rows = 10000;
        final int numbers = 1000;
        final int search = 5;
        final int participants = 5;
        final int linesParticipant = 2000;
        MatrixMock mock = new MatrixMock(rows, numbers, search);

        Results results = new Results(rows);

        Grouper grouper = new Grouper(results);

        CyclicBarrier barrier = new CyclicBarrier(participants, grouper);

        Searcher searchers[] = new Searcher[participants];

        for (int i = 0; i < participants; i++) {
            searchers[i] = new Searcher(i * linesParticipant, (i * linesParticipant) + linesParticipant, mock, results, 5, barrier);
            new Thread(searchers[i]).start();
        }
        System.out.printf("Main: The main thread has finished.\n");
    }

}
