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
 * 
 * @author YZhi
 * @since 1.0
 */
public class StrongBehavior extends Decorator {

	/**
	 * 
	 * 
	 * 
	 * @param swan
	 */
	public StrongBehavior(Swan swan) {
		super(swan);
	}
	
	/* (non-Javadoc)
	 * @see dp.example.structure.decorator.duck.Decorator#fly()
	 */
	@Override
	public void fly() {
		System.out.println("can fly");
	}

}
