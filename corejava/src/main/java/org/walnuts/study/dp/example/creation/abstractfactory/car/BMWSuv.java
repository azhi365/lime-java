/**
 * 
 * @author YZhi
 * @date 2012-5-17
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.abstractfactory.car;

/**
 * 宝马SUV
 * @author YZhi
 * @since 1.0
 */
public class BMWSuv extends AbsBMW {
	private final static String X_SEARIES = "x searies";
	/* (non-Javadoc)
	 * @see dp.example.creation.abstractfactory.car.AbsBMW#getModel()
	 */
	@Override
	public String getModel() {
		return X_SEARIES;
	}	
}
