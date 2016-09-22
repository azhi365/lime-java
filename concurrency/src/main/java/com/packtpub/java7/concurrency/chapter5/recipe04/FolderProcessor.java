package com.packtpub.java7.concurrency.chapter5.recipe04;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;


public class FolderProcessor extends RecursiveTask<List<String>> {


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
