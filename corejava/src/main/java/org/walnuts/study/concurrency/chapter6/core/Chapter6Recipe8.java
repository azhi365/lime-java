package org.walnuts.study.concurrency.chapter6.core;

import org.walnuts.study.concurrency.chapter6.recipe08.Account;
import org.walnuts.study.concurrency.chapter6.recipe08.Bank;
import org.walnuts.study.concurrency.chapter6.recipe08.Company;


/**
 * 使用原子变量 CAS(Compare and Set)
 *
 */
public class Chapter6Recipe8 {


	public static void main(String[] args) {
		Account	account=new Account();
		account.setBalance(1000);
		
		Company	company=new Company(account);
		Thread companyThread=new Thread(company);

		Bank bank=new Bank(account);
		Thread bankThread=new Thread(bank);
		
		System.out.printf("Account : Initial Balance: %d\n",account.getBalance());
		
		companyThread.start();
		bankThread.start();

		try {
			companyThread.join();
			bankThread.join();
			System.out.printf("Account : Final Balance: %d\n",account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
