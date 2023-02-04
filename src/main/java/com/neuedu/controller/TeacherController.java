package com.neuedu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.common.ResultJson;
import com.neuedu.entity.Teacher;
import com.neuedu.service.CollegeService;
import com.neuedu.service.FileService;
import com.neuedu.service.TeacherService;
import com.neuedu.vo.TeacherVo;
import io.minio.errors.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * 教师表 前端控制器
 * </p>
 *
 * @author 施子安
 * @since 2022-12-27
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Resource
    TeacherService teacherService;

    @Resource
    CollegeService collegeService;

    @Resource
    FileService fileService;

    @GetMapping("/list")
    ResultJson list(Integer pageNo, Integer pageSize,String val){
       // return ResultJson.success(teacherService.list(pageNo,pageSize,val));
        IPage<TeacherVo> page=teacherService.teacherlist(pageNo,pageSize,val);
        return ResultJson.success(page);

    }

    @PostMapping("/add")
    ResultJson add(String name, String tel, String email, Integer collegeId, String password, MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException,
            InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return ResultJson.success(
                teacherService.add(name,tel,email,collegeId,password,file),"添加成功");
    }

    @GetMapping("/getCollegeWithTeacher")
    ResultJson getCollegeWithTeacherById(){
        return  ResultJson.success(collegeService.findByIds());
    }

    //通过当前collegeId查询college表中的name
   /* @GetMapping("/getColegeWithTeacherFindByName")
    ResultJson getColegeWithTeacherFindByName(Integer collegeId){
        System.out.println(collegeId+"-------");
        return ResultJson.success(collegeService.getById(collegeId));
    }*/
    @PostMapping("/update")
    ResultJson update(Integer id, String name, String tel, String email, Integer collegeId, MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return ResultJson.success(teacherService.update(id,name,tel,email,collegeId,file),"修改成功");
    }

    @GetMapping("/getOne")
    ResultJson getOne(Integer id){
        return ResultJson.success(teacherService.getById(id));
    }

    @PostMapping("/del")
    ResultJson del(Integer id,Boolean active){
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setActive(active);
        return ResultJson.success(teacherService.updateById(teacher),active ? "恢复成功" : "删除成功");
    }
}
