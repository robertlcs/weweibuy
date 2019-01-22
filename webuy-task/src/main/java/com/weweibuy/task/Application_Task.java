package com.weweibuy.task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 任务调度工程
 * @ClassName Application_Task
 * @Description
 * @Author durenhao
 * @Date 2018/10/16 15:17
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.weweibuy.task.dao"})
@EnableEurekaClient
@EnableDiscoveryClient
@EnableAutoConfiguration
public class Application_Task {

    public static void main(String[] args) {
        SpringApplication.run(Application_Task.class);
    }

}
