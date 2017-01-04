/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午04:01:07
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.creation.abstractfactory;

/**
 * 产品等级2的实现类
 * @author YZhi
 * @since 1.0
 */
public class Creator2 extends AbstractCreator {

	/* (non-Javadoc)
	 * @see creation.abstractfactory.AbstractCreator#createProductA()
	 */
	@Override
	public AbstractProductA createProductA() {
		return new ProductA2();
	}

	/* (non-Javadoc)
	 * @see creation.abstractfactory.AbstractCreator#createProductB()
	 */
	@Override
	public AbstractProductB createProductB() {
		return new ProductB2();
	}

}
