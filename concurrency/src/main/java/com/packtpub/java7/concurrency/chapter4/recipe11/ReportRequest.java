package com.packtpub.java7.concurrency.chapter4.recipe11;

import java.util.concurrent.CompletionService;

public class ReportRequest implements Runnable {


    private String name;


    private CompletionService<String> service;


    public ReportRequest(String name, CompletionService<String> service) {
        this.name = name;
        this.service = service;
    }


    @Override
    public void run() {
        ReportGenerator reportGenerator = new ReportGenerator(name, "Report");
        service.submit(reportGenerator);
    }

}