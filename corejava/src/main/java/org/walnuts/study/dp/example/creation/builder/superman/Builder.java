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
 * 抽象建造者
 * @author YZhi
 * @since 1.0
 */
public abstract class Builder {
	protected final SuperMan superMan = new SuperMan();
	
	public void setBody(String body){
		this.superMan.setBody(body);
	}
	public void setSpecialTalent(String specialTalent) {
		this.superMan.setSpecialTalent(specialTalent);
	}
	public void setSpecialSymbol(String specialSymbol) {
		this.superMan.setSpecialSymbol(specialSymbol);
	}
	
	public abstract SuperMan getSuperMan();
}
