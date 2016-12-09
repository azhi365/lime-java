/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午05:10:17
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.builder.carmodel;

/**
 * 奔驰模型类
 * @author YZhi
 * @since 1.0
 */
public class BenzModel extends CarModel {

	/* (non-Javadoc)
	 * @see creation.builder.example.car.CarModel#alarm()
	 */
	@Override
	protected void alarm() {
		System.out.println("Benz alarm");
	}

	/* (non-Javadoc)
	 * @see creation.builder.example.car.CarModel#engineBoom()
	 */
	@Override
	protected void engineBoom() {
		System.out.println("Benz engineBoom");
	}

	/* (non-Javadoc)
	 * @see creation.builder.example.car.CarModel#start()
	 */
	@Override
	protected void start() {
		System.out.println("Benz start");
	}

	/* (non-Javadoc)
	 * @see creation.builder.example.car.CarModel#stop()
	 */
	@Override
	protected void stop() {
		System.out.println("Benz stop");
	}

}
