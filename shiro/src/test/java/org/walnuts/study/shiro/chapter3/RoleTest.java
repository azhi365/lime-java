package org.walnuts.study.shiro.chapter3;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-26
 * <p>Version: 1.0
 */
public class RoleTest extends BaseTest {

    private static String resourcePath = "classpath:chapter3/";

    @Test
    public void testHasRole() {
        login(resourcePath + "shiro-role.ini", "zhang", "123");

        Assert.assertTrue(subject().hasRole("role1"));

        Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1", "role2")));
        boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));
        Assert.assertTrue(result[0]);
        Assert.assertTrue(result[1]);
        Assert.assertFalse(result[2]);
    }

    @Test(expected = UnauthorizedException.class)
    public void testCheckRole() {
        login(resourcePath + "shiro-role.ini", "zhang", "123");
        //断言拥有角色：role1
        subject().checkRole("role1");
        //断言拥有角色：role1 and role3 失败抛出异常
        subject().checkRoles("role1", "role3");
    }

}
