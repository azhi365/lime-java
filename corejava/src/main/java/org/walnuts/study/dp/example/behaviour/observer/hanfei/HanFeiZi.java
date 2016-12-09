/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午02:37:29
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.observer.hanfei;

import java.util.ArrayList;

/**
 * 韩非
 * @author YZhi
 * @since 1.0
 */
public class HanFeiZi implements Observable,IHanFeiZi {
	private ArrayList<Observer> observerList = new ArrayList<Observer>();

	/* (non-Javadoc)
	 * @see behaviour.observer.hanfei.IHanFeiZi#haveBreakfast()
	 */
	@Override
	public void haveBreakfast() {
		System.out.println("hanfeizi haveBreakfast");
		this.notifyObservers("hanfeizi start haveBreakfast");
	}

	/* (non-Javadoc)
	 * @see behaviour.observer.hanfei.IHanFeiZi#haveFun()
	 */
	@Override
	public void haveFun() {
		System.out.println("hanfeizi havefun");
		this.notifyObservers("hanfeizi start havefun");
	}

	/* (non-Javadoc)
	 * @see behaviour.observer.hanfei.Observable#addObserver(behaviour.observer.hanfei.Observer)
	 */
	@Override
	public void addObserver(Observer observer) {
		this.observerList.add(observer);
	}

	/* (non-Javadoc)
	 * @see behaviour.observer.hanfei.Observable#deleteObserver(behaviour.observer.hanfei.Observer)
	 */
	@Override
	public void deleteObserver(Observer observer) {
		this.observerList.remove(observer);
	}

	/* (non-Javadoc)
	 * @see behaviour.observer.hanfei.Observable#notifyObservers(java.lang.String)
	 */
	@Override
	public void notifyObservers(String context) {
		for (Observer observer : observerList) {
			observer.update(context);
		}
	}

}
