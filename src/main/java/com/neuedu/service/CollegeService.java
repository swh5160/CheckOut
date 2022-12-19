package com.neuedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.entity.College;

/**
 * <p>
 * 学院表 服务类
 * </p>
 *
 * @author 施子安
 * @since 2022-12-03
 */
public interface CollegeService extends IService<College> {

    //分页查询，带搜索
    IPage<College> list(int pageNo, int pageSize, Object val);

    Boolean add(String name);

    Boolean update(Integer id, String name);
}
