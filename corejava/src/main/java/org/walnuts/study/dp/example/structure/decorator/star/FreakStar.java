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
 * 
 * @author YZhi
 * @since 1.0
 */
public class FreakStar implements IStar {

	/* (non-Javadoc)
	 * @see dp.example.structure.decorator.star.IStar#act()
	 */
	@Override
	public void act() {
		System.out.println("FreakStar act");
	}

}
