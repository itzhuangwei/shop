package com.zwx.manage.impl;

import com.zwx.api.member.entity.UserEntity;
import com.zwx.common.constants.DBTableName;
import com.zwx.dao.UserDao;
import com.zwx.manage.UserServiceManage;
import com.zwx.util.DateUtils;
import com.zwx.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 文希
 * @create 2019-09-10 14:54
 */
@Service
@Slf4j
public class UserServiceManageImpl implements UserServiceManage {

    @Autowired
    private UserDao userDao;

    /**
     * 注册
     *
     * @param userEntity
     */
    @Override
    public void register(UserEntity userEntity) {
        userEntity.setCreated(DateUtils.getTimestamp());
        userEntity.setUpdated(DateUtils.getTimestamp());
        String phone = userEntity.getPhone();
        String password = userEntity.getPassword();
        userEntity.setPassword(md5PassSalt(phone, password));
        userDao.save(userEntity, DBTableName.TABLE_MB_USER);
    }

    /**
     * md5对密码进行加密
     *
     * @param phone
     * @param password
     * @return
     */
    @Override
    public String md5PassSalt(String phone, String password) {
        String newPass = MD5Util.MD5(phone + password);
        return newPass;
    }
}
