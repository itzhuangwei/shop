package com.zwx.api.member.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author 文希
 * @create 2019-09-08 11:59
 */
@RequestMapping("/demo")
public interface DemoService {

    @GetMapping("/index")
    public Map<String, Object> index();

    @GetMapping("/setKey")
    public Map<String, Object> setKey(String key, Object value);

    @GetMapping("/getKey")
    public Map<String, Object> getKey(String key);
}
