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
 * 学院表
 * </p>
 *
 * @author 施子安
 * @since 2022-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class College implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学院名称
     */
    private String name;

    /**
     * 状态
     */
    private Boolean active;

    public College(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public College(String name) {
        this.name = name;
    }
}
