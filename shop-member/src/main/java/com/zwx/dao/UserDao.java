package com.zwx.dao;

import com.zwx.api.member.entity.UserEntity;
import com.zwx.common.mybatis.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 文希
 * @create 2019-09-10 14:55
 */
@Mapper
public interface UserDao extends BaseDao {


    UserEntity getUser(UserEntity userEntity);
}
