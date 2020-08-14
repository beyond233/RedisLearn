package com.beyond233.redislearn;

import com.beyond233.redislearn.util.RedisOperator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * String类型相关api测试
 */
@SpringBootTest
@Slf4j
class ValueTest {

    @Autowired
    private RedisOperator operator;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 自增、获取
     */
    @Test
    public void getNumberValue() {
        Object a = redisTemplate.opsForValue().get("a");
        Long result = redisTemplate.opsForValue().increment("a", 10);
        System.err.println(result);
        System.err.println(redisTemplate.opsForValue().get("a"));
    }

    /**
     * 过期、获取剩余
     */
    @Test
    public void expire() throws InterruptedException {
        //添加值并设置过期时间
        redisTemplate.opsForValue().set("a", "666", 60, TimeUnit.SECONDS);
//        redisTemplate.expire("a", 60, TimeUnit.SECONDS);
        Thread.sleep(4000);
        System.err.println("key是否存活： " + redisTemplate.hasKey("a"));
        System.err.println("key剩余存活时间：" + redisTemplate.getExpire("a", TimeUnit.SECONDS));
    }

}
