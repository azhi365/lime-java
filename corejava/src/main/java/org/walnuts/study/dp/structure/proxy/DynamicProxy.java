/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午09:35:54
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 * @author yzhi
 * @date 2012-1-20
 * @version 
 */
public class DynamicProxy<T> {
	@SuppressWarnings("unchecked")
	public static <T> T newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h){
		if(true){
			new BeforeAdvice().exec();
		}
		return (T)Proxy.newProxyInstance(loader, interfaces, h);
	}
}
