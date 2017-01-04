package jvm.monitoring;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

/**
 * BTrace Script Template
 */
@BTrace
public class BTracingScript {
    @OnMethod(clazz = "jvm.monitoring.BTraceTest", method = "add", location = @Location(Kind.RETURN))

    public static void func(@Self BTraceTest instance, int a, int b, @Return int result) {
        println("调用堆栈:");
        jstack();
        println(strcat("方法参数A:", str(a)));
        println(strcat("方法参数B:", str(b)));
        println(strcat("方法结果:", str(result)));
    }
}

