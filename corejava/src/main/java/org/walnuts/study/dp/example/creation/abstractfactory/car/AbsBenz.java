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
 * 抽象奔驰
 * @author YZhi
 * @since 1.0
 */
public abstract class AbsBenz implements ICar {
	private final String BENZ_BAND = "Benz Car";
	public String getBand(){
		return BENZ_BAND;
	}
	public abstract String getModel();
}
