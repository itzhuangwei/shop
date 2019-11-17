package com.zwx.common.mybatis;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

/**
 * @author 文希
 * @create 2019-09-08 23:34
 */
public interface BaseDao {

    /**
     * 添加
     *
     * @param oj    实体类
     * @param table 表明
     */
    @InsertProvider(type = BaseProvider.class, method = "save")
    public void save(@Param("oj") Object oj, @Param("table") String table);

    /**
     * 修改
     *
     * @param oj    实体类
     * @param table 表明
     * @param idKey 主键
     */
    @InsertProvider(type = BaseProvider.class, method = "update")
    public void update(@Param("oj") Object oj, @Param("table") String table, @Param("idKey") Long idKey);


}
