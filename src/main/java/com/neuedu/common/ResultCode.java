package com.neuedu.common;

/**
 * @author 施子安
 * @create
 */
public enum  ResultCode {
    SUCCESS(200),
    FAILED(500),
    //未授权
    UNAUTH(401),
    //拒绝访问
    FORBID(403);
    private Integer code;
    ResultCode(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
