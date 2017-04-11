/**
 * nanoutech.com
 */
package com.nanoutech.lime.test.jms.service;

import java.io.Serializable;

import javax.jms.Destination;

/**
 * 
 * @author YZhi
 * @since 2015-9-16 下午7:04:39
 */
public interface IMessageService {

	/**
	 * @param destination
	 * @param string
	 */
	void sendMessage(Destination destination, String message);

	/**
	 * 通过发送的Message的setJMSReplyTo方法指定该消息对应的回复消息的目的地
	 * 
	 * @param destination
	 * @param string
	 */
	void sendMessageWithReply(Destination destination, String message);

	/**
	 * 通过MessageListenerAdapter的defaultResponseDestination属性来指定
	 * 
	 * @param adapterQueue
	 * @param string
	 */
	void sendMessageByDefaultResponseDestination(Destination adapterQueue, String string);

	/**
	 * 
	 * @param destination
	 * @param obj
	 */
	void sendMessage(Destination destination, final Serializable obj);

	/**
	 * 使用JmsTemplate进行消息发送时只调用其对应的convertAndSend方法
	 * 
	 * @param destination
	 * @param obj
	 */
	void sendMessageByMessageConverter(Destination destination, final Serializable obj);

	void sendMessageTopic(Destination destination, String message);

}
