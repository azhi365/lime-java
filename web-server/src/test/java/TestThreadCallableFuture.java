import redis.clients.jedis.Jedis;

import java.util.concurrent.Callable;

public class TestThreadCallableFuture implements Callable<String> {
	private Jedis jedis = null;
	private String key="";
	private String field="";
	Long num=0l;

	public TestThreadCallableFuture(String key,Long num,String field,Jedis jedis){
		this.key=key;
		this.num=num;
		this.field=field;
		this.jedis = jedis;
	}

	@Override
	public String call() throws Exception {
		jedis.zadd(key, num, field);
        jedis.close();
		return field;
	}

}
