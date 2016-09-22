/**
 * 
 * @author yzhi
 * @date 2012-1-20 下午03:36:15
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.behaviour.chainofresponsibility.women;

/**
 * 处理类
 * @author YZhi
 * @since 1.0
 */
public abstract class Handler {
	public final static int FATHER_LEVEL_REQUEST = 1;
	public final static int HUSBAND_LEVEL_REQUEST = 2;
	public final static int SON_LEVEL_REQUEST = 3;
	private int level = 0;
	private Handler nextHandler;
	public Handler(int level){
		this.level = level;
	}
	
	public final void handlerMessage(IWomen women){
		if(women.getType() == this.level){
			this.response(women);
		}else {
			if(this.nextHandler != null){
				this.nextHandler.handlerMessage(women);
			}else {
				System.out.println("can not handle");
			}
		}
	}
	public void setNext(Handler handler){
		this.nextHandler = handler;
	}
	
	protected abstract void response(IWomen women);
}
