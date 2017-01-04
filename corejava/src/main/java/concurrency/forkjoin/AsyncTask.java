package concurrency.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * 异步运行任务
 */
public class AsyncTask {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        FolderProcessor system = new FolderProcessor("C:\\Windows", "log");
        FolderProcessor apps = new FolderProcessor("C:\\Program Files", "log");
        FolderProcessor documents = new FolderProcessor("C:\\Documents And Settings", "log");

        pool.execute(system);
        pool.execute(apps);
        pool.execute(documents);
        do {
            System.out.printf("******************************************\n");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
            System.out.printf("******************************************\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while ((!system.isDone()) || (!apps.isDone()) || (!documents.isDone()));

        pool.shutdown();

        List<String> results;

        results = system.join();
        System.out.printf("System: %d files found.\n", results.size());

        results = apps.join();
        System.out.printf("Apps: %d files found.\n", results.size());

        results = documents.join();
        System.out.printf("Documents: %d files found.\n", results.size());


    }

    public static class FolderProcessor extends RecursiveTask<List<String>> {


        private static final long serialVersionUID = 1L;


        private String path;

        private String extension;


        public FolderProcessor(String path, String extension) {
            this.path = path;
            this.extension = extension;
        }


        @Override
        protected List<String> compute() {
            List<String> list = new ArrayList<>();
            List<FolderProcessor> tasks = new ArrayList<>();

            File file = new File(path);
            File files[] = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        FolderProcessor task = new FolderProcessor(files[i].getAbsolutePath(), extension);
                        task.fork();//异步执行
                        tasks.add(task);
                    } else {
                        if (checkFile(files[i].getName())) {
                            list.add(files[i].getAbsolutePath());
                        }
                    }
                }

                if (tasks.size() > 50) {
                    System.out.printf("%s: %d tasks ran.\n", file.getAbsolutePath(), tasks.size());
                }

                addResultsFromTasks(list, tasks);
            }
            return list;
        }

        private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks) {
            for (FolderProcessor item : tasks) {
                list.addAll(item.join());
            }
        }

        private boolean checkFile(String name) {
            if (name.endsWith(extension)) {
                return true;
            }
            return false;
        }


    }

}
