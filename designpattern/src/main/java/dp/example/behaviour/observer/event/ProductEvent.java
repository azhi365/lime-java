/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.observer.event;

import java.util.Observable;

/**
 * 产品事件
 * @author YZhi
 * @since 1.0
 */
public class ProductEvent extends Observable {
	private Product source;
	private ProductEventType type;
	/**
	 * 
	 * @param p
	 * @param type
	 */
	public ProductEvent(Product p, ProductEventType type) {
		super();
		this.source = p;
		this.type = type;
		notifyEventDispatch();
	}
	
	/**
	 *
	 */
	private void notifyEventDispatch() {
		super.addObserver(EventDispatch.getEventDispatch());
		super.setChanged();
		super.notifyObservers(source);
	}
	
	public Product getSource() {
		return source;
	}
	public ProductEventType getType() {
		return type;
	}
	
	
}
