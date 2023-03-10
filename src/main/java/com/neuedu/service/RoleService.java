package com.neuedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author 施子安
 * @since 2022-12-06
 */
public interface RoleService extends IService<Role> {
    //分页查询，带搜索
    IPage<Role> list(int pageNo,int pageSize,Object val);

    Boolean add(String name);

    Boolean update(Integer id, String name);

    List<Role> getActive();
}
