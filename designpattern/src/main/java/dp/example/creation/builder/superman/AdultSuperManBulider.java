/**
 * 
 * @author YZhi
 * @date 2012-5-17
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.creation.builder.superman;

/**
 * 成年超人建造者
 * @author YZhi
 * @since 1.0
 */
public class AdultSuperManBulider extends Builder {
	/* (non-Javadoc)
	 * @see dp.example.creation.builder.superman.Builder#getSuperMan()
	 */
	@Override
	public SuperMan getSuperMan() {
		super.setBody("Adult Body");
		super.setSpecialSymbol("Adult SpecialSymbo");
		super.setSpecialTalent("Adult specialTalent");
		return super.superMan;
	}
}
