package com.nanoutech.lime.test.jms;

import javax.annotation.Resource;
import javax.jms.Destination;

import com.nanoutech.lime.test.base.SpringBaseTestCase;
import com.nanoutech.lime.test.jms.bean.Email;
import com.nanoutech.lime.test.jms.service.IMessageService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <Pre>
 * 对于消息的传递有两种类型
 * 一种是点对点的，即一个生产者和一个消费者一一对应；
 * 另一种是发布/订阅模式，即一个生产者产生消息并进行发送后，
 * 可以由多个消费者进行接收。
 * </pre>
 * 
 * @author YZhi
 * @since 2015-11-18 上午10:12:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-jms.xml")
public class JmsTestCase extends SpringBaseTestCase {

	@After
	public void after() throws Exception {
		Thread.sleep(2000); // 解决立即关闭无法接收回复消息的问题
	}

	@Resource
	private IMessageService producerService;

	@Resource(name = "queueDestination")
	private Destination destination;

	@Resource(name = "sessionAwareQueue")
	private Destination sessionAwareQueue;

	@Resource(name = "adapterQueue")
	private Destination adapterQueue;

	/**
	 * 通过Spring-jms 发送消息
	 */
	@Test
	public void testSend() {
		for (int i = 0; i < 6; i++) {
			producerService.sendMessage(this.destination, "这是第" + (i + 1) + "条消息.");
		}
	}

	@Test
	public void testSessionAwareMessageListener() {
		this.producerService.sendMessage(this.sessionAwareQueue, "这是消息内容");
	}

	@Test
	public void testMessageListenerAdapter() {
		producerService.sendMessage(adapterQueue, "测试MessageListenerAdapter");
	}

	@Test
	public void testMessageListenerAdapterWithReply() {
		producerService.sendMessageWithReply(adapterQueue, "测试MessageListenerAdapter");
	}

	@Test
	public void testMessageListenerAdapterByDefaultResponseDestination() {
		producerService.sendMessageByDefaultResponseDestination(adapterQueue, "测试MessageListenerAdapter");
	}
	
	@Test
	public void testObjectMessage() {
		Email email = new Email("zhangsan@xxx.com", "主题", "内容");
		producerService.sendMessage(destination, email);
	}
	
	@Test
	public void testObjectMessageByAdapterQueue() {  
	    Email email = new Email("zhangsan@xxx.com", "主题", "内容");  
	    producerService.sendMessage(adapterQueue, email);  
	} 

}