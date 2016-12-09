/**
 * 
 */
package org.walnuts.study.dp.structure.facade;

/**
 * 门面角色
 * @author YZhi
 * @since 1.0
 */
public class Facade {
	private Process process = new ProcessImpl();
	public void operate() {
		process.stepOne();
		process.stepTwo();
		process.stepThree();
	}
	
	private ProcessA processA = new ProcessA();
	private ProcessB processB = new ProcessB();
	private ProcessC processC = new ProcessC();
	
	public void MethodA() {
		this.processA.methodA();
	}
	
	public void MethodB(){
		this.processB.methodB();
	}
	
	public void MethodC(){
		this.processC.methodC();
	}
}