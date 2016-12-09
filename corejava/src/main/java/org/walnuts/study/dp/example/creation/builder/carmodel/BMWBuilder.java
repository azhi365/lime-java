/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午05:17:28
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.builder.carmodel;

import java.util.ArrayList;

/**
 * BMW组装者
 * @author YZhi
 * @since 1.0
 */
public class BMWBuilder extends CarBuilder {
	private BMWModel bmw = new BMWModel();
	
	/* (non-Javadoc)
	 * @see creation.builder.example.car.CarBuilder#getCarModel()
	 */
	@Override
	public CarModel getCarModel() {
		return this.bmw;
	}

	/* (non-Javadoc)
	 * @see creation.builder.example.car.CarBuilder#setSequence(java.util.ArrayList)
	 */
	@Override
	public void setSequence(ArrayList<String> sequence) {
		this.bmw.setSequence(sequence);
	}

}
