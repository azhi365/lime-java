/**
 * 
 * @author YZhi
 * @date 2012-5-31
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.mvc;

import java.util.Map;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class JSPView extends AbsView {

	/**
	 * 
	 * @param langData
	 */
	public JSPView(AbsLangData langData) {
		super(langData);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see dp.example.mvc.AbsView#assemble()
	 */
	@Override
	@SuppressWarnings("unused") 
	public void assemble() {
		Map<String, String> langMap = getLangData().getItems();
		for (String key : langMap.keySet()) {
			
		}
	}
	
}
