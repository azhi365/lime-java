/**
 * 
 * @author YZhi
 * @date 2012-5-31
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.mvc;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public abstract class ActionNode {
	private String actionName;
	private String actionClass;
	private String methidName = "execute";
	@SuppressWarnings("unused")
	private String view;
	public String getActionName() {
		return actionName;
	}
	public String getActionClass() {
		return actionClass;
	}
	public String getMethidName() {
		return methidName;
	}
	public abstract String getView(String result);
}
