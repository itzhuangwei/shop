package com.zwx.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zwx.api.member.entity.UserEntity;
import com.zwx.api.member.service.UserService;
import com.zwx.common.api.BaseApiService;
import com.zwx.common.constants.MessageType;
import com.zwx.manage.UserServiceManage;
import com.zwx.mq.producer.RegisterMailboxProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import java.util.Map;

/**
 * @author 文希
 * @create 2019-09-10 14:31
 */
@Slf4j
@RestController
public class UserServiceImpl extends BaseApiService implements UserService {

    @Autowired
    private UserServiceManage userServiceManage;

    @Autowired
    private RegisterMailboxProducer registerMailboxProducer;

    @Value("${messages.queue}")
    private String messageQueue;


    @Override
    public Map<String, Object> regist(@RequestBody UserEntity userEntity) {

        if (StringUtils.isEmpty(userEntity.getUserName())) {
            return setResutParameterError("用户名称不能为空!");
        }
        if (StringUtils.isEmpty(userEntity.getPassword())) {
            return setResutParameterError("密码不能为空!");
        }

        try {
            //TODO 判断用户是否注册过

            userServiceManage.register(userEntity);
            //  注册成功后,调用消息服务接口,推送一条邮箱注册成功通知。
            String email = userEntity.getEmail();
            String message = message(email);
            log.info("###register()调用消息中间 发送注册成功邮箱通知结果 message:{}", message);
            sendMess(message);

        } catch (Exception e) {
            log.error("###regist() ERRPR:", e);
            return setError("注册失败！！");
        }
        return setResultSuccess();
    }

    /**
     * 拼接消息体
     *
     * @param mail
     * @return
     */
    private String message(String mail) {
        JSONObject root = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("interfaceType", MessageType.SMS_MAIL);
        JSONObject content = new JSONObject();
        content.put("mail", mail);
        root.put("header", header);
        root.put("content", content);
        return root.toJSONString();
    }

    /**
     * 发送消息
     *
     * @param json
     */
    private void sendMess(String json) {
        Destination activeMQQueue = new ActiveMQQueue(messageQueue);
        registerMailboxProducer.sendMess(activeMQQueue, json);
    }


}
