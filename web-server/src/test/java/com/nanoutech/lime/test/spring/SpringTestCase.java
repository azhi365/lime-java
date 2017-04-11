package com.nanoutech.lime.test.spring;

import javax.annotation.Resource;

import com.nanoutech.lime.test.base.SpringBaseTestCase;
import com.nanoutech.lime.test.spring.service.ITestService;
import org.junit.Test;

public class SpringTestCase extends SpringBaseTestCase {

	@Resource
	private ITestService testService;

	/**
	 * 测试Spring
	 */
	@Test
	public void testBasic() {
		this.testService.test();
	}
}