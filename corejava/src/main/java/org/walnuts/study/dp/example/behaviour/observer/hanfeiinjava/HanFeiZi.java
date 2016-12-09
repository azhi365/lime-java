/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午02:47:00
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.observer.hanfeiinjava;

import java.util.Observable;

import org.walnuts.study.dp.example.behaviour.observer.hanfei.IHanFeiZi;


/**
 * 韩非
 * @author yzhi
 * @date 2012-1-29
 * @version 
 */
public class HanFeiZi extends Observable implements IHanFeiZi {

	/* (non-Javadoc)
	 * @see behaviour.observer.example.hanfei.IHanFeiZi#haveBreakfast()
	 */
	@Override
	public void haveBreakfast() {
		System.out.println("hanfei haveBreakfast");
		super.setChanged();
		super.notifyObservers("hanfei start haveBreakfast");
	}

	/* (non-Javadoc)
	 * @see behaviour.observer.example.hanfei.IHanFeiZi#haveFun()
	 */
	@Override
	public void haveFun() {
		System.out.println("hanfei haveFun");
		super.setChanged();
		super.notifyObservers("hanfei start haveFun");
	}

}
