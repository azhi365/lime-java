package dp.behaviour.visitor;

/**
 * 
 * <pre>
 * 
 * 一、定义
 *     访问者模式(visitor Pattern)
 *     Represent an operation to be performed on the elements of an object structure.
 *     Visitor lets you define a new operation without changing the classes of the elements on which it opeartes.
 *     封装一些作用于某种数据结构中的务元素的操作，它可以在不改变数据结构的前提下定义作用于这些元素的新的操作。
 *     
 * 二、优点
 *     符合单一职责原则
 *     优秀的扩展性
 *     灵活性非常高
 * 三、缺点
 *     具体元素对访问者公布细节
 *     具体元素变更比较困难
 *     违背了依赖倒置原则
 * 四、条件
 *     
 * 五、适用性
 *     需要对一个对象结构中的对象进行很多不同并且为相关的操作
 *     可以充当拦截器(Interceptor)角色
 * 六、最佳实践
 *     
 * </pre>
 * 
 * <img src="doc-files/visitor.png" />
 * @author yzhi
 *
 */
public class VisitorClient {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Element e1 = ObjectStruture.creteElement();
			e1.accept(new Visitor());
		}
	}
}
