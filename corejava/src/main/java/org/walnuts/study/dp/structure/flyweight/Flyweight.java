package org.walnuts.study.dp.structure.flyweight;

/**
 * 抽象享元角色
 * @author YZhi
 * @since 1.0
 */
public abstract class Flyweight {
	
	private String intrnsic;
	
	protected final String extrinsic;
	
	public Flyweight(String extrinsic){
		this.extrinsic = extrinsic;
	}
	
	public abstract void operate();
	
	

	public String getIntrnsic() {
		return intrnsic;
	}

	public void setIntrnsic(String intrnsic) {
		this.intrnsic = intrnsic;
	}

	
	
}
