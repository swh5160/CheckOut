package com.neuedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 施子安
 * @create
 */
@SpringBootApplication
@MapperScan("com.neuedu.mapper")
@EnableTransactionManagement
public class CheckOutApplication {
    public static void main(String[] args) {
            SpringApplication.run(CheckOutApplication.class);

    }
}
