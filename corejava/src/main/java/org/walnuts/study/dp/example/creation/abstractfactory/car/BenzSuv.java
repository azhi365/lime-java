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
 * BenzSUV
 * @author YZhi
 * @since 1.0
 */
public class BenzSuv extends AbsBenz {
	private final static String G_SEARIES = "g searies";
	/* (non-Javadoc)
	 * @see dp.example.creation.abstractfactory.car.AbsBenz#getModel()
	 */
	@Override
	public String getModel() {
		return G_SEARIES;
	}

}
