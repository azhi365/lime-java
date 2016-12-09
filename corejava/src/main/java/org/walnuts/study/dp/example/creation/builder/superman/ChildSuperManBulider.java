/**
 * 
 * @author YZhi
 * @date 2012-5-17
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.creation.builder.superman;

/**
 * 未成人超人建造者
 * @author YZhi
 * @since 1.0
 */
public class ChildSuperManBulider extends Builder {

	/* (non-Javadoc)
	 * @see dp.example.creation.builder.superman.Builder#getSuperMan()
	 */
	@Override
	public SuperMan getSuperMan() {
		super.setBody("Child Body");
		super.setSpecialSymbol("Child SpecialSymbo");
		super.setSpecialTalent("Child specialTalent");
		return super.superMan;
	}
	
}
