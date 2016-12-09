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
 * 抽象建造者
 * @author YZhi
 * @since 1.0
 */
public abstract class CarBulider {
	private Blueprint bp;
	public Car bulidCar(){
		return new Car(bulidWheel(), bulidEngine());
	}
	
	public void recevieBlueprint(Blueprint bp){
		this.bp = bp;
	}
	
	protected Blueprint getBlueprint(){
		return bp;
	} 
	
	protected abstract String bulidWheel();
	protected abstract String bulidEngine();
	
}
