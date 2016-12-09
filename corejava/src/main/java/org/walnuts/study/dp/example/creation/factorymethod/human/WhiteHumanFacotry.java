/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午03:10:17
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.factorymethod.human;

/**
 * 白色人类的创建 类
 * @author YZhi
 * @since 1.0
 */
public class WhiteHumanFacotry extends AbstractHumanMultiFactory {

	/* (non-Javadoc)
	 * @see creation.factorymethod.example.human.AbstractHumanMultiFactory#createHuman()
	 */
	@Override
	public Human createHuman() {
		return new WhiteHuman();
	}

}
