package org.walnuts.study.dp.structure.flyweight;

import java.util.HashMap;

/**
 * 享元工厂
 * @author YZhi
 * @since 1.0
 */
public class FlyweightFactory {
	private static HashMap<String, Flyweight> pool = new HashMap<String, Flyweight>();
	public static Flyweight getFlyweight(String extrinsic) {
		Flyweight flyweight = null;
		if(pool.containsKey(extrinsic)){
			flyweight = pool.get(extrinsic);
		}else {
			flyweight = new ConcreteFlyweightA(extrinsic);
			pool.put(extrinsic, flyweight);
		}
		return flyweight;
	}
}
