/**
 * 
 */
package org.walnuts.study.dp.structure.proxy;

/**
 * 真实主题1类
 * @author YZhi
 * @since 1.0
 */
public class RealSubjecOne implements Subject {
	
	/* (non-Javadoc)
	 * @see structure.proxy.Subject#request()
	 */
	@Override
	public void request() {
		System.out.println("request implemented in RealSubjectOne");
	}
	
	@Override
	public void methodA() {
		System.out.println("methodA implemented in RealSubjectOne");
	}

	@Override
	public void methodB() {
		System.out.println("methodB implemented in RealSubjectOne");
	}

}
