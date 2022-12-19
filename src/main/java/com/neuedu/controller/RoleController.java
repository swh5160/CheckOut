package com.neuedu.controller;


import com.neuedu.common.ResultJson;
import com.neuedu.entity.Role;
import com.neuedu.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author 施子安
 * @since 2022-12-06
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    RoleService roleService;
    @GetMapping("/list")
    ResultJson list(Integer pageNo, Integer pageSize,String val){
        return ResultJson.success(roleService.list(pageNo,pageSize,val));
    }
    @PostMapping("/add")
    ResultJson add(String name){
        return ResultJson.success(roleService.add(name),"添加成功");
    }

    @GetMapping("/getOne")
    ResultJson getOne(Integer id){
        return ResultJson.success(roleService.getById(id));
    }
    @PostMapping("/update")
    ResultJson update(Integer id ,String name){
        return ResultJson.success(roleService.update(id,name),"修改用户成功");
    }
    @PostMapping("del")
    ResultJson del(Integer id,Boolean acitve){
        Role role = new Role();
        role.setId(id);
        role.setAcitve(acitve);
        return ResultJson.success(roleService.updateById(role),acitve ? "恢复成功" : "删除成功");
    }
}
