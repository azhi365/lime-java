/**
 * 
 * @author YZhi
 * @date 2012-5-22
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.adapter.duck;

import org.walnuts.study.dp.example.structure.decorator.duck.Swan;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class WhiteSwan implements Swan {

	/* (non-Javadoc)
	 * @see dp.example.structure.decorator.duck.Swan#cry()
	 */
	@Override
	public void cry() {
		System.out.println("WhiteSwan cry");
	}

	/* (non-Javadoc)
	 * @see dp.example.structure.decorator.duck.Swan#desAppearance()
	 */
	@Override
	public void desAppearance() {
		System.out.println("WhiteSwan desAppearance");
	}

	/* (non-Javadoc)
	 * @see dp.example.structure.decorator.duck.Swan#fly()
	 */
	@Override
	public void fly() {
		System.out.println("WhiteSwan fly");
	}

}
