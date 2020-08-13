package com.beyond233.redislearn;

import com.beyond233.redislearn.util.RedisOperator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Set;

@SpringBootTest
@Slf4j
class ValueTest {

    @Autowired
    private RedisOperator operator;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void getNumberValue() {
        Object a = redisTemplate.opsForValue().get("a");
        System.out.println(a);
    }



}
