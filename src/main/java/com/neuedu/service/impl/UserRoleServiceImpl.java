package com.neuedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.entity.UserRole;
import com.neuedu.mapper.UserRoleMapper;
import com.neuedu.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色用户关联表 服务实现类
 * </p>
 *
 * @author 施子安
 * @since 2023-02-11
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    @Transactional
    public Boolean save(Integer userId, Integer[] roleIds) {

        UpdateWrapper<UserRole> userRoleUpdateWrapper = new UpdateWrapper<>();
        userRoleUpdateWrapper.eq("user_id",userId);
        this.remove(userRoleUpdateWrapper);
        List<UserRole> list = new ArrayList<>();
        if (null != roleIds){
            for (Integer roleId : roleIds) {
               list.add(new UserRole(userId,roleId));
            }
        }

        return this.saveBatch(list);
    }

    @Override
    public List<UserRole> getByUserId(Integer userId) {
        QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        return this.list(wrapper);
    }

    @Override
    public List<UserRole> getByRoleId(Integer roleId) {
        QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",roleId);
        return this.list(wrapper);
    }

    @Override
    @Transactional
    public Boolean saveByRole(Integer roleId, Integer[] userIds) {
        UpdateWrapper<UserRole> userRoleUpdateWrapper = new UpdateWrapper<>();
        userRoleUpdateWrapper.eq("role_id",roleId);
        this.remove(userRoleUpdateWrapper);
        List<UserRole> list = new ArrayList<>();
        if (null != userIds){
            for (Integer userId : userIds) {
                list.add(new UserRole(roleId,userId));
            }
        }
        return this.saveBatch(list);
    }
}
