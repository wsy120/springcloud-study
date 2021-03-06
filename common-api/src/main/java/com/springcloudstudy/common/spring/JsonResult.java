package com.springcloudstudy.common.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloudstudy.common.exception.ServiceException;

/**
 * Created by sudongsheng on 2018/7/2
 */
public class JsonResult<T> {

    /**
     * 通用错误提示码
     */
    public static final ServiceException ERR_INVALID_HEADER = new ServiceException(2001, "非法请求头");


    public static final ServiceException ERR_INVALID_PARAMS = new ServiceException(1000, "请求参数异常");
    public static final ServiceException ERR_USER_NOT_EXIST = new ServiceException(1001, "用户不存在");
    public static final ServiceException ERR_UER_ADDRESS_EXIST = new ServiceException(1002, "地址不存在");
    public static final ServiceException ERR_USER_SERVICE = new ServiceException(1003, "用户服务异常");
    public static final ServiceException ERR_ADDRESS_SERVICE = new ServiceException(1004, "地址服务异常");

    public int code;

    public String message;

    public T data;

    /**
     * 成功返回
     */
    public JsonResult() {
    }

    /**
     * 成功返回
     */
    public JsonResult(T data) {
        this.data = data;
    }

    public JsonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
