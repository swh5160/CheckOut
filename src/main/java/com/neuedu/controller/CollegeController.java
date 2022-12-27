package com.neuedu.controller;


import com.neuedu.common.ResultJson;
import com.neuedu.entity.College;
import com.neuedu.service.CollegeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 学院表 前端控制器
 * </p>
 *
 * @author 施子安
 * @since 2022-12-03
 */
@RestController
@RequestMapping("/college")
public class CollegeController {
    @Resource
    CollegeService collegeService;
    //查询所有
    @GetMapping("/list")
    ResultJson list(Integer pageNo,Integer pageSize,String val){
        return ResultJson.success(collegeService.list(pageNo,pageSize,val));
    }
    @GetMapping("/getOne")
    ResultJson getOne(Integer id){
        return ResultJson.success(collegeService.getById(id));
    }
    @PostMapping("/add")
    ResultJson add(String name){
        return ResultJson.success(collegeService.add(name),"添加成功");
    }
    @PostMapping("/update")
    ResultJson update(Integer id ,String name){
        return ResultJson.success(collegeService.update(id,name),"修改用户成功");
    }
    @PostMapping("/del")
    ResultJson del(Integer id,Boolean active){
        College college = new College();
        college.setId(id);
        college.setActive(active);
        return ResultJson.success(collegeService.updateById(college),active ? "恢复成功" : "删除成功");
    }
}
