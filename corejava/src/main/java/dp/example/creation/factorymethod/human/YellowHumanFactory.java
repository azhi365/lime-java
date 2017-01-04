/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午03:09:48
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.creation.factorymethod.human;

/**
 * 黄色人类的创建 类
 * @author YZhi
 * @since 1.0
 */
public class YellowHumanFactory extends AbstractHumanMultiFactory {

	/* (non-Javadoc)
	 * @see creation.factorymethod.example.human.AbstractHumanMultiFactory#createHuman()
	 */
	@Override
	public Human createHuman() {
		return new YellowHuman();
	}

}
