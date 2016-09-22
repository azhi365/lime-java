/**
 * 
 * @author yzhi
 * @date 2012-1-30 上午11:19:59
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.principle.lsp;

/**
 * 
 * <pre>
 * 里氏替换原则(Liskov Substitution Principle)
 * 一、定义
 *     1、If for each object o1 of type S there is an object o2 of type T such that
 * for all programs P defined in terms of T,the behavior of P is unchanged when o1 
 * is substituted for o2 then S is a subtype of T.
 *     如果对每一个类型为S的对象为o1,都有类型为T的对象o2,使得以T定义的所有程序在所有的对象o1都
 * 代换成o2时，程序的行为没有发生变化，那么类型S是类型T的子类型。
 *     2、Functions that user pointers or references to base classes must be able to
 * use objects of derived classes without knowing it
 *     所有引用基类的地方必须能透明地使用其子类的对象。
 *     里氏替换原则为良好的继承定义了一个规范：1、子类必须完全实现父类的方法 2、子类可以有自己的
 * 个性 3、覆盖或实现父类的方法时输入参数可以被放大（子类中方法的参数必须与父类中被覆盖的方法的参
 * 数相同或更宽松） 4、覆盖或实现父类的方法时输出结果可以被缩小 
 * 
 * 二、优点
 *     
 * 三、缺点
 *     
 * 四、条件
 *     
 * 五、适用性
 *     
 * 六、最佳实践
 *     
 * </pre>
 * @author yzhi
 * @date 2012-1-30
 * @version 
 */
public class LspClient {

}
