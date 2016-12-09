package org.walnuts.study.dp.structure.bridge;

/**
 * 具体实现化角色A
 * @author YZhi
 * @since 1.0
 */
public class ConcreteImplementorA implements Implementor {

	@Override
	public void methodA() {
		System.out.println("methodA in concreteImplementorA");
	}

	@Override
	public void methodB() {
		System.out.println("methodB in concreteImplementorA");
	}
}
