/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.proxy.star;

/**
 * 代理类
 * @author YZhi
 * @since 1.0
 */
public class Agent implements IStar {
	private IStar star;
	
	public Agent(IStar star) {
		this.star = star;
	}
	/* (non-Javadoc)
	 * @see dp.example.structure.proxy.star.IStar#sign()
	 */
	@Override
	public void act() {
		star.act();
	}
}
