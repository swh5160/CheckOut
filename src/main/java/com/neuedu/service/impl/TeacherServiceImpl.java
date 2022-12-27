package com.neuedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.entity.Teacher;
import com.neuedu.mapper.TeacherMapper;
import com.neuedu.service.FileService;
import com.neuedu.service.TeacherService;
import io.minio.errors.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * 教师表 服务实现类
 * </p>
 *
 * @author 施子安
 * @since 2022-12-20
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    //注入密码加密组件
    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Resource
    FileService fileService;

    String bucket = "icon";

    @Override
    public IPage<Teacher> list(int pageNo, int pageSize, Object val) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        //提升性能如果没有要查询的信息如何
        if(StringUtils.isNotBlank((CharSequence) val)){
            queryWrapper.like("id",val)
                    .or().like("name",val)
                    .or().like("tel",val)
                    .or().like("email",val);
        }
        //倒序
        queryWrapper.orderByDesc("id");
        return this.page(new Page<>(pageNo,pageSize),queryWrapper);
    }

    @Override
    public Boolean add(String name, String tel, String email, Integer collegeId, String collegeName, String password, MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        Teacher teacher = new Teacher(
                name,
                tel,
                email,
                collegeId,
                collegeName,
                bCryptPasswordEncoder.encode(password),
                fileService.upload("icon",file)
        );
        return this.save(teacher);
    }


    @Override
    public Boolean update(Integer id, String name, String tel, String email,Integer collegeId, String collegeName, MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        Teacher teacher = new Teacher(id,name,tel,email,collegeId,collegeName);
        if (file != null && file.getSize() > 0){
            teacher.setIcon(fileService.upload("icon",file));
        }
        return this.updateById(teacher);
    }
}
