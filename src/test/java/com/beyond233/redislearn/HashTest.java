package com.beyond233.redislearn;

import com.alibaba.fastjson.JSON;
import com.beyond233.redislearn.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Hash类型相关api测试
 */
@SpringBootTest
@Slf4j
public class HashTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void read() {
        Object score = stringRedisTemplate.opsForHash().get("scoremap", "andy");
        Integer i = Integer.parseInt((String) score);
        System.out.println(i);
    }

    @Test
    public void write() {
        User user = new User();
        user.setName("小徐");
        user.setGender("男");
        user.setAge(22);

        String userJson = JSON.toJSONString(user);
        stringRedisTemplate.opsForHash().put("usermap", "user:1", userJson);
    }

    /**
     * 读取并转换为对象
     */
    @Test
    public void transObject() {
        String userStr = (String) stringRedisTemplate.opsForHash().get("usermap", "user:1");
        System.err.println("读取到的字符串： " + userStr);

        User user = JSON.toJavaObject(JSON.parseObject(userStr), User.class);

        System.err.println("解析后的user对象： " + user.toString());
    }


}
