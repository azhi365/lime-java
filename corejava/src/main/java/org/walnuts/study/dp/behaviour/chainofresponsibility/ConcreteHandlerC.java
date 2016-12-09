/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午03:21:31
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.behaviour.chainofresponsibility;


/**
 * 具体处理者C
 * @author YZhi
 * @since 1.0
 */
public class ConcreteHandlerC extends Handler {

	/* (noxn-Javadoc)
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
