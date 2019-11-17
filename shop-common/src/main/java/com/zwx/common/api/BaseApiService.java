package com.zwx.common.api;

import com.zwx.common.constants.BaseApiConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用baseapi的父类
 *
 * @author 文希
 * @create 2019-09-08 14:23
 */
public class BaseApiService {

    /**
     * 错误
     *
     * @param message
     * @return
     */
    public Map<String, Object> setError(String message) {
        return setResult(BaseApiConstants.HTTP_RES_CODE_500, message, null);
    }

    /**
     * 错误
     *
     * @return
     */
    public Map<String, Object> setError() {
        return setResult(BaseApiConstants.HTTP_RES_CODE_500, BaseApiConstants.HTTP_RES_CODE_500_VALUE, null);
    }

    public Map<String, Object> setResutParameterError(String msg) {
        return setResult(BaseApiConstants.HTTP_RES_CODE_400, msg, null);
    }

    /**
     * 成功
     *
     * @return
     */
    public Map<String, Object> setResultSuccess() {
        return setResult(BaseApiConstants.HTTP_RES_CODE_200, BaseApiConstants.HTTP_RES_CODE_200_VALUE, null);
    }

    /**
     * 成功
     *
     * @return
     */
    public Map<String, Object> setResultSuccess(Object data) {
        return setResult(BaseApiConstants.HTTP_RES_CODE_200, BaseApiConstants.HTTP_RES_CODE_200_VALUE, data);
    }

    /**
     * 成功
     *
     * @param message
     * @return
     */
    public Map<String, Object> setResult(String message) {
        return setResult(BaseApiConstants.HTTP_RES_CODE_200, message, null);
    }

    /**
     * 自定义返回
     *
     * @param code
     * @param message
     * @param data
     * @return
     */
    public Map<String, Object> setResult(Integer code, String message, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put(BaseApiConstants.HTTP_RES_CODE_NAME, code);
        result.put(BaseApiConstants.HTTP_RES_CODE_MSG, message);
        if (data != null) {
            result.put(BaseApiConstants.HTTP_RES_CODE_DATA, data);
        }
        return result;
    }
}
