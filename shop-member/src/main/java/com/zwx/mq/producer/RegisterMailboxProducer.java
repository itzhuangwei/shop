
package com.zwx.mq.producer;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @classDesc: 功能描述:(往消息服务 推送 邮件信息)
 */
@Service("registerMailboxProducer")
public class RegisterMailboxProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 消息服务的发送者
     *
     * @param destination 队列
     * @param json        消息
     */
    public void sendMess(Destination destination, String json) {
        jmsMessagingTemplate.convertAndSend(destination, json);
    }
}
