/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午02:43:58
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.creation.factorymethod;

/**
 * 具体工厂类
 * @author YZhi
 * @since 1.0
 */
public class ConcreteCreator extends Creator {

	/* (non-Javadoc)
	 * @see creation.factorymethod.Creator#createProduct(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Product> T createProduct(Class<T> c) {
		Product product = null;
		try {
			product = (Product)Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
		}
		return (T)product;
	}

}
