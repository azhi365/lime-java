/**
 * 
 * @author YZhi
 * @date 2012-5-17
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.creation.builder.car;

/**
 * 导演类
 * @author YZhi
 * @since 1.0
 */
public class Director {
	private CarBulider benzBulider = new BenzBulider();
	private CarBulider bmwBulider = new BMWBuilder();
	public ICar createBenzSuv(){
		return createCar(benzBulider, "benz Engine", "benz Wheel");
	}
	
	public ICar createBMWVan(){
		return createCar(bmwBulider, "BMW Engine", "BMW Wheel");
	}
	
	public ICar createComplexCar(){
		return createCar(bmwBulider, "BMW Engine", "Benz Wheel");
	}
	
	private ICar createCar(CarBulider carBulider,String engine,String wheel){
		Blueprint bp = new Blueprint();
		bp.setEngine(engine);
		bp.setWheel(wheel);
		carBulider.recevieBlueprint(bp);
		return carBulider.bulidCar();
	}
}

