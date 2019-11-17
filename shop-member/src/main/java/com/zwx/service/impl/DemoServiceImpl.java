package com.zwx.service.impl;

import com.zwx.api.member.service.DemoService;
import com.zwx.common.api.BaseApiService;
import com.zwx.common.redis.BaseRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 文希
 * @create 2019-09-08 12:01
 */
@RestController
public class DemoServiceImpl extends BaseApiService implements DemoService {

    @Autowired
    private BaseRedisService baseRedisService;

    @Override
    public Map<String, Object> index() {
        return setResultSuccess();
    }

    @Override
    public Map<String, Object> setKey(String key, Object value) {
        baseRedisService.setString(key, value.toString());
        return setResultSuccess();
    }

    @Override
    public Map<String, Object> getKey(String key) {
        Object string = baseRedisService.getString(key);
        return setResultSuccess(string);
    }
}
