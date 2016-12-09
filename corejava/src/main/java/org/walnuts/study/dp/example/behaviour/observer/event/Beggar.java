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
 * 乞丐
 * @author YZhi
 * @since 1.0
 */
public class Beggar extends EventCustomer {
	public Beggar(){
		super(EventCustomType.DEL);
	}
	/* (non-Javadoc)
	 * @see dp.example.behaviour.observer.event.EventCustomer#exec(dp.example.behaviour.observer.event.ProductEvent)
	 */
	@Override
	public void exec(ProductEvent event) {
		Product p = event.getSource();
		ProductEventType type = event.getType();
		System.out.println("Beggar " + p.getName() + type);
	}

}
