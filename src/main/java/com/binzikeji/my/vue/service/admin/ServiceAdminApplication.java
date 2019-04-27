package com.binzikeji.my.vue.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description
 * @Author Bin
 * @Date 2019/4/27 11:14
 **/
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@MapperScan(basePackages = {"com.binzikeji.my.vue.service.admin.mapper"})
public class ServiceAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAdminApplication.class, args);
    }
}
