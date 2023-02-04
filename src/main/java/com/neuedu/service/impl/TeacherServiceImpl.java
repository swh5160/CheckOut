package com.neuedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.entity.College;
import com.neuedu.entity.Teacher;
import com.neuedu.mapper.TeacherMapper;
import com.neuedu.service.CollegeService;
import com.neuedu.service.FileService;
import com.neuedu.service.TeacherService;
import com.neuedu.vo.TeacherVo;
import io.minio.errors.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

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
    CollegeService collegeService;

    @Resource
    FileService fileService;

    String bucket = "icon";

    @Override
    public IPage<Teacher> list(int pageNo, int pageSize,Object val) {
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
    public Boolean add(String name, String tel, String email, Integer collegeId, String password, MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        Teacher teacher = new Teacher(
                name,
                tel,
                email,
                collegeId,
                bCryptPasswordEncoder.encode(password),
                fileService.upload("icon",file)
        );
        return this.save(teacher);
    }


    @Override
    public Boolean update(Integer id, String name, String tel, String email, Integer collegeId, MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        Teacher teacher = new Teacher(id,name,tel,email,collegeId);
        if (file != null && file.getSize() > 0){
            teacher.setIcon(fileService.upload("icon",file));
        }
        return this.updateById(teacher);
    }

    @Override
    public IPage<TeacherVo> teacherlist(Integer pageNo, Integer pageSize, String val) {
        //查询所有teacher数据
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        //模糊查询列
        if(!StringUtils.isEmpty(val)){
            queryWrapper.like("id",val)
                    .or().like("name",val)
                    .or().like("tel",val)
                    .or().like("email",val);
        }
        //查询教师信息
        List<Teacher> teacherList = baseMapper.selectList(queryWrapper);
        //查询学院信息
        List<College> collegeList = collegeService.list(null);
        List<TeacherVo> teacherVoList = teacherList.stream().map((item) -> {
            TeacherVo teacherVo = new TeacherVo();
            BeanUtils.copyProperties(item, teacherVo);
            for (College college : collegeList) {
                if (college.getId().equals(item.getCollegeId())) {
                    teacherVo.setCollegeName(college.getName());
                }
            }
            return teacherVo;
        }).collect(Collectors.toList());
        Page<TeacherVo> voPage = new Page<>(pageNo, pageSize);
        //数据总共条数
        int count = this.count();
        voPage.setRecords(teacherVoList);
        voPage.setTotal(count);
        return voPage;
    }


}
