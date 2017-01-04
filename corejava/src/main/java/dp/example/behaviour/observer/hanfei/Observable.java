/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午02:32:29
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.observer.hanfei;

/**
 * 被观察者接口
 * @author YZhi
 * @since 1.0
 */
public interface Observable {
	public void addObserver(Observer observer);
	public void deleteObserver(Observer observer);
	public void notifyObservers(String context);
}
