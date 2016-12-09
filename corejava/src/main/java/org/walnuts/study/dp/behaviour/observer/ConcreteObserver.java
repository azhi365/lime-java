/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午11:21:16
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.behaviour.observer;

/**
 * 具体观察者
 * @author YZhi
 * @since 1.0
 */
public class ConcreteObserver implements Observer {

	/* (non-Javadoc)
	 * @see behaviour.observer.Observer#update()
	 */
	@Override
	public void update() {
		System.out.println("received message");
	}

}
