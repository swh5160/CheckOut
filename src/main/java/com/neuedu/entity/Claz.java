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
 * 班级表
 * </p>
 *
 * @author 施子安
 * @since 2023-02-06
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Claz implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 班级名称
     */
    private String name;

    /**
     * 班级人数
     */
    private Integer count;

    /**
     * 班主任id
     */
    private Integer teacherId;

    /**
     * 学院id
     */
    private Integer collegeId;

    /**
     * 状态
     */
    private Boolean active;


}
