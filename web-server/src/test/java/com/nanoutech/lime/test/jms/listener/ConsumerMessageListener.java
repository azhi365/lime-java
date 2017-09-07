package com.innstack.lime.test.jms.listener;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.jms.support.converter.MessageConverter;

import com.innstack.lime.test.jms.bean.Email;

/**
 * MessageListener是最原始的消息监听器，它是JMS规范中定义的一个接口。其中定义了一个用于处理接收到的消息的onMessage方法，
 * 该方法只接收一个Message参数
 * 
 * @author YZhi
 * @since 2015-11-17 下午4:53:22
 */
public class ConsumerMessageListener implements MessageListener {

	@Resource
	private MessageConverter messageConverter;

	public void onMessage(Message message) {

		if (message instanceof TextMessage) {
			TextMessage textMsg = (TextMessage) message;
			try {
				System.out.println("消费者收到：" + textMsg.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

		if (message instanceof ObjectMessage) {
			ObjectMessage objMessage = (ObjectMessage) message;
			try {
				//可以强制转换
				// Object obj = objMessage.getObject();
				// Email email = (Email) obj; 
				
				Email email = (Email) messageConverter.fromMessage(objMessage);
				System.out.println("接收到一个ObjectMessage，包含Email对象。");
				System.out.println(email);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

	}
}