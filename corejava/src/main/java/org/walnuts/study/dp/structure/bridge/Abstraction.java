package org.walnuts.study.dp.structure.bridge;

/**
 * 抽象化角色
 * @author YZhi
 * @since 1.0
 */
public abstract class Abstraction {
	private Implementor implementor;
	
	public Implementor getImplementor(){
		return implementor;
	}
	
	public Abstraction(Implementor implementor){
		this.implementor = implementor;
	}
	
	public void methodC(){
		this.implementor.methodA();
	}
}
