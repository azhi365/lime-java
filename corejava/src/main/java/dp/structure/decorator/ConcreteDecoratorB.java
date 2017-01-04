package dp.structure.decorator;

/**
 * 具体装饰角色B
 * @author YZhi
 * @since 1.0
 */
public class ConcreteDecoratorB extends Decorator {

	public ConcreteDecoratorB(Component component) {
		super(component);
	}
	
	private void methodB() {
		System.out.println("methodB in ConcreteDecoratorB");
	}
	
	@Override
	public void operate() {
		super.operate();
		this.methodB();
	}

}
