package com.neuedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.entity.Role;
import com.neuedu.mapper.RoleMapper;
import com.neuedu.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author 施子安
 * @since 2022-12-06
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public IPage<Role> list(int pageNo, int pageSize, Object val) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        //提升性能如果没有要查询的信息如何
        if(StringUtils.isNotBlank((CharSequence) val)){
            queryWrapper.like("id",val).or().like("name",val);
        }
        //倒序
        queryWrapper.orderByDesc("id");
        return this.page(new Page<>(pageNo,pageSize),queryWrapper);
    }

    @Override
    public Boolean add(String name) {
        Role role = new Role(name);
        return this.save(role);
    }

    @Override
    public Boolean update(Integer id, String name) {
        Role role = new Role(id,name);
        return this.updateById(role);
    }

}
