package dp.structure.composite;

import org.junit.Test;

/**
 * <pre>
 * 
 * 一、定义
 *     组合模式(Composite Pattern) 也称合成模式或整体-部分(Part-Whole)
 *     1、Composite objects into tree structures to represent part-whole hierarchies.
 *     Composite lets clients treat individual objects and compositions of objects uniformly.
 *     将对象组合成树形结构以表示"部分-整体"的层次结构，使得用户对单个对象和组合对象的使用具有一致性。
 * 二、优点
 *     高层模块调用简单、节点自由增加
 * 三、缺点
 *     直接使用了实现类，与依赖倒置原则冲突
 * 四、条件
 *     
 * 五、适用性
 *     部分和整体关系，树型菜单、文件和文件夹管理
 *     从一个整体中能独立出部分模块和功能的场景
 * 六、最佳实践
 *     
 * </pre>
 * 
 * <img src="doc-files/composite.png" />
 * @author yzhi
 *
 */
public class CompositeClient {
	@Test
	public void test() {
		Composite root = new Composite();
		root.method();
		
		Composite branch = new Composite();
		Leaf leaf = new Leaf();
		root.add(branch);
		branch.add(leaf);
		CompositeClient.display(root);
	}
	
	public static void display(Composite root){
		for (Component c : root.getChildren()) {
			if(c instanceof Leaf){
				c.method();
			}else {
				display((Composite)c);
			}
		}
	}
}
