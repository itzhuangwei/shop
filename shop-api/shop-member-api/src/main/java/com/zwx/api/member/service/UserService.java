package com.zwx.api.member.service;

import com.zwx.api.member.entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author 文希
 * @create 2019-09-10 14:29
 */
@RequestMapping("/member")
public interface UserService {

    /**
     * 用户注册接口
     *
     * @param userEntity
     * @return
     */
    @PostMapping("/regist")
    public Map<String, Object> regist(@RequestBody UserEntity userEntity);
}
