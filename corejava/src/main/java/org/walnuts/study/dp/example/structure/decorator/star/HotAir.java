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
 * 吹大话
 * @author YZhi
 * @since 1.0
 */
public class HotAir extends Decorator {

	public HotAir(IStar star) {
		super(star);
	}
	
	public void act(){
		System.out.println("HotAir act");
		super.act();
	}
}
