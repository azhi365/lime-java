/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午09:39:20
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.structure.proxy;

/**
 * 事前通知
 * @author yzhi
 * @date 2012-1-20
 * @version 
 */
public class BeforeAdvice implements IAdvice {

	/* (non-Javadoc)
	 * @see structure.proxy.IAdvice#exec()
	 */
	@Override
	public void exec() {
		System.out.println("Before Advice is executed");
	}
	
}
