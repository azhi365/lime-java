package org.walnuts.study.dp.behaviour.mediator;

/**
 * 通用中介者
 * @author YZhi
 * @since 1.0
 */
public class ConcreteMediator extends Mediator {

	@Override
	public void mehtodB() {
		System.out.println("methodB in ConcreteMediator");
	}

	@Override
	public void methodA() {
		System.out.println("methodA in ConcreteMediator");
	}

}
