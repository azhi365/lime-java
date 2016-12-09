package org.walnuts.study.dp.behaviour.templete;
/**
 * 抽象模板类
 * @author YZhi
 * @since 1.0
 */
public abstract class AbstractClass {
	protected abstract void methodA();
	protected abstract void methodB();
	protected boolean isFlag(){
		return true;
	}
	
	public void templeteMethod() {
		this.methodA();
		if(this.isFlag()){
			this.methodB();
		}
	}
}
