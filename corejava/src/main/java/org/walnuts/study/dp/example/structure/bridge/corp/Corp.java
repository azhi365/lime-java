/**
 * @author yzhi
 * @date 2012-1-30 上午10:40:23
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.bridge.corp;

/**
 * 抽象公司
 * @author YZhi
 * @since 1.0
 */
public abstract class Corp {
	private Product product;
	
	/**
	 * 
	 * 
	 * 
	 * @param product
	 */
	public Corp(Product product) {
		super();
		this.product = product;
	}

	public void makeMoney(){
		this.product.beProducted();
		this.product.beSelled();
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
