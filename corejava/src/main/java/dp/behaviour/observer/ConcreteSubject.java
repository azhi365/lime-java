/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午11:24:31
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.behaviour.observer;

/**
 * 具体被观察者
 * @author YZhi
 * @since 1.0
 */
public class ConcreteSubject extends Subject {
	public void doSomething(){
		super.notifyObservers();
	}
}
