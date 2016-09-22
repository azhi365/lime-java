/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午04:17:51
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.creation.abstractfactory.human;

/**
 * 男性生产工厂
 * @author YZhi
 * @since 1.0
 */
public class MaleFactory implements HumanFactory {

	/* (non-Javadoc)
	 * @see creation.abstractfactory.example.human.HumanFactory#createBlackHuman()
	 */
	@Override
	public Human createBlackHuman() {
		return new MaleBlackHuman();
	}

	/* (non-Javadoc)
	 * @see creation.abstractfactory.example.human.HumanFactory#createWhiteHuman()
	 */
	@Override
	public Human createWhiteHuman() {
		return new MaleWhiteHuman();
	}

	/* (non-Javadoc)
	 * @see creation.abstractfactory.example.human.HumanFactory#createYellowHuman()
	 */
	@Override
	public Human createYellowHuman() {
		return new MaleYellowHuman();
	}

}
