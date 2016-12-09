/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午03:46:01
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.behaviour.chainofresponsibility.women;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

/**
 * 责任链模式
 * @author YZhi
 * @since 1.0
 */
public class WomenClient {
	@Test
	public void testChain(){
		Random random = new Random();
		ArrayList<IWomen> arrayList = new ArrayList<IWomen>();
		for (int i = 0; i < 5; i++) {
			arrayList.add(new Women(random.nextInt(3) + 1, " go out"));
		}
		Handler father = new Father();
		Handler husband = new Husband();
		Handler son = new Son();
		father.setNext(husband);
		husband.setNext(son);
		for (IWomen women : arrayList) {
			father.handlerMessage(women);
		}
	}
}
