package com.nanoutech.test.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JobService {


	/**
	 * 任务执行时间超出周期时间时，不会启动下次任务
	 */
	@Scheduled(cron = "0/5 * * * * ?")
	private void test(){
		System.out.println("being:" + new Date());
		try {
			Thread.sleep(8000); //
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end：" + new Date());
	}


}