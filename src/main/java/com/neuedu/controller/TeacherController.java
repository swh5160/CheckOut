package com.neuedu.controller;


import com.neuedu.common.ResultJson;
import com.neuedu.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    @GetMapping("/list")
    ResultJson list(Integer pageNo,Integer pageSize,String val){
        return ResultJson.success(teacherService.list(pageSize,pageNo,val));
    }

//    @PostMapping("/add")
//    ResultJson add(String name, String tel, String email, Integer collegeId, String collegeName, String password, MultipartFile file){
//        return ResultJson.success(teacherService.add(name,tel,email,collegeId,collegeName,password,file),"添加成功");
//    }
}
