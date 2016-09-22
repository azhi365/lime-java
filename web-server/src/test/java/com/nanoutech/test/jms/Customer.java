/**
 * nanoutech.com
 */
package com.nanoutech.test.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消费者，不通过Spring
 * 
 * @author YZhi
 * @since 2015-9-16 下午10:57:44
 */
public class Customer {
	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, "tcp://101.227.251.228:61616");
		Connection connection = factory.createConnection();
		connection.start();
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("queue");
		MessageConsumer consumer = session.createConsumer(destination);
		while (true) {
			Message message = consumer.receive(1000);
			if (null != message) {
				String str = ((TextMessage) message).getText();
				System.out.println("消费者接收到：" + str);
			}
		}
	}
}
