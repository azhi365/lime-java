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
 * 抽象拦截器
 * @author YZhi
 * @since 1.0
 */
public abstract class AbstractInterceptor {
	private ValueStack valueStack = ValueStackHelper.getValueStack();
	@SuppressWarnings("unused")
	private int type = 0;
	protected ValueStack getValueStack(){
		return this.valueStack;
	}
	public final void exec(){
		
	}
	protected abstract void setType(int type);
	protected abstract void intercept();
}
