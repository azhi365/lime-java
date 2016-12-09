/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午05:15:36
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.builder.carmodel;

import java.util.ArrayList;

/**
 * 奔驰车组装者
 * @author YZhi
 * @since 1.0
 */
public class BenzBuilder extends CarBuilder {
	private BenzModel benz = new BenzModel();
	public CarModel getCarModel(){
		return this.benz;
	}
	/* (non-Javadoc)
	 * @see creation.builder.example.car.CarBuilder#setSequence(java.util.ArrayList)
	 */
	@Override
	public void setSequence(ArrayList<String> sequence) {
		this.benz.setSequence(sequence);
	}
	
}
