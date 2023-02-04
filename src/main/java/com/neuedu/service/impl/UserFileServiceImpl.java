package com.neuedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.entity.UserFile;
import com.neuedu.mapper.UserFileMapper;
import com.neuedu.service.UserFileService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件表 服务实现类
 * </p>
 *
 * @author 施子安
 * @since 2022-12-28
 */
@Service
public class UserFileServiceImpl extends ServiceImpl<UserFileMapper, UserFile> implements UserFileService {

    @Override
    public UserFile get(String md5, Long size, String extension) {
        //条件查询
        QueryWrapper<UserFile> wrapper = new QueryWrapper<>();
        wrapper.eq("md5",md5)
                .eq("size",size)
                .eq("extension",extension);
        return this.getOne(wrapper);
    }
}
