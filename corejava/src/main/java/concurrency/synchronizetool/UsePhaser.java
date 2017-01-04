package concurrency.synchronizetool;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Java 并发 API 提供的一个非常复杂且强大的功能是，能够使用Phaser类运行阶段性的并发任务。当某些并发任务是分成多个步骤来执行时，那么此机制是非常有用的。Phaser类提供的机制是在每个步骤的结尾同步线程，所以除非全部线程完成第一个步骤，否则线程不能开始进行第二步。
 * 相对于其他同步应用，我们必须初始化Phaser类与这次同步操作有关的任务数，我们可以通过增加或者减少来不断的改变这个数。
 *
 * 在这个指南，你将学习如果使用Phaser类来同步3个并发任务。这3个任务会在3个不同的文件夹和它们的子文件夹中搜索扩展名是.log并在24小时内修改过的文件。这个任务被分成3个步骤：
 * 1. 在指定的文件夹和子文件夹中获得文件扩展名为.log的文件列表。
 * 2. 过滤第一步的列表中修改超过24小时的文件。
 * 3. 在操控台打印结果。
 * 在步骤1和步骤2的结尾我们要检查列表是否为空。如果为空，那么线程直接结束运行并从phaser类中淘汰。
 * </pre>
 */
public class UsePhaser {


    public static void main(String[] args) {

        Phaser phaser = new Phaser(3);

        FileSearch system = new FileSearch("C:\\Windows", "log", phaser);
        FileSearch apps = new FileSearch("C:\\Program Files", "log", phaser);
        FileSearch documents = new FileSearch("C:\\Documents And Settings", "log", phaser);

        Thread systemThread = new Thread(system, "System");
        systemThread.start();

        Thread appsThread = new Thread(apps, "Apps");
        appsThread.start();

        Thread documentsThread = new Thread(documents, "Documents");
        documentsThread.start();
        try {
            systemThread.join();
            appsThread.join();
            documentsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Terminated: %s\n", phaser.isTerminated());
    }


    /**
     * This class search for files with an extension in a directory
     */
    public static class FileSearch implements Runnable {


        private String initPath;


        private String end;


        private List<String> results;


        private Phaser phaser;


        public FileSearch(String initPath, String end, Phaser phaser) {
            this.initPath = initPath;
            this.end = end;
            this.phaser = phaser;
            results = new ArrayList<>();
        }

        @Override
        public void run() {

            phaser.arriveAndAwaitAdvance();

            System.out.printf("%s: Starting.\n", Thread.currentThread().getName());

            // 1st Phase: Look for the files
            File file = new File(initPath);
            if (file.isDirectory()) {
                directoryProcess(file);
            }

            // If no results, deregister in the phaser and ends
            if (!checkResults()) {
                return;
            }

            // 2nd Phase: Filter the results
            filterResults();

            // If no results after the filter, deregister in the phaser and ends
            if (!checkResults()) {
                return;
            }

            // 3rd Phase: Show info
            showInfo();
            phaser.arriveAndDeregister();
            System.out.printf("%s: Work completed.\n", Thread.currentThread().getName());

        }


        private void showInfo() {
            for (int i = 0; i < results.size(); i++) {
                File file = new File(results.get(i));
                System.out.printf("%s: %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
            }
            phaser.arriveAndAwaitAdvance();
        }


        private boolean checkResults() {
            if (results.isEmpty()) {
                System.out.printf("%s: Phase %d: 0 results.\n", Thread.currentThread().getName(), phaser.getPhase());
                System.out.printf("%s: Phase %d: End.\n", Thread.currentThread().getName(), phaser.getPhase());
                // No results. Phase is completed but no more work to do. Deregister for the phaser
                phaser.arriveAndDeregister();
                return false;
            } else {
                // There are results. Phase is completed. Wait to continue with the next phase
                System.out.printf("%s: Phase %d: %d results.\n", Thread.currentThread().getName(), phaser.getPhase(), results.size());
                phaser.arriveAndAwaitAdvance();
                return true;
            }
        }


        private void filterResults() {
            List<String> newResults = new ArrayList<>();
            long actualDate = new Date().getTime();
            for (int i = 0; i < results.size(); i++) {
                File file = new File(results.get(i));
                long fileDate = file.lastModified();

                if (actualDate - fileDate < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
                    newResults.add(results.get(i));
                }
            }
            results = newResults;
        }


        private void directoryProcess(File file) {
            File list[] = file.listFiles();
            if (list != null) {
                for (int i = 0; i < list.length; i++) {
                    if (list[i].isDirectory()) {
                        directoryProcess(list[i]);
                    } else {
                        fileProcess(list[i]);
                    }
                }
            }
        }


        /**
         * @param file
         */
        private void fileProcess(File file) {
            if (file.getName().endsWith(end)) {
                results.add(file.getAbsolutePath());
            }
        }

    }

}
