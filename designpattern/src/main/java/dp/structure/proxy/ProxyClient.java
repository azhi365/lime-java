package dp.structure.proxy;

import java.lang.reflect.InvocationHandler;

import org.junit.Test;
/**
 * <pre>
 * 
 * 一、定义
 *     代理模式(Proxy Pattern)，也称委托模式
 *     1、Provide a surrogate or placeholder for another object to control access to it.
 *     为其他对象提供一种代理以控制对这个对象的访问
 *     Subject 抽象主题角色
 *     RealSbuject 具体主题角色
 *     Proxy 代理主题角色
 * 二、优点
 *     职责清晰、高扩展性、智能化
 * 三、缺点
 *     
 * 四、条件
 *     
 * 五、适用性
 *     
 * 六、最佳实践
 *     Spring AOP
 * </pre>
 * 
 * <img src="doc-files/proxy.png" />
 * @author yzhi
 *
 */
public class ProxyClient {
	/**
	 *代理请求
	 */
	@Test
	public void testProxyRequest(){
		Proxy proxy = new Proxy();
		proxy.request();
		System.out.println("------------");
	}
	
	/**
	 *普通代理
	 */
	@Test
	public void testProxy(){
		Proxy proxy = new Proxy();
		proxy.method();
		proxy.methodA();
		proxy.methodB();
		System.out.println("------------");
	}
	/**
	 *动态代理
	 */
	@Test
	public void testDynamicProxy(){
		Subject subject = new RealSubjecOne();
		InvocationHandler handler = new MyInvocationHandler(subject);
		Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
		proxy.methodA();
		System.out.println("------------");
	}
	/**
	 *具体业务的动态代理
	 */
	@Test
	public void testSubjectDynamicProxy(){
		Subject subject = new RealSubjecOne();
		Subject proxy = SubjectDynamicProxy.newProxyInstance(subject);
		proxy.methodA();
		System.out.println("------------");
	}
}