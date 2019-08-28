package com.mengcc.ms.adminuser;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.mengcc.ms", "com.mengcc.*.config"},exclude = DruidDataSourceAutoConfigure.class)
public class BaseAdminUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseAdminUserApplication.class, args);
    }

}
