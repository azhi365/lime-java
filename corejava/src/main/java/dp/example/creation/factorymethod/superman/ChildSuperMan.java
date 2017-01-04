/**
 * 
 * @author YZhi
 * @date 2012-5-17
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.creation.factorymethod.superman;

/**
 * 小超人
 * @author YZhi
 * @since 1.0
 */
public class ChildSuperMan implements ISuperMan {

	/* (non-Javadoc)
	 * @see dp.example.creation.factorymethod.superman.ISuperMan#specialTalent()
	 */
	@Override
	public void specialTalent() {
		System.out.println("Child SuperMan");
	}

}
