/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午06:01:45
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.structure.proxy;

/**
 * 虚拟代理类
 * 在需要的时候才初始化主题对象
 * @author YZhi
 * @since 1.0
 */
public class ProxyVirtual implements Subject {
	private Subject subject;
	
	/* (non-Javadoc)
	 * @see structure.proxy.Subject#methodA()
	 */
	@Override
	public void methodA() {
		
	}

	/* (non-Javadoc)
	 * @see structure.proxy.Subject#methodB()
	 */
	@Override
	public void methodB() {
		
	}

	/* (non-Javadoc)
	 * @see structure.proxy.Subject#request()
	 */
	@Override
	public void request() {
		if(subject == null){
			subject = new RealSubjecOne();
		}
		subject.request();
	}

}
