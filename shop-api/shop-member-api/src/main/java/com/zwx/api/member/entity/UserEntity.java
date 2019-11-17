package com.zwx.api.member.entity;

import com.zwx.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 文希
 * @create 2019-09-10 14:25
 */
@Getter
@Setter
public class UserEntity extends BaseEntity {

    private String userName;

    private String password;

    private String phone;

    private String email;


}
