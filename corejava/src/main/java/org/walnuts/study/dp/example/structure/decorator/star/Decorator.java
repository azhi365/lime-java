/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.decorator.star;

import org.walnuts.study.dp.example.structure.proxy.star.IStar;

/**
 * 抽象装饰类
 * @author YZhi
 * @since 1.0
 */
public abstract class Decorator implements IStar {
	
	private IStar star;
	
	public Decorator(IStar star) {
		this.star = star;
	}


	/* (non-Javadoc)
	 * @see dp.example.structure.decorator.star.IStar#act()
	 */
	@Override
	public void act() {
		this.star.act();
	}

}
