/**
 * @author yzhi
 * @date 2012-1-19 下午04:57:27
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0
 */
package dp.creation.builder;

/**
 * 具体创建者
 * @author YZhi
 * @since 1.0
 */
public class ConcreteBuilder extends Builder {
    private Product product = new Product();

    @Override
    public Product buildProduct() {
        return product;
    }

    @Override
    public void setPart() {

    }

}
