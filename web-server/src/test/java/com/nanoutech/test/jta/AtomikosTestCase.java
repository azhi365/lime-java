/**
 * 
 */
package com.nanoutech.test.jta;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import com.nanoutech.test.base.SpringBaseTestCase;
import com.nanoutech.test.jta.service.IUserService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author YZhi
 * @since 2015-11-18 下午3:36:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-atomikos.xml")
public class AtomikosTestCase extends SpringBaseTestCase {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource
	private IUserService userService;

    @Test
	public void saveAndReturnSuccess() {
		this.logger.info("begin...");
		try {
			userService.xa_save();
		} catch (Exception e) {
			this.logger.error("插入异常：", e);
		}
		this.logger.info("finish...");
	}

	public void saveWithException() {
		this.logger.info("begin...");
		try {
			userService.xa_save_error();
		} catch (Exception e) {
			this.logger.error("插入异常：", e);
		}
		this.logger.info("finish...");
	}

	@Test
	public void addToSingle() {
		try {
			userService.addToSingle();
		} catch (Exception e) {
			this.logger.error("插入异常：", e);
		}
	}

}
