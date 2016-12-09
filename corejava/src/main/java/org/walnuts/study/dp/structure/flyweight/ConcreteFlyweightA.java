package org.walnuts.study.dp.structure.flyweight;

/**
 * 具体享元角色A
 * @author YZhi
 * @since 1.0
 */
public class ConcreteFlyweightA extends Flyweight {

	public ConcreteFlyweightA(String extrinsic) {
		super(extrinsic);
	}

	@Override
	public void operate() {
		System.out.println("operate in ConcreteFlyweightA");
	}
}
