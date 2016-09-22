/**
 * 
 * @author YZhi
 * @date 2012-5-22
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.structure.adapter.duck;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class UglyDuckling extends WhiteSwan implements Duck {
	/* (non-Javadoc)
	 * @see dp.example.structure.adapter.duck.WhiteSwan#cry()
	 */
	@Override
	public void cry() {
		super.cry();
	}
	
	/* (non-Javadoc)
	 * @see dp.example.structure.adapter.duck.WhiteSwan#desAppearance()
	 */
	@Override
	public void desAppearance() {
		super.desAppearance();
	}
	
	/* (non-Javadoc)
	 * @see dp.example.structure.adapter.duck.Duck#desBehavior()
	 */
	@Override
	public void desBehavior() {
		System.out.println("other");
		super.fly();
	}


}
