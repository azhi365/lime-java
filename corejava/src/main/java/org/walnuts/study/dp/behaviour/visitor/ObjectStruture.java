package org.walnuts.study.dp.behaviour.visitor;

import java.util.Random;

/**
 * 结构对象
 * @author YZhi
 * @since 1.0
 */
public class ObjectStruture {
	public static Element creteElement(){
		Random random = new Random();
		if(random.nextInt(100)>50){
			return new ConcreteElementA();
		}else {
			return new ConcreteElementB();
		}
	}
}
