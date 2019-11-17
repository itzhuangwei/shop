package com.zwx.message.adapter;

import com.alibaba.fastjson.JSONObject;

/**
 * 创建适配器接口
 *
 * @author 文希
 * @create 2019-09-10 21:18
 */
public interface MessageAdapter {

    public void distribute(JSONObject jsonObject);
}
