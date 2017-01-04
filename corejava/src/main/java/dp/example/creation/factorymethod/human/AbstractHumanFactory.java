/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午02:53:09
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.creation.factorymethod.human;

/**
 * 抽象人类创建工厂
 * @author YZhi
 * @since 1.0
 */
public abstract class AbstractHumanFactory {
	public abstract <T extends Human> T createHuman(Class<T> c);
}
