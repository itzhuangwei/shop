package com.zwx.common.log.service;

/**
 * @author 文希
 * @create 2019-11-17 22:06
 */
public interface OperatorLogService<T> {
    void save(T operatorLog);
}
