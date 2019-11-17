package com.zwx.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 封装基本的redis操作
 *
 * @author 文希
 * @create 2019-09-08 19:50
 */
@Component
public class BaseRedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // string list map set

    public void setString(String key, String value, Long timeout) {
        stringRedisTemplate.opsForValue().set(key, value, timeout);
    }

    public void setString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, (String) value);
    }

    public void set(String key, Object value, Long timeout) {
        if (value != null) {
            if (value instanceof String) {
                stringRedisTemplate.opsForValue().set(key, String.valueOf(value));
            }
            //设置有效期
            if (timeout != null) {
                stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
            }
        }
    }

    public Object getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void delKey(String key) {
        stringRedisTemplate.delete(key);
    }


}
