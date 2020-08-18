package com.beyond233.redislearn;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * redis事务
 *
 * @author XuJie
 * @date 2020/8/17 11:56
 */
@SpringBootTest
@Slf4j
public class TransactionTest {
    @Resource(name = "stringRedisTemplate")
    private StringRedisTemplate template;

    @Test
    public void test1() {
        //start
        template.opsForValue().set("number", "1");
        template.watch("number");

        template.multi();

        //command queue
        template.opsForValue().increment("number");

        //commit
        List<Object> exec = template.exec();
        System.err.println(exec);


    }
}
