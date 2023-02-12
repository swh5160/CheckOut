package com.neuedu.common;

import lombok.Getter;

/**
 * @author 施子安
 * @create
 */
@Getter
public class ResultJson {
    //编码
    private Integer code;
    //内容
    private Object content;
    //文字消息
    private String message;

    public Integer getCode() {
        return code;
    }

    public Object getContent() {
        return content;
    }

    public String getMessage() {
        return message;
    }

    public ResultJson(Integer code, Object content, String message) {
        this.code = code;
        this.content = content;
        this.message = message;
    }
//    重写静态构造方法
    private static ResultJson getInstance(ResultCode resultCode,Object content,String message){
        return new ResultJson(resultCode.getCode(),content,message);
    }
    public static ResultJson success(Object content,String message){
        return getInstance(ResultCode.SUCCESS,content,message);
    }
    public static ResultJson success(Object content){
        return success(content,null);
    }
    public static ResultJson failed(Object content,String message){
        return getInstance(ResultCode.FAILED,content,message);
    }
    public static ResultJson failed(String message){
        return  failed(null,message);
    }

    public static ResultJson unauto(String  message){
        return getInstance(ResultCode.UNAUTH,null,message);
    }

    public static ResultJson forBig(String  message){
        return getInstance(ResultCode.FORBID,null,"该用户没有权限");
    }
}
