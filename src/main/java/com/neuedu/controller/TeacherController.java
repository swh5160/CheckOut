package com.neuedu.controller;


import com.neuedu.common.ResultJson;
import com.neuedu.service.CollegeService;
import com.neuedu.service.FileService;
import com.neuedu.service.TeacherService;
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
        return ResultJson.success(teacherService.list(pageNo,pageSize,val));
    }

    @PostMapping("/add")
    ResultJson add(String name, String tel, String email, Integer collegeId, String password, MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException,
            InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return ResultJson.success(
                teacherService.add(name,tel,email,collegeId,password,file),"添加成功");
    }

    @GetMapping("/getCollegeWithTeacherById")
    ResultJson getCollegeWithTeacherById(){
        return  ResultJson.success(collegeService.findByIds());
    }
}
