package org.walnuts.study.concurrency.chapter6.recipe08;

public class Bank implements Runnable {


    private Account account;


    public Bank(Account account) {
        this.account = account;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.subtractAmount(1000);
        }
    }

}
