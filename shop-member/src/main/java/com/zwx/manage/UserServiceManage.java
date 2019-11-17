package com.zwx.manage;

import com.zwx.api.member.entity.UserEntity;

/**
 * 会员服务的管理
 *
 * @author 文希
 * @create 2019-09-10 14:34
 */
public interface UserServiceManage {

    public void register(UserEntity userEntity);

    public String md5PassSalt(String phone,String password);

}
