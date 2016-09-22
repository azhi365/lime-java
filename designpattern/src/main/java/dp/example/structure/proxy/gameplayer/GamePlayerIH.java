/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午09:23:10
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.proxy.gameplayer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 * 
 * @author YZhi
 * @since 1.0
 */
public class GamePlayerIH implements InvocationHandler {
	Class<?> cls = null;
	Object obj = null;

	public GamePlayerIH(Object obj) {
		this.obj = obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = method.invoke(this.obj, args);
		if (method.getName().equalsIgnoreCase("login")) {
			System.out.println("method login is invoked");
		}
		return result;
	}

}
