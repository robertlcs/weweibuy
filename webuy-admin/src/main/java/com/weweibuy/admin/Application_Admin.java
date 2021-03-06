package com.weweibuy.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName Application_Admin
 * @Description
 * @Author durenhao
 * @Date 2018/10/26 23:43
 **/
@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableAdminServer
public class Application_Admin {

    public static void main(String[] args) {
        SpringApplication.run(Application_Admin.class);
    }
}
