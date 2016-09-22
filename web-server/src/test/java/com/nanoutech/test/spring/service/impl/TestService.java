/**
 * nanoutech.com
 */
package com.nanoutech.test.spring.service.impl;

import org.springframework.stereotype.Service;

import com.nanoutech.test.spring.service.ITestService;

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
