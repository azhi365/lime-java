package concurrency.threadmanage;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * 操作线程的中断机制
 */
public class InterruptOption {

    /**
     * Main method of the core. Search for the autoexect.bat file
     * on the Windows root folder and its subfolders during ten seconds
     * and then, interrupts the Thread
     *
     * @param args
     */
    public static void main(String[] args) {
        // Creates the Runnable object and the Thread to run it
        FileSearch searcher = new FileSearch("C:\\", "autoexec.bat");
        Thread thread = new Thread(searcher);

        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }


    /**
     * This class search for files with a name in a directory
     */
    public static class FileSearch implements Runnable {

        private String initPath;
        private String fileName;

        public FileSearch(String initPath, String fileName) {
            this.initPath = initPath;
            this.fileName = fileName;
        }


        @Override
        public void run() {
            File file = new File(initPath);
            if (file.isDirectory()) {
                try {
                    directoryProcess(file);
                } catch (InterruptedException e) {
                    System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName());
                    cleanResources();
                }
            }
        }

        private void cleanResources() {

        }

        /**
         * Method that process a directory
         *
         * @param file : Directory to process
         * @throws InterruptedException : If the thread is interrupted
         */
        private void directoryProcess(File file) throws InterruptedException {

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

            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }

        /**
         * Method that process a File
         *
         * @param file : File to process
         * @throws InterruptedException : If the thread is interrupted
         */
        private void fileProcess(File file) throws InterruptedException {

            if (file.getName().equals(fileName)) {
                System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
            }


            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }

    }

}
