package com.neuedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.entity.Claz;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 班级表 服务类
 * </p>
 *
 * @author 施子安
 * @since 2023-02-05
 */
public interface ClazService extends IService<Claz> {

    Boolean add(String name, Integer count, Integer teacherId, Integer collegeId);

    IPage<Claz> list(Integer pageNo, Integer pageSize, String val);

    Boolean update(Integer id, String name, Integer count, Integer teacherId ,Integer collegeId);
}
