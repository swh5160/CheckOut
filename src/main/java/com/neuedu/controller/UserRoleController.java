package com.neuedu.controller;


import com.neuedu.common.ResultJson;
import com.neuedu.service.RoleService;
import com.neuedu.service.TeacherService;
import com.neuedu.service.UserRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色用户关联表 前端控制器
 * </p>
 *
 * @author 施子安
 * @since 2023-02-11
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Resource
    RoleService roleService;

    @Resource
    UserRoleService userRoleService;

    @Resource
    TeacherService teacherService;

    @GetMapping("/getDataByUser")
    ResultJson getDataByUser(Integer userId){
        Map<String, List> map = new HashMap<>();
        map.put("roles",roleService.getActive());
        map.put("values",userRoleService.getByUserId(userId));
        return ResultJson.success(map);
    }
    @GetMapping("/getDataByRole")
    ResultJson getDataByRole(Integer roleId){
        Map<String, List> map = new HashMap<>();
        map.put("users",teacherService.getActive());
        map.put("values",userRoleService.getByRoleId(roleId));
        return ResultJson.success(map);
    }
    @PostMapping ("/save")
    ResultJson save(Integer userId,Integer[] roleIds){
        return ResultJson.success(userRoleService.save(userId,roleIds),"关联成功");
    }
    @PostMapping ("/saveByRole")
    ResultJson saveByRole(Integer roleId,Integer[] userIds){
        return ResultJson.success(userRoleService.saveByRole(roleId,userIds),"关联成功");
    }

}
