/**
 * 
 * @author YZhi
 * @date 2012-5-17
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.builder.car;

/**
 * 具体车辆
 * @author YZhi
 * @since 1.0
 */
public class Car implements ICar {
	private String wheel;
	private String engine;
	
	/**
	 * @param wheel
	 * @param engine
	 */
	public Car(String wheel, String engine) {
		super();
		this.wheel = wheel;
		this.engine = engine;
	}

	/* (non-Javadoc)
	 * @see dp.example.creation.builder.car.ICar#getEnging()
	 */
	@Override
	public String getEnging() {
		return engine;
	}

	/* (non-Javadoc)
	 * @see dp.example.creation.builder.car.ICar#getWheel()
	 */
	@Override
	public String getWheel() {
		return wheel;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Wheel: " + wheel + ",Engine: " + engine; 
	}

}
