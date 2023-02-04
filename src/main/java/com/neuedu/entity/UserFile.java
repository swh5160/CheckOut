package com.neuedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 文件表
 * </p>
 *
 * @author 施子安
 * @since 2022-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文件md5
     */
    private String md5;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 后缀名称
     */
    private String extension;

    /**
     * 文件路径
     */
    private String path;


    public UserFile(String md5, Long size, String extension, String path) {
        this.md5 = md5;
        this.size = size;
        this.extension = extension;
        this.path = path;
    }

}
