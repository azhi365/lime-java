/**
 * 
 * @author yzhi
 * @date 2012-1-19 下午03:40:27
 * @copyright 2012 haitian.com All rights reserved
 * @version V1.0	
 *
 */
package dp.example.creation.singleton.emperor;

import java.util.ArrayList;
import java.util.Random;

/**
 * 固定数量的皇帝类
 * @author YZhi
 * @since 1.0
 */
public class EmperorMulti {
	private static int maxNumOfEmperor = 2;
	private static ArrayList<String> nameList = new ArrayList<String>();
	private static ArrayList<EmperorMulti> emperorMultiList = new ArrayList<EmperorMulti>();
	private static int indexOfEmperor = 0;
	static{
		for (int i = 0; i < maxNumOfEmperor; i++) {
			emperorMultiList.add(new EmperorMulti("Emperor " + i));
		}
	}
	
	private EmperorMulti(){
		
	}
	private EmperorMulti(String name){
		nameList.add(name);
	}
	
	public static EmperorMulti getInstance(){
		Random random = new Random();
		indexOfEmperor = random.nextInt(maxNumOfEmperor);
		return emperorMultiList.get(indexOfEmperor);
	}
	public void say() {
		System.out.println(nameList.get(indexOfEmperor));
	}
}
