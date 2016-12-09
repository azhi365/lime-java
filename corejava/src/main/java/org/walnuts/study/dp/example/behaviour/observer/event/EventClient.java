/**
 * 
 * @author YZhi
 * @date 2012-5-31
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.observer.event;

import org.junit.Test;

/**
 * 观察者模式+中介者模式
 * @author YZhi
 * @since 1.0
 */
public class EventClient {
	@Test
	public void testEvent(){
		EventDispatch dispatch = EventDispatch.getEventDispatch();
		dispatch.registerCustomer(new Beggar());
		dispatch.registerCustomer(new Commoner());
		dispatch.registerCustomer(new Nobleman());
		ProductManager factory = new ProductManager();
		Product p = factory.createProduct("小男孩原子弹");
		factory.editProduct(p, "胖子号原子弹");
		factory.clone(p);
		factory.abandonProduct(p);
	}
}
