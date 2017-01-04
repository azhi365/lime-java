/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午03:11:17
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.behaviour.chainofresponsibility;

/**
 * 抽象处理者
 * @author YZhi
 * @since 1.0
 */
public abstract class Handler {
	private Handler nextHandler;
	public final Response handleMessage(Request request){
		Response response = null;
		if(this.getHandlerLevel().equals(request.getRequestLevel())){
			response = this.echo(request);
		}else {
			if(this.nextHandler != null){
				response = this.nextHandler.handleMessage(request);
			}
		}
		return response;
	}
	
	public void setNext(Handler handler) {
		this.nextHandler = handler;
	}
	
	protected abstract Level getHandlerLevel();
	protected abstract Response echo(Request request);
}
