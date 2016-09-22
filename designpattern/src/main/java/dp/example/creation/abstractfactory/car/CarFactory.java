/**
 * 
 * @author YZhi
 * @date 2012-5-17
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.creation.abstractfactory.car;

/**
 * 抽象工厂
 * @author YZhi
 * @since 1.0
 */
public interface CarFactory {
	public ICar createSuv();
	public ICar createVan();
}
