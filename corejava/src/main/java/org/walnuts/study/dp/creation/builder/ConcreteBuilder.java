/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午04:57:27
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.creation.builder;

/**
 * 具体创建者
 * @author YZhi
 * @since 1.0
 */
public class ConcreteBuilder extends Builder {
	private Product product = new Product();
	
	/* (non-Javadoc)
	 * @see creation.builder.Builder#buildProduct()
	 */
	@Override
	public Product buildProduct() {
		return product;
	}

	/* (non-Javadoc)
	 * @see creation.builder.Builder#setPart()
	 */
	@Override
	public void setPart() {
		
	}

}
