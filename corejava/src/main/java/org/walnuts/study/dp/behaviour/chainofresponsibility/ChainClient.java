/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午03:23:27
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.behaviour.chainofresponsibility;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 * <pre>
 * 
 * 一、定义
 *     责任链模式
 *     1、Avoid coupling the sender of a request to its receiver by giving more then one object a chance to handler the request.
 *     Chain the receiving objects and pass the request along the chain until an object handles it
 *     使多个对象都有机会处理请求，从而避免了请求的发送者和接受者之间的耦合关系 。将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止。
 * 二、优点
 *     请求和处理分开
 * 三、缺点
 *     
 * 四、条件
 *     
 * 五、适用性
 *     
 * 六、最佳实践
 *     
 * </pre>
 * <img src="doc-files/chain.png" />
 * @author yzhi
 * @date 2012-1-20
 */
public class ChainClient {
	
	@Test
	public void testChain(){
		Handler handlerA = new ConcreteHandlerA();
		Handler handlerB = new ConcreteHandlerB();
		Handler handlerC = new ConcreteHandlerC();
		handlerA.setNext(handlerB);
		handlerB.setNext(handlerC);
		Response response = handlerA.handleMessage(new Request());
		Assert.assertNull(response);
	}
}
