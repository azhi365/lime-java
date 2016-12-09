/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.observer.event;

/**
 * 产品类
 * @author YZhi
 * @since 1.0
 */
public class Product implements Cloneable {
	private String name;
	private boolean canChanged = false;
	/**
	 * 
	 * @param name
	 */
	public Product(ProductManager manager, String name) {
		if(manager.isCanCreate()){
			this.setCanChanged(true);
			this.name = name;
		}

	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Product clone(){
		Product p = null;
		try {
			p = (Product)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCanChanged(boolean canChanged) {
		this.canChanged = canChanged;
	}
	public boolean isCanChanged() {
		return canChanged;
	}
	
	
}
