package org.walnuts.study.dp.structure.adapter;

import org.junit.Test;

/**
 * <pre>
 * 
 * 一、定义
 *     适配器模式(Adapter Pattern) 也称变压器模式或包装模式(Wrapper)
 *     Convert the interface of a class into another interface clients expect.
 *     Apdater lets classes work together that couldn`t otherwise because of incompatible interfaces.
 *     将一个类的接口变换成客户端所期待的另一种接口，从而使原本接口不匹配而无法在一起工作的两个尖能够在一起工作。
 *     
 * 二、优点
 *     增加类的透明度
 *     提高类的复用度
 *     灵活性非常好
 * 三、缺点
 *     
 * 四、条件
 *     
 * 五、适用性
 *     
 * 六、最佳实践
 *     
 * </pre>
 * 
 * <img src="doc-files/adapter.png" />
 * @author yzhi
 *
 */
public class AdapterClient {
	@Test
	public void test() {
		Target target = new ConcreteTarget();
		target.request();
		
		Target target2 = new Adapter();
		target2.request();
	}
}
