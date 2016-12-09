package org.walnuts.study.dp.structure.flyweight;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class UnsharedConcreteFlyweight extends Flyweight {

	public UnsharedConcreteFlyweight(String extrinsic) {
		super(extrinsic);
	}

	@Override
	public void operate() {
		System.out.println("operate in UnsharedConcreteFlyweight");
	}

}
