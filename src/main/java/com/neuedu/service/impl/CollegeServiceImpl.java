package com.neuedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.entity.College;
import com.neuedu.mapper.CollegeMapper;
import com.neuedu.service.CollegeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 学院表 服务实现类
 * </p>
 *
 * @author 施子安
 * @since 2022-12-03
 */
@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements CollegeService {

    @Override
    public IPage<College> list(int pageNo, int pageSize, Object val) {
        QueryWrapper<College> queryWrapper = new QueryWrapper<>();
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
        College college = new College(name);
        return this.save(college);
    }

    @Override
    public Boolean update(Integer id, String name) {
        College college = new College(id,name);
        return this.updateById(college);
    }

    @Override
    public List<College> findByIds() {
/*        QueryWrapper<College> wrapper = new QueryWrapper<>();
        wrapper.select("id","name");*/
        List<College> list = baseMapper.selectList(null);
        System.out.println(list.size()+"++++++++++++");
        return list;
    }


}
