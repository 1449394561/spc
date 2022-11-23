package com.example.spc.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class TestRedis {
    public static void main(String[] args) {
        new TestRedis().save();
//        new TestRedis().update();
//        new TestRedis().findAll();
        new TestRedis().findByKey();
//        new TestRedis().del();
//        new TestRedis().key();
//        new TestRedis().string();
//        new TestRedis().list();
//        new TestRedis().map();
//        new TestRedis().set();

//        过期时间设置
//        jedis.expire(key,expiration);
    }

    protected static Jedis jedis = new Jedis("localhost", 6379);

    //添加数据(key/value)
    public void save(){
        jedis.set("jedis", "jedis_2");
    }

    //查询所有
    public void findAll(){
        System.out.println(jedis.keys("*"));
    }

    //根据Key查询数据
    public void findByKey(){
        System.out.println(jedis.get("jedis"));
    }

    //根据Key修改数据
    public void update(){
        jedis.rename("jedis", "jedis_new");
    }

    //根据Key删除数据
    public void del() {
        jedis.del("jedis");
    }

    //操作key
    public void key() {
        System.out.println(jedis.exists("id"));
        System.out.println(jedis.del("id"));
    }

    //操作String
    public void string() {
        System.out.println(jedis.set("id", "1"));
        System.out.println(jedis.set("name", "jack"));
    }

    //操作List
    public void list() {

        // 从头添加
        jedis.lpush("list", "tom", "jack", "jason", "peter", "lc", "easy");

        // 从尾添加
        jedis.rpush("list", "andy", "eleven");

        // 返回List长度
        jedis.llen("list");

        // 取值
        List<String> list = jedis.lrange("list", 0, -1);
        for (String string : list) {
            System.out.println(string);
        }
    }

    //操作Map
    public void map() {
        jedis.hset("Mcity", "c1", "北京");
        System.out.println("取值：" + jedis.hget("city", "c1"));

        Map<String, String> map = new HashMap<String, String>();
        map.put("c1", "桂林");
        map.put("c2", "天津");
        map.put("c3", "合肥");
        jedis.hmset("Mcity2", map);

        List<String> list = jedis.hmget("Mcity2", "c1", "c2", "c3");
        for (String string : list) {
            System.out.println(string);
        }
        System.out.println(jedis.hlen("Mcity2"));
    }

    //操作Set
    public void set() {
        jedis.sadd("city", "北京", "上海", "南京", "武汉", "安徽", "广州", "深圳", "山东");
        System.out.println("取最上面的值：" + jedis.spop("city"));
        System.out.println("随机取值" + jedis.srandmember("city"));

        jedis.sadd("city2", "北京", "武汉", "河北", "张家界", "辽林", "云南", "陕西", "山西", "黑龙江");
        System.out.println("交集：" + jedis.sinter("city", "city1"));
        System.out.println("并集：" + jedis.sunion("city", "city1"));
        System.out.println("差集：" + jedis.sdiff("city", "city1"));
    }
}