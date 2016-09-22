/**
 * 
 * @author YZhi
 * @date 2012-5-24
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package dp.example.behaviour.strategy.life;

/**
 * 环境角色
 * @author YZhi
 * @since 1.0
 */
public class Context {
	private WorkAlgorithm workAlgorithm;

	public void work(){
		this.workAlgorithm.work();
	}
	
	public WorkAlgorithm getWorkAlgorithm() {
		return workAlgorithm;
	}

	public void setWorkAlgorithm(WorkAlgorithm workAlgorithm) {
		this.workAlgorithm = workAlgorithm;
	}
	
}
