/**
 * 
 * @author yzhi
 * @date 2012-1-29 上午10:56:29
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.structure.composite.corp;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 
 * @author yzhi
 * @date 2012-1-29
 * @version 
 */
public class CorpClient {
	public String getTreeInfo(Branch root){
		ArrayList<Corp> subordinateList = root.getSubordinate();
		String info = "";
		for (Corp corp : subordinateList) {
			if(corp instanceof Leaf){
				info = info + corp.getInfo() + "\n";
			}else {
				info = info + corp.getInfo() + "\n" + getTreeInfo((Branch)corp);
			}
		}
		return info;
	}
	@Test
	public void testTreeInfo(){
		Branch root = new Branch("root", "a", 1);
		Branch branch = new Branch("branch1", "a", 1);
		Leaf leaf = new Leaf("leaf", "b", 2);
		root.addSubordinate(branch);
		branch.addSubordinate(leaf);
		System.out.println(this.getTreeInfo(root));
	}
}
