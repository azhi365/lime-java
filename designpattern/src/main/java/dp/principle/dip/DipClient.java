/**
 * 
 * @author yzhi
 * @date 2012-1-30 上午11:52:42
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0s	
 *
 */
package dp.principle.dip;

/**
 * 
 * <pre>
 * 依赖倒置原则(Dependence Inversion Principle)
 * 一、定义
 *     1、High level modules should not depend upon low level modules.Both should
 * depend upon abstraction.Abstractions should not depend upon details.Details should
 * depend upon abstractions.
 *     高层模块不应该依赖低层模块，两者都应该依赖其抽象、抽象不应该依赖细节、细节应该依赖抽象
 *     减少类类间的耦合性
 *     依赖的三种方法：1、构造函数传递依赖对象  2、Setter方法传递依赖对象 3、接口声明依赖对象
 * 二、优点
 *     
 * 三、缺点
 *     
 * 四、条件
 *     
 * 五、适用性
 *     
 * 六、最佳实践
 *     每个类尽量都有接口或抽象类，或者抽象类和接口两者都具备
 *     变量的表面类型尽量是接口或是抽象类
 *     任何类都不应该从具体类派生
 *     尽量不要覆盖基类的方法
 * </pre>
 * @author yzhi
 * @date 2012-1-30
 * @version 
 */
public class DipClient {

}
