/**
 * 
 * @author YZhi
 * @date 2012-5-17
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.creation.abstractfactory.car;

/**
 * BenZVan
 * @author YZhi
 * @since 1.0
 */
public class BenzVan extends AbsBenz {
	private final static String R_SEARIES = "r searies";
	/* (non-Javadoc)
	 * @see dp.example.creation.abstractfactory.car.AbsBenz#getModel()
	 */
	@Override
	public String getModel() {
		return R_SEARIES;
	}

}
