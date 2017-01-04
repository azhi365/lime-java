package dp.structure.decorator;

/**
 * 抽象装饰角色
 * @author YZhi
 * @since 1.0
 */
public abstract class Decorator extends Component {
	private Component component;
	public Decorator(Component component) {
		this.component = component;
	}
	@Override
	public void operate() {
		this.component.operate();
	}

}
