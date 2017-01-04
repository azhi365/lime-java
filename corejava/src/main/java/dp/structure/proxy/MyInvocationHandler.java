/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午09:34:35
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理的Handler类
 * @author yzhi
 * @date 2012-1-20
 * @version 
 */
public class MyInvocationHandler implements InvocationHandler {
	private Object target = null;
	public MyInvocationHandler(Object target){
		this.target = target;
	}
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return method.invoke(this.target, args);
	}

}
