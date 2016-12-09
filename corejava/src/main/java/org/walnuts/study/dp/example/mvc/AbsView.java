/**
 * 
 * @author YZhi
 * @date 2012-5-31
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.mvc;

/**
 * 抽象视图
 * @author YZhi
 * @since 1.0
 */
public abstract class AbsView {
	private AbsLangData langData;

	/**
	 * 
	 * @param langData
	 */
	public AbsView(AbsLangData langData) {
		super();
		this.langData = langData;
	}
	public AbsLangData getLangData() {
		return langData;
	}
	public String getURI(){
		return null;
	}
	public abstract void assemble();
}
