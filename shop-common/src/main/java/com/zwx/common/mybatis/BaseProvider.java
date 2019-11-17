package com.zwx.common.mybatis;

import com.zwx.util.ReflectionUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * 拼接SQL语句
 *
 * @author 文希
 * @create 2019-09-08 23:35
 */
public class BaseProvider {

    public String save(Map<String, Object> para) {
        final Object oj = para.get("oj");
        final String table = (String) para.get("table");
        String sql = new SQL() {
            {
                INSERT_INTO(table);
                String columns = ReflectionUtils.getInsertFields(oj);
                String values = ReflectionUtils.getInsertDeclaredFieldsValue(oj);
                VALUES(columns, values);
            }
        }.toString();
        return sql;
    }

    public String update(Map<String, Object> para) {
        final Object oj = para.get("oj");
        final String table = (String) para.get("table");
        final Long idKey = (Long) para.get("idKey");
        String sql = new SQL() {
            {
                UPDATE(table);
                SET(ReflectionUtils.updateAllSerField(oj));
                WHERE("id=" + idKey + "");
            }
        }.toString();
        return sql;
    }


}
