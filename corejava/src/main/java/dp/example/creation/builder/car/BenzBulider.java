/**
 * 
 * @author YZhi
 * @date 2012-5-17
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.creation.builder.car;

/**
 * Benz建造者
 * @author YZhi
 * @since 1.0
 */
public class BenzBulider extends CarBulider {

	/* (non-Javadoc)
	 * @see dp.example.creation.builder.car.CarBulider#bulidEngine()
	 */
	@Override
	protected String bulidEngine() {
		return super.getBlueprint().getEngine();
	}

	/* (non-Javadoc)
	 * @see dp.example.creation.builder.car.CarBulider#bulidWheel()
	 */
	@Override
	protected String bulidWheel() {
		return super.getBlueprint().getWheel();
	}

}
