package org.walnuts.study.dp.behaviour.templete;

/**
 * 具体模板类A
 * @author YZhi
 * @since 1.0
 */
public class ConcreteClassA extends AbstractClass {

	protected boolean isFlag(){
		return false;
	}
	
	@Override
	protected void methodA() {
		System.out.println("methodA in concreteClassA");
	}

	@Override
	protected void methodB() {
		System.out.println("methidB in concreteClassB");
	}

}
