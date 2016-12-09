package org.walnuts.study.dp.structure.decorator;

/**
 * 具体构件
 * @author YZhi
 * @since 1.0
 */
public class ConcreteComponent extends Component {

	@Override
	public void operate() {
		System.out.println("operate in concreteComponent");
	}

}
