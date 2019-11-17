
package com.zwx.message.mq.distribute;

import com.alibaba.fastjson.JSONObject;
import com.zwx.common.constants.MessageType;
import com.zwx.message.adapter.MessageAdapter;
import com.zwx.message.service.SMSMailboxService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author 庄文希
 * @classDesc: 功能描述:(消费消息 mq 从队列获取最新消息)
 */
@Slf4j
@Component
public class ConsumerDistribute {
    @Autowired
    private SMSMailboxService smsMailboxService;

    /**
     * 接收生产者的消息
     *
     * @param json
     */
    @JmsListener(destination = "mail_queue")
    public void distribute(String json) {
        log.info("###消息服务###收到消息,消息内容 json:{}", json);
        if (StringUtils.isEmpty(json)) {
            return;
        }
        JSONObject jsonObject = new JSONObject().parseObject(json);
        JSONObject header = jsonObject.getJSONObject("header");
        String interfaceType = header.getString("interfaceType");
        MessageAdapter messageAdapter = null;
        switch (interfaceType) {
            // 发送邮件
            case MessageType.SMS_MAIL:
                messageAdapter = smsMailboxService;
                break;

            default:
                break;
        }
        JSONObject content = jsonObject.getJSONObject("content");
        messageAdapter.distribute(content);

    }

}
