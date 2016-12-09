package org.walnuts.study.dp.behaviour.state;

/**
 * 具体状态B
 * @author YZhi
 * @since 1.0
 */
public class ConcreteStateB extends State {

	@Override
	public void handleA() {
		System.out.println("handleA in ConcreteStateB");
	}

	@Override
	public void handleB() {
		System.out.println("handleB in ConcreteStateB");
	}

}
