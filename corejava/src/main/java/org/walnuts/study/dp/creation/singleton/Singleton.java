/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午03:28:35
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.creation.singleton;

/**
 * <pre>
 * 单例模式(Singleton Pattern)
 * 一、定义
 *     Ensure a class has only one instance,and provide a global point of access to it.
 *     确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例
 * 二、优点
 *     减少内存开支
 *     减少系统的性能开销
 *     可以避免对资源的多重占用
 *     可以在系统设置全局的访问点，优化和共享资源访问
 * 三、缺点
 *     一般没有接口，扩展很困难
 *     对测试是不利的，没有接口不能使用mock的方式虚拟一个对象
 *     与单一职责原则冲突
 * 四、条件
 *     
 * 五、适用性
 *     要求生成唯一序列号的环境
 *     整个项目需要一个共享访问点或共享数据
 *     创建一个对象需要消耗的资源过多，如要访问IO和数据库等资源
 *     需要定义大量的静态常量和静态方法，可以采用单例模式也可以直接声明为static
 * 六、最佳实践
 *     
 * </pre>
 * <img src="doc-files/singleton.png" />
 * @author yzhi
 */
public class Singleton {
	private static final Singleton singleton = new Singleton();
	
	public static Singleton getSingleton(){
		return singleton;
	}
	
	public static void doSomething(){
		
	} 
}
