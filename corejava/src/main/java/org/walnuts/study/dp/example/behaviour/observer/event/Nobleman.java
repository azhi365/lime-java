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
 * 
 * @author YZhi
 * @since 1.0
 */
public class Nobleman extends EventCustomer {

	/**
	 * 贵族
	 * @param type
	 */
	public Nobleman() {
		super(EventCustomType.EDIT);
	}

	/* (non-Javadoc)
	 * @see dp.example.behaviour.observer.event.EventCustomer#exec(dp.example.behaviour.observer.event.ProductEvent)
	 */
	@Override
	public void exec(ProductEvent event) {
		Product p = event.getSource();
		ProductEventType type = event.getType();
		if(type.getValue() == EventCustomType.CLONE.getValue()){
			System.out.println("Nobleman " + p.getName() + " CLONE"+ type);
		}else {
			System.out.println("Nobleman " + p.getName() + " EDIT"+ type);	
		}

	}

}
