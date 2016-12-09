/**
 * 
 * @author YZhi
 * @date 2012-5-22
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.decorator.duck;

/**
 * 抽象装饰类
 * @author YZhi
 * @since 1.0
 */
public class Decorator implements Swan {
	private Swan swan;
	
	/**
	 * 
	 * 
	 * 
	 * @param swan
	 */
	public Decorator(Swan swan) {
		this.swan = swan;
	}

	/* (non-Javadoc)
	 * @see dp.example.structure.decorator.duck.Swan#cry()
	 */
	@Override
	public void cry() {
		swan.cry();
	}

	/* (non-Javadoc)
	 * @see dp.example.structure.decorator.duck.Swan#desAppearance()
	 */
	@Override
	public void desAppearance() {
		swan.desAppearance();
	}

	/* (non-Javadoc)
	 * @see dp.example.structure.decorator.duck.Swan#fly()
	 */
	@Override
	public void fly() {
		swan.fly();
	}

}
