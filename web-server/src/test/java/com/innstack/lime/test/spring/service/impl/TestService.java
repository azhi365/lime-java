/**
 * nanoutech.com
 */
package com.innstack.lime.test.spring.service.impl;

import com.innstack.lime.test.spring.service.ITestService;
import org.springframework.stereotype.Service;

/**
 * 
 * @author YZhi
 * @since 2015-11-17 下午1:51:04
 */
@Service
public class TestService implements ITestService {
	@Override
	public void test() {
		System.out.println("test in spring");
	}
}
