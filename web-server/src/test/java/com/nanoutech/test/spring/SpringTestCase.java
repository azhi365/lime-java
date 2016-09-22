package com.nanoutech.test.spring;

import javax.annotation.Resource;

import org.junit.Test;

import com.nanoutech.test.base.SpringBaseTestCase;
import com.nanoutech.test.spring.service.ITestService;

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