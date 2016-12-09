package org.walnuts.study.dp.structure.bridge;

/**
 * 具体实现化角色B
 * @author YZhi
 * @since 1.0
 */
public class ConcreteImplementorB implements Implementor {

	@Override
	public void methodA() {
		System.out.println("methodA in concreteImplementorB");
	}

	@Override
	public void methodB() {
		System.out.println("methodB in concreteImplementorB");
	}

}
