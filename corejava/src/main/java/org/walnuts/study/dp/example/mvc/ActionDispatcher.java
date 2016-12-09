/**
 * 
 * @author YZhi
 * @date 2012-5-31
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.mvc;

import java.util.ArrayList;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class ActionDispatcher implements IActionDispather{
	private ActionManager actionManager = new ActionManager();
	
	@SuppressWarnings("unused")
	private ArrayList<Interceptors> listInterceptors = InterceptorFactory.createInterceptors();
	/* (non-Javadoc)
	 * @see dp.example.mvc.IActionDispather#actionInvoke(java.lang.String)
	 */
	@Override
	public String actionInvoke(String actionName) {
		return actionManager.exeAction(actionName);
	}

}
