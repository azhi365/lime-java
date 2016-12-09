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
 * 
 * @author YZhi
 * @since 1.0
 */
public class ViewManager {
	@SuppressWarnings("unused")
	private String actionName;
	@SuppressWarnings("unused")
	private ValueStack valueStack = ValueStackHelper.getValueStack();
	/**
	 * 
	 * @param actionName
	 */
	public ViewManager(String actionName) {
		this.actionName = actionName;
	}

	/**
	 *
	 * @param result
	 * @return
	 */
	public String getViewPath(String result) {
		AbsLangData langData = new GBLangData();
		AbsView view = new JSPView(langData);
		return view.getURI();
	}

}
