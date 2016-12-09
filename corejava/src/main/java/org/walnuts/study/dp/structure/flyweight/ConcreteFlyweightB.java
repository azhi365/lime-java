package org.walnuts.study.dp.structure.flyweight;

/**
 * 具体享元角色B
 * @author YZhi
 * @since 1.0
 */
public class ConcreteFlyweightB extends Flyweight {

	public ConcreteFlyweightB(String extrinsic) {
		super(extrinsic);
	}

	@Override
	public void operate() {
		System.out.println("opreate in ConcreteFlyweightB");
	}

}
