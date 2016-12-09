/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午04:00:21
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.creation.abstractfactory;

/**
 * 产品等级1的实现类
 * @author YZhi
 * @since 1.0
 */
public class Creator1 extends AbstractCreator {

	/* (non-Javadoc)
	 * @see creation.abstractfactory.AbstractCreator#createProductA()
	 */
	@Override
	public AbstractProductA createProductA() {
		return new ProductA1();
	}

	/* (non-Javadoc)
	 * @see creation.abstractfactory.AbstractCreator#createProductB()
	 */
	@Override
	public AbstractProductB createProductB() {
		return new ProductB1();
	}

}
