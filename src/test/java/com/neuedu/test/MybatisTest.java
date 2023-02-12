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
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Test
    public void stream(){
        Object[] a = {1,2,3,"dnbiaodoa"};
        Stream.of(a).forEach(b->{
            System.out.println(b);
        });
    }

    /*
    * 一组数据判断奇数
    *
    * */
    @Test
    public void oddStream(){
        int[] arr = {1,2,3,4,5,6,7,8};
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,8);
        List<Integer> list1 = list.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        list1.forEach(a -> System.out.print(a));
    }
}
