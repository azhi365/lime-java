/**
 * 
 * @author YZhi
 * @date 2012-5-30
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.observer.event;

/**
 * 工厂类
 * @author YZhi
 * @since 1.0
 */
public class ProductManager {
	private boolean canCreate = false;
	public Product createProduct(String name){
		this.canCreate = true;
		Product p = new Product(this,name);
		new ProductEvent(p, ProductEventType.NEW_PRODUCT);
		return p;
	}
	public void abandonProduct(Product p){
		new ProductEvent(p, ProductEventType.DEL_RPODUCT);
		p = null;
	}
	public void editProduct(Product p,String name){
		p.setName(name);
		new ProductEvent(p, ProductEventType.EDIT_PRODUCT);
	}
	
	public boolean isCanCreate() {
		return canCreate;
	}
	public void setCanCreate(boolean canCreate) {
		this.canCreate = canCreate;
	}
	
	public Product clone(Product p){
		new ProductEvent(p, ProductEventType.CLONE_PRODUCT);
		return p.clone();
	}
}
