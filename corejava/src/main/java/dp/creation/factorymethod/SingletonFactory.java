/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午03:18:09
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.creation.factorymethod;

import java.lang.reflect.Constructor;

/**
 * 
 * 替代单例模式
 * 
 * @author YZhi
 * @since 1.0
 */
public class SingletonFactory {
	private static Singleton singleton;
	static {
		try {
			Class<?> cl = Class.forName(Singleton.class.getName());
			Constructor<?> constructor = cl.getDeclaredConstructor();
			constructor.setAccessible(true);
			singleton = (Singleton) constructor.newInstance();
		} catch (Exception e) {
			System.out.println("can not create singleton instance in SingletonFactory");
		}
	}

	public Singleton getSingleton() {
		return singleton;
	}
}
