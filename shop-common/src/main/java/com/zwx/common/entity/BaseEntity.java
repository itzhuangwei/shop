package com.zwx.common.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author 文希
 * @create 2019-09-08 22:06
 */
@Getter
@Setter
public class BaseEntity implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Timestamp created;
    /**
     * 修改时间
     */
    private Timestamp updated;
}
