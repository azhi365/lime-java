/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.command.cmd;

/**
 * 抽象命令名类
 * @author YZhi
 * @since 1.0
 */
public abstract class CommandName {
	private CommandName nextOperator;
	public final String handlerMessage(CommandVO vo){
		String result = " ";
		if(vo.getParam().size() == 0 || vo.getParam().contains(this.getOperateParam())){
			result = this.echo(vo);
		}else{
			if(this.nextOperator != null){
				return this.nextOperator.handlerMessage(vo);
			}else {
				result = "命令无法执行";
			}
		}
		return result;
	}
	
	public void setNext(CommandName operator){
		this.nextOperator = operator;
	}
	
	protected abstract String getOperateParam();
	protected abstract String echo(CommandVO vo);
}
