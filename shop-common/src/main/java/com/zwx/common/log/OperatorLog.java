package com.zwx.common.log;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 文希
 * @create 2019-11-17 21:57
 */
@Data
public class OperatorLog implements Serializable {

    private String id;

    private String methodName;

    private String beanName;

    private String intf;

    private String url;

    private Date requestTime;

    private String requestIp;
    private String requestParam;

    private String flag;

    private String exceptionName;

    private String exceptionMsg;
}
