package com.beyond233.redislearn;

import com.beyond233.redislearn.util.RedisOperator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisOperatorTest {

    @Autowired
    private RedisOperator operator;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void getValue() {
        Object a = redisTemplate.opsForValue().get("a");
        System.out.println(a);

    }

}
