package com.nanoutech.lime.test.redis;

import com.nanoutech.lime.base.Config;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

import java.util.*;

public class JedisUtilTest {

    JedisPool pool;
    Jedis jedis;





    @Before
    public void setUp() {
        pool = new JedisPool(new JedisPoolConfig(), Config.redisURL);

        jedis = pool.getResource();
        //jedis.auth("password");

    }

    @Test
    public void testGet() {
        System.out.println(jedis.get("lu"));
    }

    /**
     * Redis能存储二进制安全的字符串，最大长度为1GB
     * <p/>
     * Redis存储初级的字符串 CRUD
     */
    @Test
    public void testBasicString() {

        jedis.set("name", "minxr");
        System.out.println(jedis.get("name"));

        // -----修改数据-----------
        // 1、在原来基础上修改
        jedis.append("name", "jarorwar"); // 很直观，类似map 将jarorwar
        // append到已经有的value之后
        System.out.println(jedis.get("name"));// 执行结果:minxrjarorwar

        // 2、直接覆盖原来的数据
        jedis.set("name", "闵晓荣");
        System.out.println(jedis.get("name"));// 执行结果：闵晓荣

        // 删除key对应的记录
        jedis.del("name");
        System.out.println(jedis.get("name"));// 执行结果：null

        /**
         * mset相当于 jedis.set("name","minxr"); jedis.set("jarorwar","闵晓荣");
         */
        jedis.mset("name", "minxr", "jarorwar", "闵晓荣");
        System.out.println(jedis.mget("name", "jarorwar"));

    }

    /**
     * jedis操作Map
     */
    @Test
    public void testMap() {
        Map<String, String> user = new HashMap<String, String>();
        user.put("name", "minxr");
        user.put("pwd", "password");
        jedis.hmset("user", user);
        // 取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
        // 第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
        List<String> rsmap = jedis.hmget("user", "name");
        System.out.println(rsmap);

        // 删除map中的某个键值
        // jedis.hdel("user","pwd");
        System.out.println(jedis.hmget("user", "pwd")); // 因为删除了，所以返回的是null
        System.out.println(jedis.hlen("user")); // 返回key为user的键中存放的值的个数1
        System.out.println(jedis.exists("user"));// 是否存在key为user的记录 返回true
        System.out.println(jedis.hkeys("user"));// 返回map对象中的所有key [pwd, name]
        System.out.println(jedis.hvals("user"));// 返回map对象中的所有value [minxr,
        // password]

        Iterator<String> iter = jedis.hkeys("user").iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + jedis.hmget("user", key));
        }

    }

    /**
     * jedis操作List
     */
    @Test
    public void testList() {
        // 开始前，先移除所有的内容
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework", 0, -1));
        // 先向key java framework中存放三条数据
        jedis.lpush("java framework", "spring");
        jedis.lpush("java framework", "struts");
        jedis.lpush("java framework", "hibernate");
        // 再取出所有数据jedis.lrange是按范围取出，
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        System.out.println(jedis.lrange("java framework", 0, -1));
    }

    /**
     * jedis操作Set
     */
    @Test
    public void testSet() {
        // 添加
        jedis.sadd("sname", "minxr");
        jedis.sadd("sname", "jarorwar");
        jedis.sadd("sname", "闵晓荣");
        jedis.sadd("sanme", "noname");
        // 移除noname
        jedis.srem("sname", "noname");
        System.out.println(jedis.smembers("sname"));// 获取所有加入的value
        System.out.println(jedis.sismember("sname", "minxr"));// 判断 minxr
        // 是否是sname集合的元素
        System.out.println(jedis.srandmember("sname"));
        System.out.println(jedis.scard("sname"));// 返回集合的元素个数
    }

    @Test
    public void test() throws InterruptedException {
        // keys中传入的可以用通配符
        System.out.println(jedis.keys("*")); // 返回当前库中所有的key [sose, sanme, name,
        // jarorwar, foo, sname, java
        // framework, user, braand]
        System.out.println(jedis.keys("*name"));// 返回的sname [sname, name]
        System.out.println(jedis.del("sanmdde"));// 删除key为sanmdde的对象 删除成功返回1
        // 删除失败（或者不存在）返回 0
        System.out.println(jedis.ttl("sname"));// 返回给定key的有效时间，如果是-1则表示永远有效
        jedis.setex("timekey", 10, "min");// 通过此方法，可以指定key的存活（有效时间） 时间为秒
        Thread.sleep(5000);// 睡眠5秒后，剩余时间将为<=5
        System.out.println(jedis.ttl("timekey")); // 输出结果为5
        jedis.setex("timekey", 1, "min"); // 设为1后，下面再看剩余时间就是1了
        System.out.println(jedis.ttl("timekey")); // 输出结果为1
        System.out.println(jedis.exists("key"));// 检查key是否存在
        System.out.println(jedis.rename("timekey", "time"));
        System.out.println(jedis.get("timekey"));// 因为移除，返回为null
        System.out.println(jedis.get("time")); // 因为将timekey 重命名为time 所以可以取得值
        // min

        // jedis 排序
        // 注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）
        jedis.del("a");// 先清除数据，再加入数据进行测试
        jedis.rpush("a", "1");
        jedis.lpush("a", "6");
        jedis.lpush("a", "3");
        jedis.lpush("a", "9");
        System.out.println(jedis.lrange("a", 0, -1));// [9, 3, 6, 1]
        System.out.println(jedis.sort("a")); // [1, 3, 6, 9] //输入排序后结果
        System.out.println(jedis.lrange("a", 0, -1));

    }




    @Test
    public void testRedis() {
        try {
            //String类型

            //Redis能存储二进制安全的字符串，最大长度为1GB
            jedis.set("name", "John Doe");
            String name = jedis.get("name");
            System.out.println(name);

            //String类型还支持批量的读写操作
            jedis.mset("age", "30", "sex", "male");
            List<String> strings = jedis.mget("age", "sex");
            System.out.println(strings);

            //String类型其实也可以用来存储数字，并支持对数字的加减操作。
            Long age = jedis.incr("age");
            System.out.println(age);
            age = jedis.incrBy("age", 4);
            System.out.println(age);
            age = jedis.decr("age");
            System.out.println(age);
            age = jedis.decrBy("age", 4);
            System.out.println(age);

            //List类型 Redis能够将数据存储成一个链表，并能对这个链表进行丰富的操作
            jedis.lpush("students", "John Doe", "Captain Kirk");
            jedis.llen("students");
            jedis.lrange("students", 0, 1);
            jedis.lrem("students", 1, "John Doe");//删除前count个值等于value的元素


            //set类型 Redis能够将一系列不重复的值存储成一个集合
            jedis.sadd("birds", "crow");
            jedis.sadd("birds", "crow");
            jedis.sadd("birds", "pigeon");
            jedis.sadd("birds", "bat");
            jedis.smembers("birds");
            jedis.srem("birds", "crow");

            jedis.sadd("mammals", "pigeon");
            jedis.sadd("mammals", "bat");

            jedis.sinter("birds", "mammals");//交集
            jedis.sunion("birds", "mammals");//并集
            jedis.sdiff("birds", "mammals");//补集


            //有序集合（Sorted Sets）类型
            jedis.zadd("days", 0, "mon");
            jedis.zadd("days", 1, "tue");
            jedis.zadd("days", 2, "wed");
            jedis.zadd("days", 3, "thu");
            jedis.zadd("days", 4, "fri");
            jedis.zadd("days", 5, "sat");
            jedis.zadd("days", 6, "sun");
            jedis.zcard("days");
            Set<String> days = jedis.zrange("days", 0, 6);
            System.out.println(days);
            Double score = jedis.zscore("days", "sat");
            System.out.println(score);
            Long count = jedis.zcount("days", 3, 6);
            System.out.println(count);
            Set<String> set = jedis.zrangeByScore("days", 3, 6);
            System.out.println(set);

            //Hash类型 Redis能够存储key对多个属性的数据（比如user1.uname user1.passwd）
            Set<String> keys = jedis.keys("student");
            System.out.println(keys);
            List<String> values = jedis.hvals("student");
            System.out.println(values);
            Map<String, String> map = jedis.hgetAll("student");
            System.out.println(map);
            jedis.hdel("student", "sex");
            map = jedis.hgetAll("student");
            System.out.println(map);

            Map<String, String> kid = new HashMap<String, String>();
            kid.put("name", "Akshi");
            kid.put("age", "2");
            kid.put("sex", "Female");
            jedis.hmset("kid ", kid);
            jedis.hmget("kid", "name", "age", "sex");

            //用一个客户端订阅管道
            JedisPubSub jedisPubSub = new JedisPubSub() {

                @Override
                public void onUnsubscribe(String channel, int subscribedChannels) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onSubscribe(String channel, int subscribedChannels) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onPUnsubscribe(String pattern, int subscribedChannels) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onPSubscribe(String pattern, int subscribedChannels) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onPMessage(String pattern, String channel, String message) {
                    System.out.println(pattern + "=" + channel + "=" + message);
                }

                @Override
                public void onMessage(String channel, String message) {
                    System.out.println(channel + "=" + message);
                }
            };

            //Jedis jedis2 = JedisUtils.getJedis();
            //jedis2.subscribe(jedisPubSub, "channel_1");

            //按一定模式批量订阅
            //jedis.psubscribe(jedisPubSub, new String[]{"channel_*"});
            //jedis.publish("channel_1", "bar123");
            //jedis.publish("channel_2", "hello watson");

            //数据过期设置
            jedis.set("name", "John Doe");
            //（-1表示永不过期）
            Long ttl = jedis.ttl("name");
            System.out.println(ttl);
            Boolean b = jedis.exists("name");
            System.out.println(b);
            jedis.expire("name", 5);
            jedis.expireAt("name", 1316805000);

            //#7.管理命令
            //Redis支持多个DB，默认是16个，你可以设置将数据存在哪一个DB中，不同DB间的数据具有隔离性。也可以在多个DB间移动数据。
            jedis.select(0);
            jedis.set("name", "John Doe");
            jedis.select(1);
            jedis.get("name");
            jedis.select(0);
            jedis.move("name", 1);
            jedis.select(1);
            jedis.get("name");
            jedis.select(0);

            Long dbSize = jedis.dbSize();
            System.out.println(dbSize);
            String info = jedis.info();
            System.out.println(info);
            //对某个DB数据进行清除
            jedis.flushDB();
            //清空所有数据
            jedis.flushAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

}