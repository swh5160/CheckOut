package com.neuedu.controller;


import com.neuedu.common.ResultJson;
import com.neuedu.entity.Claz;
import com.neuedu.service.ClazService;
import com.neuedu.service.CollegeService;
import com.neuedu.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 班级表 前端控制器
 * </p>
 *
 * @author 施子安
 * @since 2023-02-05
 */
@RestController
@RequestMapping("/claz")
public class ClazController {

    @Resource
    ClazService clazService;

    @Resource
    CollegeService collegeService;
    @Resource
    TeacherService teacherService;
    @GetMapping("/list")
    ResultJson list(Integer pageNo , Integer pageSize, String val){
        return ResultJson.success(clazService.list(pageNo,pageSize,val));
    }

    @PostMapping("/add")
    ResultJson add(String name,Integer count,Integer teacherId, Integer collegeId){
        return  ResultJson.success(clazService.add(name,count,teacherId,collegeId),"添加成功");
    }
    @PostMapping("/update")
    ResultJson add(Integer id ,String name,Integer count,Integer teacherId, Integer collegeId){
        return  ResultJson.success(clazService.update(id,name,count,teacherId,collegeId),"添加成功");
    }

    @PostMapping("/del")
    ResultJson del(Integer id,Boolean active){
        Claz claz = new Claz();
        claz.setId(id);
        claz.setActive(active);
        return ResultJson.success(clazService.updateById(claz),active ? "恢复成功" : "删除成功");
    }

    @GetMapping("getOne")
    ResultJson getOne(Integer id){
        return ResultJson.success(clazService.getById(id));
    }

    //查询所有老师信息
    @GetMapping("/getTeacherWithClaz")
    ResultJson getTeacherWithClaz(){
        return ResultJson.success(teacherService.findByIds());
    }

    //查询学院信息
    @GetMapping("/getCollegeWithClaz")
    ResultJson getCollegeWithClaz(){
        return ResultJson.success(collegeService.findByIds());
    }


}
