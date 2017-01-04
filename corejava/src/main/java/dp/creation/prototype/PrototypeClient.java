/**
 * 
 * @author yzhi
 * @date 2012-1-20 上午10:16:47
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.creation.prototype;

import org.junit.Test;

/**
 * 
 * <pre>
 * 
 * 一、定义
 *     原型模式(Prototype Pattern)
 *     1、Specify the kinds of object to create using a prototypical instance,
 *     and create new objects by copying this prototype.
 *     用原型实例指定创建对象的种类，并且通过复制这些原型创建新的对象
 *     
 * 二、优点
 *     性能优良、逃避构造函数的约束
 * 三、缺点
 *     
 * 四、条件
 *     构造函数不会被执行、clone与final不能同时使用
 * 五、适用性
 *     资源优化场景、性能和安全要求的场景、一个对象多个修改者的场景
 * 六、最佳实践
 *     
 * </pre>
 * <img src="doc-files/prototype.png" />
 * @author yzhi
 */
public class PrototypeClient {
	
	/**
	 *构造函数不会被执行
	 */
	@Test
	public void testThing(){
		Thing thing = new Thing();
		Thing cloneThing = thing.clone();
		cloneThing.toString();
	}
	/**
	 *浅拷贝
	 */
	@Test
	public void testShallowCopy(){
		ShallowCopy shallowCopy = new ShallowCopy();
		shallowCopy.getArrayList().add("zhang san");
		ShallowCopy cloneShallowCopy = shallowCopy.clone();
		cloneShallowCopy.getArrayList().add("li si");
		System.out.println(cloneShallowCopy.getArrayList());
	}
	/**
	 *深拷贝
	 */
	@Test
	public void testDeepCopy(){
		DeepCopy deepCopy = new DeepCopy();
		deepCopy.getArrayList().add("zhang san");
		DeepCopy cloneDeepCopy = deepCopy.clone();
		cloneDeepCopy.getArrayList().add("li si");
		System.out.println(deepCopy.getArrayList());
		System.out.println(cloneDeepCopy.getArrayList());
	}
}
