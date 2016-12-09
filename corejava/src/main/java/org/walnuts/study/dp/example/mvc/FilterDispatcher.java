/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.mvc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 核心控制器
 * @author YZhi
 * @since 1.0
 */
public class FilterDispatcher implements Filter {
	private ValueStackHelper valueStachHelper = new ValueStackHelper();
	IActionDispather actionDispather = new ActionDispatcher();

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		chain.doFilter(req, res);
		String actionName = getActionNameFromURI(req);
		ViewManager viewManager = new ViewManager(actionName);
		/**
		 * 所有参数放入值抓栈
		 */
		@SuppressWarnings("unused")
		ValueStack valueStack = valueStachHelper.putIntoStack(req);
		String result = actionDispather.actionInvoke(actionName);
		String viewPath = viewManager.getViewPath(result);
		RequestDispatcher rd = req.getRequestDispatcher(viewPath);
		rd.forward(req, res);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	/**
	 *
	 * @param req
	 * @return
	 */
	private String getActionNameFromURI(HttpServletRequest req) {
		String path = (String)req.getRequestURI();
		String actionName = path.substring(path.lastIndexOf("/") + 1,path.lastIndexOf("."));
		return actionName;
	}
}
