package com.neuedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.entity.Claz;
import com.neuedu.mapper.ClazMapper;
import com.neuedu.service.ClazService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 班级表 服务实现类
 * </p>
 *
 * @author 施子安
 * @since 2023-02-05
 */
@Service
public class ClazServiceImpl extends ServiceImpl<ClazMapper, Claz> implements ClazService {


    @Override
    public Boolean add(String name, Integer count, Integer teacherId, Integer collegeId) {
        return null;
    }

    @Override
    public IPage<Claz> list(Integer pageNo, Integer pageSize, String val) {
        QueryWrapper<Claz> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(val)){
            queryWrapper.like("id",val)
                    .or().like("name",val)
                    .or().like("count",val)
                    .or().like("teacherId",val)
                    .or().like("teacherName",val)
                    .or().like("collegeId",val)
                    .or().like("collegeName",val);
        }
//倒序
        queryWrapper.orderByDesc("id");
        return this.page(new Page<>(pageNo,pageSize),queryWrapper);
    }

    @Override
    public Boolean update(Integer id, String name, Integer count, Integer teacherId, Integer collegeId) {
        return null;
    }
}
