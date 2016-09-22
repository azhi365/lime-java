/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午11:20:30
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.behaviour.observer;

import java.util.Vector;

/**
 * 被观察者
 * @author YZhi
 * @since 1.0
 */
public abstract class Subject {
	private Vector<Observer> observers = new Vector<Observer>();
	public void addObserver(Observer o){
		this.observers.add(o);
	}
	public void delObserver(Observer o){
		this.observers.remove(o);
	}
	
	public void notifyObservers(){
		for (Observer o : observers) {
			o.update();
		}
	}
}
