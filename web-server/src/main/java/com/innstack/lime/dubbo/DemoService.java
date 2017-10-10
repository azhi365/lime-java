package com.innstack.lime.dubbo;


import org.springframework.stereotype.Service;

@Service
public class DemoService implements IDemoService {
	
	public void sayHello() {
		System.out.println("hello world!");
	}

	public String returnHello() {
		return "hello world!";
	}

	public Msg returnMsgInfo(Msg msg) {
		msg.getMsgs().add("处理完毕 done");
		return msg;
	}
}