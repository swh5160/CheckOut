package com.neuedu.test;

import com.neuedu.CheckOutApplication;
import com.neuedu.entity.College;
import com.neuedu.entity.Role;
import com.neuedu.service.CollegeService;
import com.neuedu.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 施子安
 * @create
 */
//runwith先加载ioc容器
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CheckOutApplication.class)
public class MybatisTest {
    @Resource
    CollegeService collegeService;
    @Resource
    RoleService roleService;
    @Test
    public void add(){
        List<College> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new College(
                    null,
                    "计算机学院" + i,
                    i % 2 == 0
            ));
        }
        /*College college = new College();
        college.setName("数据科学与软件工程学院");
        college.setActive(true);
        collegeService.save(college);*/
        collegeService.saveBatch(list);
    }
    @Test
    public void roleTest(){
        List<Role> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(new Role(null,"系统管理员"+"i",i % 2 ==0));
        }
        roleService.saveBatch(list);
    }

}
