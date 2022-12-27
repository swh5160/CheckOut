package com.neuedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 教师表
 * </p>
 *
 * @author 施子安
 * @since 2022-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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
    private Integer collegeId;

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


    public Teacher(Integer id, String name, String tel, String email, Integer collegeId) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.collegeId = collegeId;

    }

    public Teacher(String name, String tel, String email, Integer collegeId, String password, String icon) {
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.collegeId = collegeId;
        this.password = password;
        this.icon = icon;
    }



}
