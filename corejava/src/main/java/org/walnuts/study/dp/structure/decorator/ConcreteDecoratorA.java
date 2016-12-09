package org.walnuts.study.dp.structure.decorator;

/**
 * 具体装饰角色A
 * @author YZhi
 * @since 1.0
 */
public class ConcreteDecoratorA extends Decorator {
	public ConcreteDecoratorA(Component component){
		super(component);
	}
	private void methodA(){
		System.out.println("methodA in ConcreteDecoratorA");
	}
	@Override
	public void operate() {
		this.methodA();
		super.operate();
	}
}
