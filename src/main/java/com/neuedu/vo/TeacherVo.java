package com.neuedu.vo;

import lombok.Data;

/**
 * @author 施子安
 * @create
 */
@Data
public class TeacherVo {
    private Integer id;

    /**
     * 教师名称
     */
    private String name;

    /**
     * 手机号
     */
    private String tel;

    /**
     * 邮件
     */
    private String email;

    /**
     * 学院id
     */
    private String collegeName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 状态
     */
    private Boolean active;
}
