/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午03:21:12
 * @copyright 2012 haitian.com All rights reserved
 * @version 1.0	
 *
 */
package org.walnuts.study.dp.behaviour.chainofresponsibility;

/**
 * 具体处理者B
 * @author yzhi
 */
public class ConcreteHandlerB extends Handler {

	/* (non-Javadoc)
	 * @see behavior.chainofresponsibility.Handler#echo(behavior.chainofresponsibility.Request)
	 */
	@Override
	protected Response echo(Request request) {
		return null;
	}

	/* (non-Javadoc)
	 * @see behavior.chainofresponsibility.Handler#getHandlerLevel()
	 */
	@Override
	protected Level getHandlerLevel() {
		return null;
	}

}
