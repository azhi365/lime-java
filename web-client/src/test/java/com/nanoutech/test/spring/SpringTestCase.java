package com.nanoutech.test.spring;

import com.nanoutech.dubbo.IDemoService;
import com.nanoutech.test.SpringBaseTestCase;
import org.junit.Test;

public class SpringTestCase extends SpringBaseTestCase {

    private IDemoService demoService;

    /**
     * 测试Spring
     */
    @Test
    public void testBasic() {
        this.demoService.sayHello();
    }
}