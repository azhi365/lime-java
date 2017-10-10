package com.innstack.lime.test.spring;

import com.innstack.lime.dubbo.IDemoService;
import com.innstack.lime.test.SpringBaseTestCase;
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