/**
 * 
 * @author yzhi
 * @date 2012-1-29 下午02:48:42
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.observer.hanfeiinjava;

import java.util.Observable;
import java.util.Observer;

/**
 * 李斯
 * @author yzhi
 * @date 2012-1-29
 * @version 
 */
public class LiSi implements Observer {

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("LiSi:" + arg.toString());
	}

}
