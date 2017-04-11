package com.nanoutech.lime.test.spring;

import com.nanoutech.lime.dubbo.IDemoService;
import com.nanoutech.lime.test.SpringBaseTestCase;
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