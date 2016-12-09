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
 * 平民
 * @author YZhi
 * @since 1.0
 */
public class Commoner extends EventCustomer {

	public Commoner() {
		super(EventCustomType.NEW);
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.observer.event.EventCustomer#exec(dp.example.behaviour.observer.event.ProductEvent)
	 */
	@Override
	public void exec(ProductEvent event) {
		Product p = event.getSource();
		ProductEventType type = event.getType();
		System.out.println("Commoner " + p.getName() + type);
	}

}
