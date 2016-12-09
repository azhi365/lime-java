package org.walnuts.study.dp.behaviour.state;

/**
 * 具体状态A
 * @author YZhi
 * @since 1.0
 */
public class ConcreteStateA extends State {

	@Override
	public void handleA() {
		System.out.println("handleA in ConcreteStateA");
	}

	@Override
	public void handleB() {
		System.out.println("handleB in ConcreteStateA");
	}

}
