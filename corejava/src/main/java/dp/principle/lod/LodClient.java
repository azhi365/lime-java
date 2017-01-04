/**
 * 
 * @author yzhi
 * @date 2012-1-30 下午03:12:05
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.principle.lod;

/**
 * 
 * <pre>
 * 迪米特原则(Law of Demeter,LoD)
 * 一、定义
 *     1、.
 *     一个对象应该对其他对象有最少的了解
 *     2、Only talk to your immediate friends
 *     只与直接的朋友通信
 *     朋友类：出现在成员变量、方法的输入输出参数中的类
 *     核心观念类间解耦，弱耦合
 *     1、只和朋友交流 2、朋友间也是有距离的 3、是自己的就是自己的：如果一个方法放在本类中，即不增加类
 * 间关系，也对本类不产生负面影响，就放置在本类中。4、谨慎使用Serializable
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
public class LodClient {

}
