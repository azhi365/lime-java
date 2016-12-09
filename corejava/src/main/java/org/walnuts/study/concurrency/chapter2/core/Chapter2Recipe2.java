package org.walnuts.study.concurrency.chapter2.core;

import org.walnuts.study.concurrency.chapter2.recipe2.Account;
import org.walnuts.study.concurrency.chapter2.recipe2.Bank;
import org.walnuts.study.concurrency.chapter2.recipe2.Company;

/**
 * 同步方法 synchronized 与非 synchronized 方法的区别
 */
public class Chapter2Recipe2 {


	public static void main(String[] args) {
		Account	account=new Account();
		account.setBalance(1000);

		Company	company=new Company(account);
		Thread companyThread=new Thread(company);

		Bank bank=new Bank(account);
		Thread bankThread=new Thread(bank);
		
		System.out.printf("Account : Initial Balance: %f\n",account.getBalance());
		

		companyThread.start();
		bankThread.start();

		try {
			companyThread.join();
			bankThread.join();
			System.out.printf("Account : Final Balance: %f\n",account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
