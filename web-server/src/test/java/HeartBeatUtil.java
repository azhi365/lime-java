import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class HeartBeatUtil {
    private static JedisPool pool = new JedisPool(new JedisPoolConfig(), "115.159.56.194", 6379, Integer.MAX_VALUE);

    public static void main(String args[]) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        TestThreadCallableFuture future;
        System.out.println("##");
        for (int i = 1; i < 10000; i++) {
            future = new TestThreadCallableFuture("heartbeat", 123l, "field" + i, pool.getResource());
            executor.submit(future);
        }
        System.out.println("end");
        executor.shutdown();
    }
}
