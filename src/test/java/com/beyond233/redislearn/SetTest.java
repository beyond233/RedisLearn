package com.beyond233.redislearn;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Set;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-08-13 21:35
 */
@SpringBootTest
@Slf4j
public class SetTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 读
     * */
    @Test
    public void getStringValue(){
        Set<String> set = stringRedisTemplate.opsForSet().members("nameset");
        System.out.println(set);
    }
}
