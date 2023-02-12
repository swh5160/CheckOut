package com.neuedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.entity.UserRole;

import java.util.List;

/**
 * <p>
 * 角色用户关联表 服务类
 * </p>
 *
 * @author 施子安
 * @since 2023-02-11
 */
public interface UserRoleService extends IService<UserRole> {
    Boolean save(Integer userId, Integer[] roleIds);

    List<UserRole> getByUserId(Integer userId);

    List<UserRole> getByRoleId(Integer roleId);

    Boolean saveByRole(Integer roleId, Integer[] userIds);
}
