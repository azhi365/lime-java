/**
 * 
 * @author YZhi
 * @date 2012-5-22
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.adapter.duck;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class Duckling implements Duck {

	/* (non-Javadoc)
	 * @see dp.example.structure.adapter.duck.Duck#cry()
	 */
	@Override
	public void cry() {
		System.out.println("Duckling cry");
	}

	/* (non-Javadoc)
	 * @see dp.example.structure.adapter.duck.Duck#desAppearance()
	 */
	@Override
	public void desAppearance() {
		System.out.println("Duckling desAppearance");
		
	}

	/* (non-Javadoc)
	 * @see dp.example.structure.adapter.duck.Duck#desBehavior()
	 */
	@Override
	public void desBehavior() {
		System.out.println("Duckling desBehavior");
	}

}
