/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午09:46:18
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.structure.proxy;

import java.lang.reflect.InvocationHandler;

/**
 * 具体业务的动态代理
 * @author yzhi
 * @date 2012-1-20
 * @version 
 */

public class SubjectDynamicProxy<T> extends DynamicProxy<T> {
	public static <T> T newProxyInstance(Subject subject){
		ClassLoader loader = subject.getClass().getClassLoader();
		Class<?>[] classes = subject.getClass().getInterfaces();
		InvocationHandler handler = new MyInvocationHandler(subject);
		return newProxyInstance(loader, classes, handler);
	}
}
