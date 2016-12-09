package org.walnuts.study.dp.structure.flyweight;

/**
 * 
 * <pre>
 * 
 * 一、定义
 *     享元模式(Flyweight Pattern) 池技术的重要实现方式
 *     1、Using sharing to support large numbers of fine-gained objects efficiently
 *     使用共享对象可有效地支持大量的细粒度的对象
 * 二、优点
 *     减少应用程序创建对象
 * 三、缺点
 *     
 * 四、条件
 *     
 * 五、适用性
 *     系统中存在大量相似对象
 *     细粒度的对象都具备较接近的外部状态，而内部状态与环境无关
 *     缓冲池的场景
 * 六、最佳实践
 *     
 * </pre>
 * 
 * <img src="doc-files/flyweight.png" />
 * @author yzhi
 *
 */
public class FlyweightClient {
	public static void main(String[] args) {
		Flyweight flyweightA = FlyweightFactory.getFlyweight("A");
		Flyweight flyweightB = FlyweightFactory.getFlyweight("A");
		Flyweight flyweightC = FlyweightFactory.getFlyweight("B");
		System.out.println(flyweightA == flyweightB);
		System.out.println(flyweightA == flyweightC);
		flyweightA.operate();
	}
}
