/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午03:32:25
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.creation.singleton;

/**
 * 非线程安全的单例
 * @author YZhi
 * @since 1.0
 */
public class SingletonNotThreadSafe {
	private static SingletonNotThreadSafe  singleton = null;
	private SingletonNotThreadSafe(){
		
	}
	public static SingletonNotThreadSafe getSingleton(){
		if(singleton == null){
			singleton = new SingletonNotThreadSafe();
		}
		return singleton;
	}
}
