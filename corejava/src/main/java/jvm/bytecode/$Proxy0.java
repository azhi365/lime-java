package jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 反编译的动态代理类的代码
 */
public final class $Proxy0 extends Proxy implements DynamicProxyTest.IHello {
    private static Method m3;
    private static Method m1;
    private static Method m0;
    private static Method m2;

    static {
        try {
            m3 = Class.forName("org.fenixsoft.bytecode.DynamicProxyTest$IHello").getMethod("sayHello", new Class[0]);
            m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[]{Class.forName("java.lang.Object")});
            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
        } catch (NoSuchMethodException localNoSuchMethodException) {
            throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
        } catch (ClassNotFoundException localClassNotFoundException) {
            throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
        }
    }

    public $Proxy0(InvocationHandler paramInvocationHandler)  {
        super(paramInvocationHandler);
    }

    // 此处由于版面原因，省略equals()、hashCode()、toString()三个方法的代码
    // 这3个方法的内容与sayHello()非常相似。

    public final void sayHello()  {
        try {
            this.h.invoke(this, m3, null);
            return;
        } catch (RuntimeException localRuntimeException) {
            throw localRuntimeException;
        } catch (Throwable localThrowable) {
            throw new UndeclaredThrowableException(localThrowable);
        }
    }
}

