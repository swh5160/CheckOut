package com.neuedu.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 施子安
 * @create
 */
public class SwhGenerator {
    public static void main(String[] args) {
        String table="role";
        //创建生成器对象
        AutoGenerator ag = new AutoGenerator();
        //获取项目路径
        String base_path = System.getProperty("user.dir");
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(base_path + "/src/main/java");
        gc.setAuthor("施子安");
        gc.setOpen(false);
        //去掉service接口名的I
        gc.setServiceName("%sService");
        ag.setGlobalConfig(gc);
        //数据源配置
        DataSourceConfig dsc=new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://192.168.80.120:3307/checkout?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        ag.setDataSource(dsc);
        //包配置
        PackageConfig pc=new PackageConfig();
        pc.setParent("com.neuedu");
        //配置xml的路径
        Map<String,String> pathInfo=new HashMap<>();
        pathInfo.put("entity_path",base_path+"/src/main/java/com/neuedu/entity");
        pathInfo.put("mapper_path",base_path+"/src/main/java/com/neuedu/mapper");
        pathInfo.put("controller_path",base_path+"/src/main/java/com/neuedu/controller");
        pathInfo.put("service_path",base_path+"/src/main/java/com/neuedu/service");
        pathInfo.put("service_impl_path",base_path+"/src/main/java/com/neuedu/service/impl");
        pathInfo.put("xml_path",base_path+"/src/main/resources/com/neuedu/mapper");
        pc.setPathInfo(pathInfo);
        ag.setPackageInfo(pc);
        //策略配置
        StrategyConfig sc=new StrategyConfig();
        //表名在生成entity类型的时候下划线转驼峰
        sc.setNaming(NamingStrategy.underline_to_camel);
        //列名在生成属性名的时候 下划线转驼峰
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        ag.setStrategy(sc);
        //是否加lombok注解
        sc.setEntityLombokModel(true);
        //是否Controller层加RestController注解
        sc.setRestControllerStyle(true);
        //需要生成的表名
        sc.setInclude(table);
        //配置模板引擎
        ag.setTemplateEngine(new FreemarkerTemplateEngine());
        //执行代码生成
        ag.execute();
    }
}
