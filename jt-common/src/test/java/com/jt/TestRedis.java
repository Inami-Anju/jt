package com.jt;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * 测试redis相关功能
 * 连接到虚拟机dsCentOS-redis
 * host：192.168.64.137
 */
public class TestRedis {
    @Test
    //测试存string的数据结构
    public void test1(){
        Jedis jedis=new Jedis("192.168.64.137",6379);
        jedis.set("1809", "学习redis");
        String result=jedis.get("saki");
        System.out.println(result);
    }
    //测试hash值
/*    public void test2(){
        Jedis jedis=new Jedis("192.168.64.137",6379);
        jedis.hset("person", "name", "mike");
        jedis.hset("person", "age"”,"18");
        final Map<String, String> person = jedis.hgetAll("person");
        System.out.println(person);
    }*/
    @Test
    public void test2(){
        Jedis jedis=new Jedis("192.168.64.137",6379);
        jedis.hset("person", "name", "mike");
        jedis.hset("person", "age", "18");
        final Map<String, String> person = jedis.hgetAll("person");
        System.out.println(person);
    }
    @Test//注意，每运行一次就向list里存了一个123
    public void test3(){
        Jedis jedis=new Jedis("192.168.64.137",6379);
        jedis.lpush("list", "1","2","3");
        final String s = jedis.rpop("list");
        System.out.println(s);
    }
}
